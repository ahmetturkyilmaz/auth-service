package com.fitness.authservice.model;

import org.springframework.http.HttpStatus;

public class RequestExceptionResponse {
    private Long timestamp;
    private String message;
    private String details;
    private int exceptionCode;
    private HttpStatus httpStatus;

    public RequestExceptionResponse(Long timestamp, String message, String details, int exceptionCode, HttpStatus httpStatus) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
        this.exceptionCode = exceptionCode;
        this.httpStatus = httpStatus;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(int exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
