package com.jlt.blockchain.event;

import org.springframework.context.ApplicationEvent;

import com.jlt.blockchain.core.Block;

/**
 * 挖矿事件，当挖到一个新的区块将会触发该事件
 * 
 */
public class NewBlockEvent extends ApplicationEvent {

	private static final long serialVersionUID = -9001465889735705145L;

	public NewBlockEvent(Block block) {
        super(block);
    }
}
