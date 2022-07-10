package com.example.jpa.controller;

import com.example.jpa.data.dto.ProductErrorResponseDto;
import com.example.jpa.exception.ProductBaseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

@RestControllerAdvice
public class PostControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ProductErrorResponseDto> exception(Exception e) {
        ProductErrorResponseDto errorResponseDto = ProductErrorResponseDto.builder()
                .errorMessage("오류")
                .errorCode("500")
                .build();
        return ResponseEntity.status(BAD_REQUEST).body(errorResponseDto);
    }

    @ExceptionHandler(ProductBaseException.class)
    public ResponseEntity<ProductErrorResponseDto> postBaseException(ProductBaseException e) {
        ProductErrorResponseDto errorResponseDto = ProductErrorResponseDto.builder()
                .errorMessage(e.getMessage())
                .errorCode(e.getErrorCode())
                .build();
        return ResponseEntity.status(BAD_REQUEST).body(errorResponseDto);
    }
}
