package com.example.demo.model.dao;

import com.example.demo.model.Product;
import com.example.demo.model.User;
import org.springframework.data.repository.CrudRepository;


public interface UserDAOP extends CrudRepository<Product, Long> {


    Product findByName(String name);

}