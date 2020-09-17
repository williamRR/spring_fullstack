package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;

public class AlumnoServiceException extends RuntimeException {

    private final String message;
    private final HttpStatus httpStatus;

    public AlumnoServiceException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
