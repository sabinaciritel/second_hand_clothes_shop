
package com.example.demo.api.controller.auth;

import com.example.demo.api.model.RegistrationBody;
import com.example.demo.api.model.RegistrationBodyOrder;
import com.example.demo.api.model.RegistrationBodyProduct;
import com.example.demo.service.ServiceOrder;
import com.example.demo.service.ServiceProduct;
import com.example.demo.service.ServiceUser;
import org.springframework.web.bind.annotation.*;
/**
 * Controller for handling order authentication.
 */
@RestController
@RequestMapping("/authOrder")
public class AuthentificationControllerOrder {
    private ServiceOrder serviceOrder;
    /**
     * Constructor for the order authentication controller.
     *
     * @param serviceOrder the service for managing orders
     */
    public AuthentificationControllerOrder(ServiceOrder serviceOrder) {
        this.serviceOrder = serviceOrder;
    }
    /**
     * Endpoint for registering a new order.
     *
     * @param registrationBodyOrder the object containing the order details
     */
    @PostMapping("/registerOrder")
    public void registerOrder(@RequestBody RegistrationBodyOrder registrationBodyOrder){
        serviceOrder.registerOrder(registrationBodyOrder);

    }
    /**
     * Endpoint for finding an order.
     *
     * @param registrationBodyOrder the object containing the search criteria for the order
     */
    @GetMapping("/findOrder")
    public void findOrder(@RequestBody RegistrationBodyOrder registrationBodyOrder){
        serviceOrder.findOrder(registrationBodyOrder);

    }

    /**
     * Endpoint for updating an existing order.
     *
     * @param registrationBodyOrder the object containing the updated details of the order
     */
    @PutMapping("/updateOrder")
    public void putOrder(@RequestBody RegistrationBodyOrder registrationBodyOrder){
        serviceOrder.updateOrder(registrationBodyOrder);

    }
    /**
     * Endpoint for deleting an order.
     *
     * @param registrationBodyOrder the object containing the order details to be deleted
     */
    @DeleteMapping("/deleteOrder")
    public void deleteOrder(@RequestBody RegistrationBodyOrder registrationBodyOrder){
        serviceOrder.deleteOrder(registrationBodyOrder);

    }



}