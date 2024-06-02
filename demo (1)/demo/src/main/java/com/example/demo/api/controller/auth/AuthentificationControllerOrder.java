package com.example.demo.api.controller.auth;

import com.example.demo.api.model.RegistrationBodyOrder;
import com.example.demo.model.Order;
import com.example.demo.service.ServiceOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller for handling order authentication.
 */
@RestController
@RequestMapping("/authOrder")
public class AuthentificationControllerOrder {

    private final ServiceOrder serviceOrder;

    public AuthentificationControllerOrder(ServiceOrder serviceOrder) {
        this.serviceOrder = serviceOrder;
    }

    @PostMapping("/registerOrder")
    public ResponseEntity<Order> registerOrder(@RequestBody RegistrationBodyOrder registrationBodyOrder) {
        Order savedOrder = serviceOrder.registerOrder(registrationBodyOrder);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = serviceOrder.findAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/orders/user/{username}")
    public ResponseEntity<List<Order>> getOrdersByUser(@PathVariable String username) {
        List<Order> orders = serviceOrder.getOrdersByUser(username);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}
