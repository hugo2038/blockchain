package com.jlt.blockchain.exceptions;

/**
 * Encoding exception.
 */
public class MessageDecodingException extends RuntimeException {
	private static final long serialVersionUID = 8735100626911014949L;

	public MessageDecodingException(String message) {
        super(message);
    }

    public MessageDecodingException(String message, Throwable cause) {
        super(message, cause);
    }
}
