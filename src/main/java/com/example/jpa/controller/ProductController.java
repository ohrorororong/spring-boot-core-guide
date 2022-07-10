package com.example.jpa.controller;

import com.example.jpa.data.dto.ChangeProductNameDto;
import com.example.jpa.data.dto.ProductCreateRequest;
import com.example.jpa.data.dto.ProductResponseDto;
import com.example.jpa.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{number}")
    public ResponseEntity<ProductResponseDto> getProduct(@PathVariable Long number) {
        return ResponseEntity.status(OK).body(productService.getProduct(number));
    }

    @PostMapping()
    public ResponseEntity<Long> createProduct(@RequestBody ProductCreateRequest productCreateRequest) {
        return ResponseEntity.status(OK).body(productService.saveProduct(productCreateRequest));
    }

    @PutMapping()
    public ResponseEntity<ProductResponseDto> changeProductName(@RequestBody ChangeProductNameDto changeProductNameDto) {
        return ResponseEntity.status(OK).body(productService.changeProductName(changeProductNameDto.getNumber(),
                changeProductNameDto.getName()));
    }

    @DeleteMapping("/{number}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long number) {
        productService.deleteProduct(number);
        return ResponseEntity.status(OK).body("정상적으로 삭제되었습니다.");
    }
}
