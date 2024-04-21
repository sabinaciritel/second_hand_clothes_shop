package com.example.demo.service;

import com.example.demo.api.model.RegistrationBody;
import com.example.demo.api.model.RegistrationBodyProduct;
import com.example.demo.model.Product;
import com.example.demo.model.User;

public interface ServiceProductImpl {
    Product registerProduct(RegistrationBodyProduct productData);
    Product updateProduct(RegistrationBodyProduct productData);
    Product deleteProduct(RegistrationBodyProduct productData);
    Product findProduct(RegistrationBodyProduct productData);
}
