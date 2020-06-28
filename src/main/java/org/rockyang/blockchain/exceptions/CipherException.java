package org.rockyang.blockchain.exceptions;

/**
 * Cipher exception wrapper.
 */
public class CipherException extends Exception {

	private static final long serialVersionUID = -3516693971341797390L;

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
