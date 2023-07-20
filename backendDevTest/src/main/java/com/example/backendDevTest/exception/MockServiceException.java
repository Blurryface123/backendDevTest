package com.example.backendDevTest.exception;

/**
 * The type Mock service exception.
 */
public class MockServiceException  extends RuntimeException{
    /**
     * Instantiates a new Mock service exception.
     */
    public MockServiceException() {
    }

    /**
     * Instantiates a new Mock service exception.
     *
     * @param message the message
     */
    public MockServiceException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Mock service exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public MockServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Mock service exception.
     *
     * @param cause the cause
     */
    public MockServiceException(Throwable cause) {
        super(cause);
    }
}
