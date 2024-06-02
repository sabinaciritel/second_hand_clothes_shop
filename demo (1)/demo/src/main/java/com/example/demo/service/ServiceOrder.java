package com.example.demo.service;

import com.example.demo.api.model.RegistrationBodyOrder;
import com.example.demo.model.*;

import com.example.demo.model.dao.UserDAO;
import com.example.demo.model.dao.UserDAOO;
import com.example.demo.model.dao.UserDAOOD;
import com.example.demo.model.dao.UserDAOP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceOrder {
    @Autowired
    private UserDAOO userDAOO;

    @Autowired
    private ServiceUser userService;

    @Autowired
    private UserDAOP userDAOP;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private UserDAOOD userDAOOD;

    public Order registerOrder(RegistrationBodyOrder registrationBodyOrder) {
        User user = userDAO.findByUsername(registrationBodyOrder.getUsername());
        Order order = new Order();
        if (user != null) {
            order.setUser(user);
            order.setShippingAddress(registrationBodyOrder.getShippingAddress());
            List<OrderDetail> orderDetails = userDAOOD.findByUser(user);
            for (OrderDetail orderDetail : orderDetails) {
                Optional<Product> product = userDAOP.findById(orderDetail.getId());
                if (product.isPresent()) {
                    order.addProduct(product.get());
                }
                userDAOOD.delete(orderDetail);
            }
            userDAOO.save(order);
        }
        return order;
    }


    public List<Order> findAllOrders() {
        return userDAOO.findAll();
    }

    public List<Order> getOrdersByUser(String username) {
        User user = userDAO.findByUsername(username);
        List<Order> orders = new ArrayList<>();
        if (user != null) {
            orders = userDAOO.findByUser(user);
        }
        return orders;
    }
}
