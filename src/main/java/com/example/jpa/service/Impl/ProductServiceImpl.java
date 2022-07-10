package com.example.jpa.service.Impl;

import com.example.jpa.data.dao.ProductDAO;
import com.example.jpa.data.domain.Product;
import com.example.jpa.data.dto.ProductCreateRequest;
import com.example.jpa.data.dto.ProductResponseDto;
import com.example.jpa.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {

    private final ProductDAO productDAO;

    @Override
    public ProductResponseDto getProduct(Long number) {
        Product product = productDAO.selectProduct(number);
        return ProductResponseDto.toResponse(product);
    }

    @Transactional
    @Override
    public Long saveProduct(ProductCreateRequest productCreateRequest) {
        return productDAO.insertProduct(productCreateRequest.toEntity()).getNumber();
    }

    @Transactional
    @Override
    public ProductResponseDto changeProductName(Long number, String name) {
        return ProductResponseDto.toResponse(productDAO.updateProductName(number, name));
    }

    @Transactional
    @Override
    public void deleteProduct(Long number) {
        productDAO.deleteProduct(number);
    }
}
