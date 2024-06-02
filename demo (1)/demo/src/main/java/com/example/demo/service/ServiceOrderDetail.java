package com.example.demo.service;

import com.example.demo.api.model.RegistrationBodyOrderDetail;
import com.example.demo.model.OrderDetail;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.model.dao.UserDAO;
import com.example.demo.model.dao.UserDAOOD;
import com.example.demo.model.dao.UserDAOP;
import com.example.demo.service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceOrderDetail {
    @Autowired
    private UserDAOOD userDAOOD;

    @Autowired
    private ServiceUser userService;

    @Autowired
    private UserDAOP userDAOP;
    @Autowired
    private UserDAO userDAO;

    public OrderDetail registerOrderDetail(RegistrationBodyOrderDetail registrationBodyOrderDetail) {
        Optional<Product> product = userDAOP.findById((long) registrationBodyOrderDetail.getProduct());
        User user = userDAO.findByUsername(registrationBodyOrderDetail.getUsername());
        OrderDetail orderDetail = new OrderDetail();
        if (user != null) {
            orderDetail.setProduct(product.get());
            orderDetail.setUser(user);
            orderDetail.setQuantity(registrationBodyOrderDetail.getQuantity());
            userDAOOD.save(orderDetail);
        }
        return orderDetail;
    }

    public void deleteByUser(String username){
        User user = userDAO.findByUsername(username);
        List<OrderDetail> orderDetails = new ArrayList<>();
        if(user!=null){
            orderDetails = userDAOOD.findByUser(user);
            for(OrderDetail orderDetail : orderDetails){
                userDAOOD.delete(orderDetail);
            }
        }
    }

    public List<OrderDetail> getOrderDetailsByUser(String username) {
        User user = userDAO.findByUsername(username);
        List<OrderDetail> orderDetails = new ArrayList<>();
        if(user!=null){
            orderDetails = userDAOOD.findByUser(user);
        }
        return orderDetails;
    }

}
