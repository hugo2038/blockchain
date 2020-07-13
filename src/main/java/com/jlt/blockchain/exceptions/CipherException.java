package com.jlt.blockchain.exceptions;

/**
 * Cipher exception wrapper.
 */
public class CipherException extends Exception {

	private static final long serialVersionUID = -3298168847019643995L;

	public CipherException(String message) {
        super(message);
    }

    public CipherException(Throwable cause) {
        super(cause);
    }

    public CipherException(String message, Throwable cause) {
        super(message, cause);
    }
}
