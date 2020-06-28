package org.rockyang.blockchain.exceptions;

/**
 * Encoding exception.
 */
public class MessageEncodingException extends RuntimeException {
	private static final long serialVersionUID = 7716331358884487102L;

	public MessageEncodingException(String message) {
        super(message);
    }

    public MessageEncodingException(String message, Throwable cause) {
        super(message, cause);
    }
}
