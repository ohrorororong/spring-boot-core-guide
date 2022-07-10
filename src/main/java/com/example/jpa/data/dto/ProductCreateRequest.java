package com.example.jpa.data.dto;

import com.example.jpa.data.domain.Product;
import lombok.Builder;
import lombok.Data;

@Data
public class ProductCreateRequest {

    private final String name;
    private final int price;
    private final int stock;

    @Builder
    protected ProductCreateRequest(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public Product toEntity() {
        return Product.builder()
                .name(this.name)
                .price(this.price)
                .stock(this.stock)
                .build();
    }
}
