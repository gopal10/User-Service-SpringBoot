package com.stackroute.userservice.userexception;

public class UserNotFound extends Exception {
    public UserNotFound() {
    }

    public UserNotFound(String message) {
        super(message);
    }
}
