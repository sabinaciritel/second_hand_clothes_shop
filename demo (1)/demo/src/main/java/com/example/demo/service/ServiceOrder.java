package com.example.demo.service;

import com.example.demo.api.model.*;
import com.example.demo.model.Order;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.model.dao.UserDAO;
import com.example.demo.model.dao.UserDAOO;
import com.example.demo.model.dao.UserDAOP;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;
/**
 * ServiceOrder provides functionalities to manage orders within the application.
 * It utilizes UserDAOO for data access operations related to Order entities.
 */
@Service
public class ServiceOrder implements ServiceOrderImpl {
    private UserDAOO userDAOO;
    /**
     * Constructs a ServiceOrder with the specified UserDAOO.
     *
     * @param userDAOO The data access object (DAO) for order operations, not null.
     */

    public ServiceOrder(UserDAOO userDAOO){
        this.userDAOO=userDAOO;
    }
    /**
     * Registers a new order based on the provided RegistrationBodyOrder.
     *
     * @param registrationBodyOrder The order registration details.
     * @return The newly created Order object.
     */
    public Order registerOrder(RegistrationBodyOrder registrationBodyOrder) {
        Order order = new Order();
        order.setId(registrationBodyOrder.getId());
        order.setUsername(registrationBodyOrder.getUsername());
        order.setShippingAddress(registrationBodyOrder.getShippingAddress());
        order.setStatus(registrationBodyOrder.getStatus());

        userDAOO.save(order);
        return order;

    }
    /**
     * Finds an existing order based on the username provided in RegistrationBodyOrder.
     *
     * @param registrationBodyOrder The order details used for finding the order.
     * @return The found Order object, or null if not found.
     */
    public Order findOrder(RegistrationBodyOrder registrationBodyOrder) {
        Order order = new Order();
        order = userDAOO.findByUsername(registrationBodyOrder.getUsername());
        return order;

    }
    /**
     * Updates an existing order with the new details provided in RegistrationBodyOrder.
     *
     * @param registrationBodyOrder The new order details.
     * @return The updated Order object.
     */
    public Order updateOrder(RegistrationBodyOrder registrationBodyOrder) {
        Order order = findOrder(registrationBodyOrder);

        order.setShippingAddress(registrationBodyOrder.getShippingAddress());
        order.setStatus(registrationBodyOrder.getStatus());

        return userDAOO.save(order);

    }
    /**
     * Deletes an existing order based on the details provided in RegistrationBodyOrder.
     *
     * @param registrationBodyOrder The order details used to find and delete the order.
     */
    public Order deleteOrder(RegistrationBodyOrder registrationBodyOrder) {
        Order order = userDAOO.findByUsername(registrationBodyOrder.getUsername());

        userDAOO.delete(order);
        return order;

    }
    public Order findByUsername(OrderUsername orderData){
        Order order = userDAOO.findByUsername(orderData.getUsername());
        if(order != null){
            return order;
        }
        else{
            return null;
        }
    }


}