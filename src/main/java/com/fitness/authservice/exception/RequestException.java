package com.fitness.authservice.exception;

public class RequestException extends Exception {
    private Integer exceptionCode;

    public Integer getExceptionCode() {
        return this.exceptionCode;
    }

    public RequestException() {
    }

    public RequestException(String message) {
        super(message);
    }

    public RequestException(Integer exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

    public RequestException(String message, Throwable cause, Integer exceptionCode) {
        super(message, cause);
        this.exceptionCode = exceptionCode;
    }

    public RequestException(String message, Integer exceptionCode) {
        super(message);
        this.exceptionCode = exceptionCode;
    }

    public RequestException(Throwable cause, Integer exceptionCode) {
        super(cause);
        this.exceptionCode = exceptionCode;
    }

    public RequestException(Throwable cause) {
        super(cause);
    }

    public RequestException(String message, Throwable cause) {
        super(message, cause);
    }
}