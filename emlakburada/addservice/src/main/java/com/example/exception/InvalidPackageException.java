package com.example.exception;

public class InvalidPackageException extends RuntimeException {
    public InvalidPackageException(String message) {
        super(message);
    }
}
