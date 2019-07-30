package com.socmour.springsecurity.demo.config.ExceptionHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

    // @StudentNotFoundException Handler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){

        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        StudentErrorResponse error = new StudentErrorResponse(httpStatus.value(), exc.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(error, httpStatus);
    }

    // @Generic Exception Handler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){

        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        StudentErrorResponse error = new StudentErrorResponse(httpStatus.value(), exc.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(error, httpStatus);
    }

}
