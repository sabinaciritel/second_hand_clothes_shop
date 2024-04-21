package com.example.demo.service;

import com.example.demo.api.model.*;
import com.example.demo.model.Order;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.model.dao.UserDAO;
import com.example.demo.model.dao.UserDAOO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceOrderTest {
    @Mock
    private UserDAOO userDAOOmock;
    private ServiceOrder serviceOrder;
    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        serviceOrder = new ServiceOrder(userDAOOmock);

    }

    @Test
    public void registerOrderTest(){
        RegistrationBodyOrder orderBody = new RegistrationBodyOrder();
        orderBody.setUsername("ioanabadea");
        orderBody.setStatus("delivered");
        orderBody.setShippingAddress("izlazului 8");

        Order orderCreated = new Order();
        orderCreated.setId(orderBody.getId());
        orderCreated.setUsername(orderBody.getUsername());
        orderCreated.setStatus(orderBody.getStatus());
        orderCreated.setShippingAddress(orderBody.getShippingAddress());

        Mockito.when(userDAOOmock.save(orderCreated)).thenReturn(orderCreated);
        Order order = serviceOrder.registerOrder(orderBody);

        Mockito.verify(userDAOOmock).save(order);
    }
    @Test
    public void findOrderTest(){
        RegistrationBodyOrder orderData = new RegistrationBodyOrder();
        serviceOrder.findOrder(orderData);
        Mockito.verify(userDAOOmock).findByUsername(orderData.getUsername());
    }
    @Test
    public void deleteOrderTest(){
        RegistrationBodyOrder orderData = new RegistrationBodyOrder();
        Order order = serviceOrder.deleteOrder(orderData);
        Mockito.verify(userDAOOmock).delete(order);
    }
    @Test
    public void updateOrderTest(){
        RegistrationBodyOrder orderData = new RegistrationBodyOrder();
        Mockito.when(serviceOrder.findByUsername(new OrderUsername())).thenReturn(new Order());
        Order order = serviceOrder.updateOrder(orderData);
        Mockito.verify(userDAOOmock).findByUsername(orderData.getUsername());
    }
    @Test

    public void findUserByUsernameTest(){
        OrderUsername order = new OrderUsername();
        serviceOrder.findByUsername(order);
        Mockito.verify(userDAOOmock).findByUsername(order.getUsername());
    }
}
