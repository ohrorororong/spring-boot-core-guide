package com.example.jpa.service;

import com.example.jpa.data.dto.ProductCreateRequest;
import com.example.jpa.data.dto.ProductResponseDto;

public interface ProductService {

    ProductResponseDto getProduct(Long number);
    Long saveProduct(ProductCreateRequest productCreateRequest);
    ProductResponseDto changeProductName(Long number, String name);
    void deleteProduct(Long number);
}
