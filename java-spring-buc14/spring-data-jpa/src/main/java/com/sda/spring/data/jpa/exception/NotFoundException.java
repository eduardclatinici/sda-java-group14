package com.sda.spring.data.jpa.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }

    //TODO: define more custom exceptions to wrap application specific exceptions
}
