package com.example.demo.service;

import com.example.demo.api.model.RegistrationBodyProduct;
import com.example.demo.model.Product;
import com.example.demo.model.dao.UserDAOP;
import com.example.demo.observerPattern.Observer;
import com.example.demo.observerPattern.Subject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceProduct implements  Subject {
    private final UserDAOP userDAOP;
    private final List<Observer> observers = new ArrayList<>();

    public ServiceProduct(UserDAOP userDAOP) {
        this.userDAOP = userDAOP;
    }

    public Product registerProduct(RegistrationBodyProduct registrationBodyProduct) {
        Product product = new Product();
        product.setName(registrationBodyProduct.getName());
        product.setDescription(registrationBodyProduct.getDescription());
        product.setPrice(registrationBodyProduct.getPrice());
        product.setStockQuantity(registrationBodyProduct.getStockQuantity());
        product.setImage(registrationBodyProduct.getImage());
        return userDAOP.save(product);
    }

    public Optional<Product> findProduct(Long id) {
        return userDAOP.findById(id);
    }

    public Product updateProduct(RegistrationBodyProduct registrationBodyProduct) {
        Optional<Product> productOptional = findProduct(registrationBodyProduct.getId());
        if (!productOptional.isPresent()) {
            throw new RuntimeException("Product not found");
        }
        Product product = productOptional.get();

        product.setName(registrationBodyProduct.getName());
        product.setDescription(registrationBodyProduct.getDescription());
        product.setPrice(registrationBodyProduct.getPrice());
        product.setStockQuantity(registrationBodyProduct.getStockQuantity());

        if (registrationBodyProduct.getStockQuantity() == 0) {
            notifyObservers();
        }
        product.setImage(registrationBodyProduct.getImage());
        return userDAOP.save(product);

    }
    public Product updProduct(Product product) {
        Optional<Product> productOptional = findProduct(product.getId());
        if (!productOptional.isPresent()) {
            throw new RuntimeException("Product not found");
        }

        Product existingProduct = productOptional.get();
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setStockQuantity(product.getStockQuantity());
        existingProduct.setImage(product.getImage());

        return userDAOP.save(existingProduct);
    }
    public void deleteProduct(RegistrationBodyProduct registrationBodyProduct) {
        Optional<Product> productOptional = userDAOP.findById(registrationBodyProduct.getId());
        if (!productOptional.isPresent()) {
            throw new RuntimeException("Product not found");
        }
        Product product = productOptional.get();
        userDAOP.delete(product);
    }

    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public List<Product> findAllProducts() {
        return userDAOP.findAll();
    }
    public List<Product> searchProductsByName(String query) {
        return userDAOP.findByNameContainingIgnoreCase(query);
    }
}
