package com.check.exceptions;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import org.springframework.http.ResponseEntity;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandles {
    @ExceptionHandler(MalformedJwtException.class)
    public ResponseEntity<String> handleMalformedJwtException (MalformedJwtException e){
        return ResponseEntity.status(500).body("GOT MALFORMED JWT EXCEPTION :" + e.getMessage());
    }
    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<String> handleExpiredJwtException(ExpiredJwtException e){
        return ResponseEntity.status(500).body("GOT EXPIRED JWT EXCEPTION :" + e.getMessage());
    }
    @ExceptionHandler(UnsupportedJwtException.class)
    public ResponseEntity<String> handleUnsupportedJwtException(UnsupportedJwtException e){
        return ResponseEntity.status(500).body("GOT UNSUPPORTED JWT EXCEPTION :" + e.getMessage());
    }
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<String> handleEmptyResultDataAccessException (EmptyResultDataAccessException e) {
        return ResponseEntity.status(500).body("GOT EmptyResultDataAccessException : " + e.getMessage());
    }
}
