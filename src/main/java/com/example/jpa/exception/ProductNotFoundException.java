package com.example.jpa.exception;

public class ProductNotFoundException extends ProductBaseException {
    private static final String message = "상품을 찾지 못했습니다.";
    private static final String errorCode = "405";
    public ProductNotFoundException() {
        super(message, errorCode);
    }
}
