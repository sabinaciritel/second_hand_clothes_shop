package com.example.demo.api.controller.auth;

import com.example.demo.api.model.RegistrationBodyOrderDetail;
import com.example.demo.model.OrderDetail;
import com.example.demo.service.ServiceOrderDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller for handling order detail registration.
 */
@RestController
@RequestMapping("/authOrderDetail")
public class AuthentificationControllerOrderDetail {

    private final ServiceOrderDetail serviceOrderDetail;

    public AuthentificationControllerOrderDetail(ServiceOrderDetail serviceOrderDetail) {
        this.serviceOrderDetail = serviceOrderDetail;
    }

    @PostMapping("/registerOrderDetail")
    public ResponseEntity<OrderDetail> registerOrderDetail(@RequestBody RegistrationBodyOrderDetail registrationBodyOrderDetail) {
        System.out.println(registrationBodyOrderDetail.getProduct());
        System.out.println(registrationBodyOrderDetail.getUsername());
        System.out.println(registrationBodyOrderDetail.getQuantity());
        OrderDetail savedOrderDetail = serviceOrderDetail.registerOrderDetail(registrationBodyOrderDetail);
        return new ResponseEntity<>(savedOrderDetail, HttpStatus.CREATED);
    }

    @GetMapping("/orderDetails/user/{username}")
    public ResponseEntity<List<OrderDetail>> getOrderDetailsByUser(@PathVariable String username) {
        List<OrderDetail> orderDetails = serviceOrderDetail.getOrderDetailsByUser(username);
        return new ResponseEntity<>(orderDetails, HttpStatus.OK);
    }

}
