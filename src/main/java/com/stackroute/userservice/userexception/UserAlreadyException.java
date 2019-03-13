package com.stackroute.userservice.userexception;

public class UserAlreadyException extends Exception {

    String data;

    public UserAlreadyException() {
    }

    public UserAlreadyException(String data)
    {
        super(data);
        this.data= data;
    }
}
