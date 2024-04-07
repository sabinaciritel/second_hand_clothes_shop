//package com.example.demo.service;
//
//import com.example.demo.api.model.RegistrationBody;
//import com.example.demo.api.model.RegistrationBodyOrder;
//import com.example.demo.api.model.RegistrationBodyProduct;
//import com.example.demo.model.Order;
//import com.example.demo.model.Product;
//import com.example.demo.model.User;
//import com.example.demo.model.dao.UserDAO;
//import com.example.demo.model.dao.UserDAOO;
//import com.example.demo.model.dao.UserDAOP;
//import org.springframework.stereotype.Service;
///**
// * Service class for managing user operations.
// * This service provides methods to register, update, find, and delete users in the application.
// */
//@Service
//public class ServiceOrder {
//    private UserDAOO userDAOO;
//
//    public ServiceOrder(UserDAOO userDAOO){
//        this.userDAOO=userDAOO;
//    }
//    public Order registerOrder(RegistrationBodyOrder registrationBodyOrder) {
//        Order order = new Order();
//        order.setId(registrationBodyOrder.getId());
//        order.setUser(registrationBodyOrder.getUsername());
//        order.setShippingAddress(registrationBodyOrder.getShippingAddress());
//        order.setStatus(registrationBodyOrder.getStatus());
//
//        return userDAOO.save(order);
//
//    }
//    public Order findOrder(RegistrationBodyOrder registrationBodyOrder) {
//        Order order = new Order();
//        System.out.println(registrationBodyOrder.getId());
//        order = userDAOO.findByUsername(registrationBodyOrder.getUsername());
//        System.out.println(order.getShippingAddress());
//        System.out.println(order.getStatus());
//
//        return order;
//
//    }
//    public Order updateOrder(RegistrationBodyOrder registrationBodyOrder) {
//        Order order = findOrder(registrationBodyOrder);
//
//        order.setShippingAddress(registrationBodyOrder.getShippingAddress());
//        order.setStatus(registrationBodyOrder.getStatus());
//
//        return userDAOO.save(order);
//
//    }
//
//    public void deleteOrder(RegistrationBodyOrder registrationBodyOrder) {
//        Order order = new Order();
//        order =findOrder(registrationBodyOrder);
//        order.setShippingAddress(registrationBodyOrder.getShippingAddress());
//        order.setStatus(registrationBodyOrder.getStatus());
//        userDAOO.delete(order);
//
//    }
//
//
//}