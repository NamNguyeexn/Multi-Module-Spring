package com.common.exceptions;

import jakarta.servlet.ServletException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;


@RestControllerAdvice
public class ExceptionHandlers {
    @ExceptionHandler(IOException.class)
    public ResponseEntity<String> handleIOException(IOException e) {
        return ResponseEntity.status(500).body("GOT IOEXCEPTION :" + e.getMessage());
    }
    @ExceptionHandler(ServletException.class)
    public ResponseEntity<String> handleServletException (ServletException e) {
        return ResponseEntity.status(500).body("GOT SERVLET EXCEPTION :" + e.getMessage());
    }
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<String> handleEmptyResultDataAccessException (EmptyResultDataAccessException e) {
        return ResponseEntity.status(500).body("GOT EmptyResultDataAccessException : " + e.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e){
        return ResponseEntity.status(500).body("GOT ILLEGAL ARGUMENT EXCEPTION :" + e.getMessage());
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGlobalException (Exception e) {
        return ResponseEntity.status(500).body("GOT GLOBAL EXCEPTION :" + e.getMessage());
    }
}
