package com.example.jpa.data.dto;


import lombok.Builder;
import lombok.Data;

@Data
public class ProductErrorResponseDto {
    private final String errorMessage;
    private final String errorCode;

    @Builder
    public ProductErrorResponseDto(String errorMessage, String errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }
}
