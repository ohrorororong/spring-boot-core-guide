package com.example.jpa.data.repository;

import com.example.jpa.data.domain.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    @DisplayName("제품 조회 테스트")
    void selectTest() {
        // given
        Product product = Product.builder()
                .name("펜")
                .price(1000)
                .stock(1000)
                .build();

        Product savedProduct = productRepository.save(product);

        // when
        Product foundProduct = productRepository.findById(savedProduct.getNumber()).get();

        // then
        assertThat(product.getName()).isEqualTo(foundProduct.getName());
        assertThat(product.getPrice()).isEqualTo(foundProduct.getPrice());
        assertThat(product.getStock()).isEqualTo(foundProduct.getStock());
    }

}