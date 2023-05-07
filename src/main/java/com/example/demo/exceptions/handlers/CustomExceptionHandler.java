package com.example.demo.exceptions.handlers;

import com.example.demo.exceptions.ModelNotFoundException;
import com.example.demo.exceptions.responses.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(ModelNotFoundException.class)

    public ResponseEntity<ErrorResponse> handleModelNotFoundException(ModelNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), "HOLA");
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
