package com.example.jpa.data.dao;

import com.example.jpa.data.dao.Impl.ProductDAOImpl;
import com.example.jpa.data.domain.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductDAOTest {

    @Autowired
    private ProductDAO productDAO;

    @Test
    @DisplayName("상품 추가")
    void addProduct() {
        // given
        Product product = Product.builder()
                .name("상품1")
                .price(10000)
                .stock(100)
                .build();

        // when
        Product savedProduct = productDAO.insertProduct(product);

        //then
        assertThat(savedProduct).isEqualTo(product);
        assertThat(savedProduct.getName()).isEqualTo(product.getName());
        assertThat(savedProduct.getPrice()).isEqualTo(product.getPrice());
        assertThat(savedProduct.getStock()).isEqualTo(product.getStock());
    }
}