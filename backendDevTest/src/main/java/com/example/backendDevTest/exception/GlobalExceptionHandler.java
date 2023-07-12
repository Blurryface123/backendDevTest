package com.example.backendDevTest.exception;

import com.example.backendDevTest.models.ErrorModelResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MockServiceException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorModelResponse handleMockServiceException(Exception ex, WebRequest request) {
        ErrorModelResponse errorResponse = new ErrorModelResponse();
        errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorResponse.setStatusText(HttpStatus.NOT_FOUND.getReasonPhrase());
        errorResponse.setDetailMessage(ex.getMessage());
        return errorResponse;
    }

    @ExceptionHandler(BackInvocationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorModelResponse handleGlobalException(Exception ex, WebRequest request) {
        ErrorModelResponse errorResponse = new ErrorModelResponse();
        errorResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.setStatusText(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        errorResponse.setDetailMessage(ex.getMessage());
        return errorResponse;
    }
}
