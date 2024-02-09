package com.example.personallibrary.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@ControllerAdvice
public class ControllerAdviceHandler {

    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> resourceNotFound(NoResourceFoundException e) {
        LocalDateTime timestamp = LocalDateTime.now();
        String body = "{ \n" +
                "  \"status\": \"NOT_FOUND\",\n" +
                "  \"timestamp\": \"" + timestamp + "\",\n" +
                "  \"message\": "+"The URL for this request might be wrong"+"\n" +
                "}";
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> resourceNotFound(MethodArgumentNotValidException e) {
        LocalDateTime timestamp = LocalDateTime.now();
        List<String> message = e.getBindingResult().getAllErrors().stream()
                                .map(erro -> erro.getDefaultMessage()).collect(Collectors.toList());

        String body = "{ \n" +
                        "  \"status\": \"BAD_REQUEST\",\n" +
                        "  \"timestamp\": \"" + timestamp + "\",\n" +
                        "  \"message\": "+message+"\n" +
                      "}";

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    } 
}