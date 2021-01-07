package com.fitness.authservice.exception;

public class RequestValidationException extends RequestException {
    private String message;

    public RequestValidationException(String message) {
        this.message = message;
    }

    public RequestValidationException(String message, Integer exceptionCode) {
        super(message, exceptionCode);
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
