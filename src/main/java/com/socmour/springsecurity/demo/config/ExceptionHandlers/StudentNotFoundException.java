package com.socmour.springsecurity.demo.config.ExceptionHandlers;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(String message){
        super(message);
    }

}
