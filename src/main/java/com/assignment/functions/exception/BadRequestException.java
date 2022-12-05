package com.assignment.functions.exception;

public class BadRequestException extends Exception {
    public BadRequestException(String errorMessage) {
        super(errorMessage);
    }
}