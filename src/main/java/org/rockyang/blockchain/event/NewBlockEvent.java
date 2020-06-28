package org.rockyang.blockchain.event;

import org.rockyang.blockchain.core.Block;
import org.springframework.context.ApplicationEvent;

/**
 * 挖矿事件，当挖到一个新的区块将会触发该事件
 * @author yangjian
 */
public class NewBlockEvent extends ApplicationEvent {

	private static final long serialVersionUID = 3638870468836220761L;

	public NewBlockEvent(Block block) {
        super(block);
    }
}
