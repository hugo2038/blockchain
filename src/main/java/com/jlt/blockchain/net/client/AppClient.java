package com.jlt.blockchain.net.client;

import com.google.common.base.Optional;
import com.jlt.blockchain.conf.AppConfig;
import com.jlt.blockchain.db.DBAccess;
import com.jlt.blockchain.event.FetchNextBlockEvent;
import com.jlt.blockchain.net.ApplicationContextProvider;
import com.jlt.blockchain.net.base.MessagePacket;
import com.jlt.blockchain.net.base.MessagePacketType;
import com.jlt.blockchain.net.base.Node;
import com.jlt.blockchain.net.conf.TioProps;
import com.jlt.blockchain.utils.SerializeUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.tio.client.AioClient;
import org.tio.client.ClientChannelContext;
import org.tio.client.ClientGroupContext;
import org.tio.core.Aio;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * 客户端启动程序
 * 
 *
 */
@Component
public class AppClient {

	@Resource
	private ClientGroupContext clientGroupContext;
	@Autowired
	private TioProps tioProps;

	private AioClient aioClient;
	@Autowired
	private DBAccess dbAccess;
	@Autowired
	AppConfig appConfig;

	private static Logger logger = LoggerFactory.getLogger(AppClient.class);

	/**
	 * 网络客户端程序入口
	 */
	@PostConstruct
	public void clientStart() throws Exception {

		// 这里判断是否启用节点发现，如果没有则以单机节点运行，不去尝试连接种子节点
		if (!appConfig.isNodeDiscover()) {
			return;
		}

		aioClient = new AioClient(clientGroupContext);
		//加载数据库中的节点数据
		Optional<List<Node>> nodeList = dbAccess.getNodeList();
		List<Node> nodes = null;
		if (nodeList.isPresent()) {
			nodes = nodeList.get();
			//初始化配置 properties 中的节点
		} else if (null != tioProps.getNodes()) {
			nodes = tioProps.getNodes();
		}
		// 添加节点
		for (Node node : nodes) {
			connectNode(node);
		}
	}

	/**
	 * 发送消息到一个group
	 * @param messagePacket
	 */
	public void sendGroup(MessagePacket messagePacket)
	{
		// 关闭同步功能
		if (!appConfig.isNodeDiscover()) {
			return;
		}

		Aio.sendToGroup(clientGroupContext, tioProps.getClientGroupName(), messagePacket);
	}

	/**
	 * 添加节点
	 * @param serverIp
	 * @param port
	 */
	public void addNode(String serverIp, int port) throws Exception
	{
		if (!appConfig.isNodeDiscover()) {
			return;
		}
		Node node = new Node(serverIp, port);
		// determine if the node is already exists
		Optional<List<Node>> nodeList = dbAccess.getNodeList();
		if (nodeList.isPresent() && nodeList.get().contains(node)) {
			return;
		}
		if (dbAccess.addNode(node)) {
			connectNode(node);
		}
	}

	/**
	 * 连接节点
	 * @param node
	 * @throws Exception
	 */
	public void connectNode(Node node) throws Exception
	{
		ClientChannelContext channelContext = aioClient.connect(node);
		Aio.send(channelContext, new MessagePacket(SerializeUtils.serialize(MessagePacket.HELLO_MESSAGE)));
		Aio.bindGroup(channelContext, tioProps.getClientGroupName());
		logger.info("连接节点成功, {}", node);
	}

	/**
	 * 向所有连接的节点发起同步区块请求
	 */
	@EventListener(ApplicationReadyEvent.class)
	public void fetchNextBlock() {
		ApplicationContextProvider.publishEvent(new FetchNextBlockEvent(0));

	}

	/**
	 * 同步节点列表
	 */
	@EventListener(ApplicationReadyEvent.class)
	public void fetchNodeList()
	{
		logger.info("++++++++++++++++++++++++++ 开始获取在线节点 +++++++++++++++++++++++++++");
		MessagePacket packet = new MessagePacket();
		packet.setType(MessagePacketType.REQ_NODE_LIST);
		packet.setBody(SerializeUtils.serialize(MessagePacket.FETCH_NODE_LIST_SYMBOL));
		sendGroup(packet);
	}
}
