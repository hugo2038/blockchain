package org.rockyang.blockchain.net.base;

import java.io.Serializable;

/**
 * @author yangjian
 * @since 18-4-18
 */
public class Node extends org.tio.core.Node implements Serializable {

	private static final long serialVersionUID = -1348045387585567122L;

	public Node(String ip, int port) {
		super(ip, port);
	}

	public Node() {
		super(null, 0);
	}
}
