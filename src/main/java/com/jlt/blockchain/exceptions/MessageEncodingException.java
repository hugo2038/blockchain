package com.jlt.blockchain.exceptions;

/**
 * Encoding exception.
 */
public class MessageEncodingException extends RuntimeException {
	private static final long serialVersionUID = 3668815712848950698L;

	public MessageEncodingException(String message) {
        super(message);
    }

    public MessageEncodingException(String message, Throwable cause) {
        super(message, cause);
    }
}
