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
/**
 * Tests for the ServiceOrder class that manages order operations.
 */
public class ServiceOrderTest {
    @Mock
    private UserDAOO userDAOOmock;
    private ServiceOrder serviceOrder;
    /**
     * Sets up the environment before each test.
     * This method initializes the mocks and creates an instance of ServiceOrder.
     */
    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        serviceOrder = new ServiceOrder(userDAOOmock);

    }
    /**
     * Tests the registration of an order using the ServiceOrder.
     * Verifies if the order is saved correctly.
     */
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
    /**
     * Tests finding an order by username using the ServiceOrder.
     * Verifies if the correct method on the mock is called.
     */
    @Test
    public void findOrderTest(){
        RegistrationBodyOrder orderData = new RegistrationBodyOrder();
        serviceOrder.findOrder(orderData);
        Mockito.verify(userDAOOmock).findByUsername(orderData.getUsername());
    }
    /**
     * Tests the deletion of an order using the ServiceOrder.
     * Verifies if the correct delete method on the mock is called.
     */
    @Test
    public void deleteOrderTest(){
        RegistrationBodyOrder orderData = new RegistrationBodyOrder();
        Order order = serviceOrder.deleteOrder(orderData);
        Mockito.verify(userDAOOmock).delete(order);
    }
    /**
     * Tests the update of an order using the ServiceOrder.
     * Verifies if the correct find method on the mock is called.
     */
    @Test
    public void updateOrderTest(){
        RegistrationBodyOrder orderData = new RegistrationBodyOrder();
        Mockito.when(serviceOrder.findByUsername(new OrderUsername())).thenReturn(new Order());
        Order order = serviceOrder.updateOrder(orderData);
        Mockito.verify(userDAOOmock).findByUsername(orderData.getUsername());
    }
    @Test
/**
 * Tests finding a user by username.
 * This test verifies the functionality of retrieving a user by their username using the findByUsername method.
 */
    public void findUserByUsernameTest(){
        OrderUsername order = new OrderUsername();
        serviceOrder.findByUsername(order);
        Mockito.verify(userDAOOmock).findByUsername(order.getUsername());
    }
}
