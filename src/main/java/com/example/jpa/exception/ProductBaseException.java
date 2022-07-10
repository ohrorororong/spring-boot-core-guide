package com.example.jpa.exception;

import lombok.Getter;

@Getter
public class ProductBaseException extends RuntimeException {
    private final String errorCode;

    public ProductBaseException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
