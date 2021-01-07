package com.fitness.authservice.exception;


public class UserNotFoundException extends RequestException {

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    private String userId;

    public UserNotFoundException(String userId) {
        this.userId = userId;
    }

}
