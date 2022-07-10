package com.example.jpa.data.dao.Impl;

import com.example.jpa.data.dao.ProductDAO;
import com.example.jpa.data.domain.Product;
import com.example.jpa.data.repository.ProductRepository;
import com.example.jpa.exception.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductDAOImpl implements ProductDAO {

    private final ProductRepository productRepository;

    @Override
    public Product insertProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product selectProduct(Long number) {
        return productRepository.findById(number)
                .orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public Product updateProductName(Long number, String name) {
        Product findProduct = productRepository.findById(number)
                .orElseThrow(ProductNotFoundException::new);
        findProduct.updateProductName(name);
        return findProduct;
    }

    @Override
    public void deleteProduct(Long number) {
        productRepository.deleteById(number);
    }
}
