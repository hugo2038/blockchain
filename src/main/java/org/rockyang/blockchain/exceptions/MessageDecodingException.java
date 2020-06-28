package org.rockyang.blockchain.exceptions;

/**
 * Encoding exception.
 */
public class MessageDecodingException extends RuntimeException {
	private static final long serialVersionUID = 4659490830279997955L;

	public MessageDecodingException(String message) {
        super(message);
    }

    public MessageDecodingException(String message, Throwable cause) {
        super(message, cause);
    }
}
