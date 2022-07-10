package com.example.jpa.data.repository;

import com.example.jpa.data.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
