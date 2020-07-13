package com.jlt.blockchain.event;

import org.springframework.context.ApplicationEvent;

/**
 * 增加区块确认数事件
 * 
 */
public class BlockConfirmNumEvent extends ApplicationEvent {

	private static final long serialVersionUID = -8950061634582983829L;

	/**
     * @param blockIndex 区块高度
     */
    public BlockConfirmNumEvent(Integer blockIndex)
    {
        super(blockIndex);
    }
}
