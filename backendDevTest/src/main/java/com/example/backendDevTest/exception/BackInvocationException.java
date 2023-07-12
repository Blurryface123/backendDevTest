package com.example.backendDevTest.exception;

import com.example.backendDevTest.models.ErrorModelResponse;

public class BackInvocationException extends Exception{

    private ErrorModelResponse errorModelResponse;

    public BackInvocationException() {
    }

    public BackInvocationException(String message) {
        super(message);
    }

    public BackInvocationException(String message, Throwable cause) {
        super(message, cause);
    }

    public BackInvocationException(Throwable cause) {
        super(cause);
    }

}
