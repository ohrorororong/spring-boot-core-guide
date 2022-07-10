package com.example.jpa.data.dao;

import com.example.jpa.data.domain.Product;

public interface ProductDAO {

    Product insertProduct(Product product);
    Product selectProduct(Long number);
    Product                                                                                                                                                         updateProductName(Long number, String name);
    void deleteProduct(Long number);
}
