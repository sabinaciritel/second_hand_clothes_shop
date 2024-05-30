package com.example.demo.model.dao;

import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDAOP extends JpaRepository<Product, Long> {
    Optional<Product> findById(Long id);
}
