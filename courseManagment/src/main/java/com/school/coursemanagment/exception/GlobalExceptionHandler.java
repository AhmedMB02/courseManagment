package com.school.coursemanagment.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex){
        return new ResponseEntity<>(
                new ErrorResponse(LocalDateTime.now(),HttpStatus.NOT_FOUND.value()
                        ,"Resource Not Found",ex.getMessage()),
                 HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleAlreadyExistException(AlreadyExistsException ex){
        return new ResponseEntity<>(
                new ErrorResponse(LocalDateTime.now(),HttpStatus.BAD_REQUEST.value()
                        ,"Already Exists Exception",ex.getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleBadRequestException(BadRequestException ex){
        return new ResponseEntity<>(
                new ErrorResponse(LocalDateTime.now(),HttpStatus.BAD_REQUEST.value()
                        ,"Bad Request Exception",ex.getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }
}
