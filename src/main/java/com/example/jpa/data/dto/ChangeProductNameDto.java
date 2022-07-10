package com.example.jpa.data.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class ChangeProductNameDto {

    private Long number;
    private String name;

    @Builder
    public ChangeProductNameDto(Long number, String name) {
        this.number = number;
        this.name = name;
    }
}
