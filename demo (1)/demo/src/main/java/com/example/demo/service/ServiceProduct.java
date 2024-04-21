package com.example.demo.service;

import com.example.demo.api.model.ProductName;
import com.example.demo.api.model.RegistrationBody;
import com.example.demo.api.model.RegistrationBodyProduct;
import com.example.demo.api.model.UserUsername;
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
 * Service class for managing product operations in the application.
 * It offers functionalities to register, find, update, and delete products. It also implements the Subject
 * interface from the Observer pattern, allowing it to notify observers about significant product stock changes.
 */
@Service
public class ServiceProduct implements ServiceProductImpl,Subject {
    private UserDAOP userDAOP;
    private UserDAO userDAO;
    private List<Observer> observers = new ArrayList<>();


    /**
     * Constructs a ServiceProduct with specified UserDAOP and UserDAO.
     * Automatically adds all users from the database as observers to monitor product stock changes.
     *
     * @param userDAOP DAO for product-related data access.
     * @param userDAO DAO for user-related data access.
     */
    public ServiceProduct(UserDAOP userDAOP, UserDAO userDAO){

        this.userDAOP=userDAOP;
        this.userDAO=userDAO;
        List<User> users= (List<User>) userDAO.findAll();
        for(User user : users){
            this.addObserver(user);
        }
    }
    /**
     * Registers a new product in the system based on the provided product registration body.
     *
     * @param registrationBodyProduct The registration details of the new product.
     * @return The newly registered Product object.
     */
    public Product registerProduct(RegistrationBodyProduct registrationBodyProduct) {
        Product product = new Product();
        product.setId(registrationBodyProduct.getId());
        product.setName(registrationBodyProduct.getName());
        product.setDescription(registrationBodyProduct.getDescription());
        product.setPrice(registrationBodyProduct.getPrice());
        product.setStockQuantity(registrationBodyProduct.getStockQuantity());

        userDAOP.save(product);
        return product;


    }
    /**
     * Finds a product by its name as provided in the product registration body.
     *
     * @param registrationBodyProduct The details of the product to find.
     * @return The found Product object, or null if no product with the given name exists.
     */
    public Product findProduct(RegistrationBodyProduct registrationBodyProduct) {
        Product product = new Product();

        product = userDAOP.findByName(registrationBodyProduct.getName());

        return product;

    }
    /**
     * Updates an existing product with new details provided in the product registration body.
     * Notifies all observers if the updated stock quantity is zero.
     *
     * @param registrationBodyProduct The new details of the product.
     * @return The updated Product object.
     */
    public Product updateProduct(RegistrationBodyProduct registrationBodyProduct) {
        Product product = findProduct(registrationBodyProduct);
        if (product == null) {

            return null;
        }

        product.setDescription(registrationBodyProduct.getDescription());
        product.setPrice(registrationBodyProduct.getPrice());
        int newStockQuantity = registrationBodyProduct.getStockQuantity();
        product.setStockQuantity(newStockQuantity);
        if (newStockQuantity == 0) {
            notifyObservers();
        }

       userDAOP.save(product);
        return product;
    }
    /**
     * Deletes a product based on the details provided in the product registration body.
     *
     * @param registrationBodyProduct The details of the product to delete.
     */
    public Product deleteProduct(RegistrationBodyProduct registrationBodyProduct) {
        Product product = userDAOP.findByName(registrationBodyProduct.getName());

        userDAOP.delete(product);
        return product;

    }
    /**
     * Adds an observer to the list of observers to be notified of stock changes.
     *
     * @param o The observer to add.
     */
    public void addObserver(Observer o) {
        observers.add(o);
    }
    /**
     * Removes an observer from the list of observers.
     *
     * @param o The observer to remove.
     */
    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }
    /**
     * Notifies all registered observers of a significant event, typically a product stock reaching zero.
     */
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public Product findByName(ProductName productData){
        Product product = userDAOP.findByName(productData.getName());
        if(product != null){
            return product;
        }
        else{
            return null;
        }
    }
    
}