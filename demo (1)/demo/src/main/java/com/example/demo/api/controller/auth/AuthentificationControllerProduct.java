
package com.example.demo.api.controller.auth;

import com.example.demo.api.model.RegistrationBody;
import com.example.demo.api.model.RegistrationBodyProduct;
import com.example.demo.service.ServiceProduct;
import com.example.demo.service.ServiceUser;
import org.springframework.web.bind.annotation.*;
/**
 * Controller for handling product authentication.
 */
@RestController
@RequestMapping("/authProduct")
public class AuthentificationControllerProduct {
    private ServiceProduct serviceProduct;
    /**
     * Constructor for the product authentication controller.
     *
     * @param serviceProduct the service for managing products
     */
    public AuthentificationControllerProduct(ServiceProduct serviceProduct) {
        this.serviceProduct = serviceProduct;
    }
    /**
     * Endpoint for registering a new product.
     *
     * @param registrationBodyProduct the object containing the product details
     */
    @PostMapping("/registerProduct")
    public void registerProduct(@RequestBody RegistrationBodyProduct registrationBodyProduct){
        serviceProduct.registerProduct(registrationBodyProduct);

    }
    /**
     * Endpoint for finding a product.
     *
     * @param registrationBodyProduct the object containing the search criteria for the product
     */
    @GetMapping("/findProduct")
    public void findProduct(@RequestBody RegistrationBodyProduct registrationBodyProduct){
        serviceProduct.findProduct(registrationBodyProduct);

    }
    /**
     * Endpoint for updating an existing product.
     *
     * @param registrationBodyProduct the object containing the updated details of the product
     */
    @PutMapping("/updateProduct")
    public void putProduct(@RequestBody RegistrationBodyProduct registrationBodyProduct){
        serviceProduct.updateProduct(registrationBodyProduct);

    }
    /**
     * Endpoint for deleting a product.
     *
     * @param registrationBodyProduct the object containing the product details to be deleted
     */
    @DeleteMapping("/deleteProduct")
    public void deleteProduct(@RequestBody RegistrationBodyProduct registrationBodyProduct){
        serviceProduct.deleteProduct(registrationBodyProduct);

    }



}