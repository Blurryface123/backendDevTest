package com.example.backendDevTest.exception;

public class MockServiceException  extends Exception{
    public MockServiceException() {
    }

    public MockServiceException(String message) {
        super(message);
    }

    public MockServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public MockServiceException(Throwable cause) {
        super(cause);
    }
}
