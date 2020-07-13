package com.jlt.blockchain.event;

import org.springframework.context.ApplicationEvent;

import com.jlt.blockchain.core.Transaction;

/**
 * 发送交易事件
 * 
 */
public class NewTransactionEvent extends ApplicationEvent {

	private static final long serialVersionUID = 4329682126982333152L;

	public NewTransactionEvent(Transaction transaction) {
        super(transaction);
    }

}
