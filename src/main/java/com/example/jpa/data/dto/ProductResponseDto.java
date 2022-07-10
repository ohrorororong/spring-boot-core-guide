package com.example.jpa.data.dto;

import com.example.jpa.data.domain.Product;
import lombok.Builder;
import lombok.Data;

@Data
public class ProductResponseDto {

    private final Long number;
    private final String name;
    private final int price;
    private final int stock;

    @Builder
    protected ProductResponseDto(Long number, String name, int price, int stock) {
        this.number = number;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public static ProductResponseDto toResponse(Product product) {
        return ProductResponseDto.builder()
                .number(product.getNumber())
                .name(product.getName())
                .price(product.getPrice())
                .stock(product.getStock())
                .build();
    }
}
