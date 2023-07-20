package com.example.backendDevTest.exception;

/**
 * The type Custom timeout exception.
 */
public class CustomTimeoutException extends RuntimeException{
    /**
     * Instantiates a new Custom timeout exception.
     */
    public CustomTimeoutException() {
    }

    /**
     * Instantiates a new Custom timeout exception.
     *
     * @param message the message
     */
    public CustomTimeoutException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Custom timeout exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public CustomTimeoutException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Custom timeout exception.
     *
     * @param cause the cause
     */
    public CustomTimeoutException(Throwable cause) {
        super(cause);
    }
}
