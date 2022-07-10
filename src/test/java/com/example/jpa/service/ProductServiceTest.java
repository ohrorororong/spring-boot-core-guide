package com.example.jpa.service;

import com.example.jpa.data.dao.ProductDAO;
import com.example.jpa.data.domain.Product;
import com.example.jpa.data.dto.ProductCreateRequest;
import com.example.jpa.data.dto.ProductResponseDto;
import com.example.jpa.data.repository.ProductRepository;
import com.example.jpa.service.Impl.ProductServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ProductServiceTest {

    private final ProductDAO productDAO = Mockito.mock(ProductDAO.class);
    private final ProductRepository productRepository = Mockito.mock(ProductRepository.class);
    private ProductService productService;

    @BeforeEach
    void setUpTest() {
        productService = new ProductServiceImpl(productDAO);
    }

    @Test
    @DisplayName("제품 조회 테스트")
    void getProduct() {
        Product product = Product.builder()
                .name("펜")
                .price(1000)
                .stock(1234)
                .build();


        when(productDAO.selectProduct(123L))
                .thenReturn(product);

        ProductResponseDto productResponseDto = productService.getProduct(123L);

        assertThat(productResponseDto.getName()).isEqualTo(product.getName());
        assertThat(productResponseDto.getPrice()).isEqualTo(product.getPrice());
        assertThat(productResponseDto.getStock()).isEqualTo(product.getStock());

        verify(productDAO).selectProduct(123L);
    }

    @Test
    @DisplayName("제품 저장 테스트")
    void saveProductTest() {
        when(productDAO.insertProduct(any(Product.class)))
                .then(returnsFirstArg());

        Long productId = productService.saveProduct(ProductCreateRequest.builder()
                .name("펜")
                .price(1000)
                .stock(1234)
                .build());

        verify(productDAO).insertProduct(any());
    }
}