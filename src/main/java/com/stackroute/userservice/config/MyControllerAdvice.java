package com.stackroute.userservice.config;

import com.stackroute.userservice.userexception.UserAlreadyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyControllerAdvice {
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> exceptionhandler(Exception e)
    {
            return new ResponseEntity<>("erorr exception occured in Gloabal " +e.getMessage(), HttpStatus.CONFLICT);
    }
}
