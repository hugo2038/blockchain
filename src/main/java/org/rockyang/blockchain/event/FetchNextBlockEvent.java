package org.rockyang.blockchain.event;

import org.springframework.context.ApplicationEvent;

/**
 * 当发起同步下一个区块请求的时候将会触发该事件
 * @author yangjian
 */
public class FetchNextBlockEvent extends ApplicationEvent {

	private static final long serialVersionUID = -7336631324337850970L;

	/**
     * @param blockIndex 区块高度
     */
    public FetchNextBlockEvent(Integer blockIndex) {
        super(blockIndex);
    }
}
