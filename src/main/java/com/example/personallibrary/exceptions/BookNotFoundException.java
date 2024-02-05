package com.example.personallibrary.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class BookNotFoundException extends RuntimeException {

    @ExceptionHandler(ResponseStatusException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> resourceNotFound(ResponseStatusException e) {
        LocalDateTime timestamp = LocalDateTime.now();
        String body = "{ \n" +
                        "  \"status\": \"NOT_FOUND\",\n" +
                        "  \"timestamp\": \"" + timestamp + "\",\n" +
                        "  \"message\": "+"No book was found"+"\n" +
                      "}";
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}   
