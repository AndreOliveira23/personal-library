package com.example.personallibrary.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.LocalDateTime;

@ControllerAdvice
public class BadRequestException extends Throwable {

    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> resourceNotFound(NoResourceFoundException e) {
        LocalDateTime timestamp = LocalDateTime.now();
        String body = "{ \n" +
                "  \"status\": \"BAD_REQUEST\",\n" +
                "  \"timestamp\": \"" + timestamp + "\",\n" +
                "  \"message\": "+"The URL for this request might be wrong"+"\n" +
                "}";
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
