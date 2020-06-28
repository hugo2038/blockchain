package org.rockyang.blockchain.event;

import org.springframework.context.ApplicationEvent;

/**
 * 增加区块确认数事件
 * @author yangjian
 */
public class BlockConfirmNumEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1932188360267940283L;

	/**
     * @param blockIndex 区块高度
     */
    public BlockConfirmNumEvent(Integer blockIndex)
    {
        super(blockIndex);
    }
}
