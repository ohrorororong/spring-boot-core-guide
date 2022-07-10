package com.example.jpa.controller;

import com.example.jpa.data.dto.ProductCreateRequest;
import com.example.jpa.data.dto.ProductResponseDto;
import com.example.jpa.service.ProductService;
import com.google.gson.Gson;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    @DisplayName("MockMvc를 통한 Product 데이터 가져오기 테스트")
    void getProductTest() throws Exception {
        given(productService.getProduct(123L)).willReturn(
                ProductResponseDto.builder()
                        .number(123L)
                        .name("pen")
                        .price(5000)
                        .stock(2000)
                        .build());

        String productId = "123";

        mockMvc.perform(
                get("/api/v1/products/" + productId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.number").exists())
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.price").exists())
                .andExpect(jsonPath("$.stock").exists())
                .andDo(print());

        verify(productService).getProduct(123L);
    }

    @Test
    @DisplayName("Product 데이터 생성 테스트")
    void createProductTest() throws Exception {
        given(productService.saveProduct(
                ProductCreateRequest.builder()
                        .name("pen")
                        .price(5000)
                        .stock(2000)
                        .build()))
                .willReturn(12315L);

        ProductCreateRequest productDto = ProductCreateRequest.builder()
                .name("pen")
                .price(5000)
                .stock(2000)
                .build();

        String content = new Gson().toJson(productDto);

        mockMvc.perform(
                        post("/api/v1/products")
                                .content(content)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("12315")))
                .andDo(print());

        verify(productService).saveProduct( ProductCreateRequest.builder()
                .name("pen")
                .price(5000)
                .stock(2000)
                .build());
    }
}