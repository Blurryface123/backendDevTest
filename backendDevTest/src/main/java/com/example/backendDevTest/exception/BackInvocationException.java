package com.example.backendDevTest.exception;

import com.example.backendDevTest.models.ErrorModelResponse;

/**
 * The type Back invocation exception.
 */
public class BackInvocationException extends RuntimeException{

    private ErrorModelResponse errorModelResponse;

    /**
     * Instantiates a new Back invocation exception.
     */
    public BackInvocationException() {
    }

    /**
     * Instantiates a new Back invocation exception.
     *
     * @param message the message
     */
    public BackInvocationException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Back invocation exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public BackInvocationException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Back invocation exception.
     *
     * @param cause the cause
     */
    public BackInvocationException(Throwable cause) {
        super(cause);
    }

}
