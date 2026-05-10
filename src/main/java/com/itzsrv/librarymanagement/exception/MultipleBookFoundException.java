package com.itzsrv.librarymanagement.exception;

public class MultipleBookFoundException extends RuntimeException {
    public MultipleBookFoundException(String message) {
        super(message);
    }
}
