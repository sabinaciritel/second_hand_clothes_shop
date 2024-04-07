package com.example.demo.service;

import com.example.demo.api.model.RegistrationBody;
import com.example.demo.api.model.RegistrationBodyProduct;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.model.dao.UserDAO;
import com.example.demo.model.dao.UserDAOP;
import com.example.demo.observerPattern.Observer;
import com.example.demo.observerPattern.Subject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class for managing user operations.
 * This service provides methods to register, update, find, and delete users in the application.
 */
@Service
public class ServiceProduct implements Subject {
    private UserDAOP userDAOP;
    private UserDAO userDAO;
    private List<Observer> observers = new ArrayList<>();



    public ServiceProduct(UserDAOP userDAOP, UserDAO userDAO){

        this.userDAOP=userDAOP;
        this.userDAO=userDAO;
        List<User> users= (List<User>) userDAO.findAll();
        for(User user : users){
            this.addObserver(user);
        }
    }
    public Product registerProduct(RegistrationBodyProduct registrationBodyProduct) {
        Product product = new Product();
        product.setId(registrationBodyProduct.getId());
        product.setName(registrationBodyProduct.getName());
        product.setDescription(registrationBodyProduct.getDescription());
        product.setPrice(registrationBodyProduct.getPrice());
        product.setStockQuantity(registrationBodyProduct.getStockQuantity());

        return userDAOP.save(product);

    }
    public Product findProduct(RegistrationBodyProduct registrationBodyProduct) {
        Product product = new Product();
        System.out.println(registrationBodyProduct.getId());
        product = userDAOP.findByName(registrationBodyProduct.getName());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
        System.out.println(product.getPrice());
        System.out.println(product.getStockQuantity());
        return product;

    }
    public Product updateProduct(RegistrationBodyProduct registrationBodyProduct) {
        Product product = findProduct(registrationBodyProduct);

        product.setDescription(registrationBodyProduct.getDescription());
        product.setPrice(registrationBodyProduct.getPrice());
        int newStockQuantity = registrationBodyProduct.getStockQuantity();
        product.setStockQuantity(newStockQuantity);
        if (newStockQuantity == 0) {
            notifyObservers();
        }

        return userDAOP.save(product);
    }

    public void deleteProduct(RegistrationBodyProduct registrationBodyProduct) {
        Product product = new Product();
        product =findProduct(registrationBodyProduct);
        product.setDescription(registrationBodyProduct.getDescription());
        product.setPrice(registrationBodyProduct.getPrice());
        product.setStockQuantity(registrationBodyProduct.getStockQuantity());
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






}