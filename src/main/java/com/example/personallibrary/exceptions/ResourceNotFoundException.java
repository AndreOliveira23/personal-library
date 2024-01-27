package com.example.personallibrary.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ResourceNotFoundException {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> resourceNotFound(Exception e) {
        LocalDateTime timestamp = LocalDateTime.now();
        String body = "{ \n" +
                "  \"status\": \"NOT_FOUND\",\n" +
                "  \"timestamp\": \"" + timestamp + "\",\n" +
                "  \"message\": "+"The URL for this request might be wrong"+"\n" +
                "}";
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
