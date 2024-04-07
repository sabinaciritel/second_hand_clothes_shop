
package com.example.demo.api.controller.auth;

import com.example.demo.api.model.RegistrationBody;
import com.example.demo.api.model.RegistrationBodyProduct;
import com.example.demo.service.ServiceProduct;
import com.example.demo.service.ServiceUser;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authProduct")
public class AuthentificationControllerProduct {
    private ServiceProduct serviceProduct;

    public AuthentificationControllerProduct(ServiceProduct serviceProduct) {
        this.serviceProduct = serviceProduct;
    }

    @PostMapping("/registerProduct")
    public void registerProduct(@RequestBody RegistrationBodyProduct registrationBodyProduct){
        serviceProduct.registerProduct(registrationBodyProduct);

    }
    @GetMapping("/findProduct")
    public void findProduct(@RequestBody RegistrationBodyProduct registrationBodyProduct){
        serviceProduct.findProduct(registrationBodyProduct);

    }
    @PutMapping("/updateProduct")
    public void putProduct(@RequestBody RegistrationBodyProduct registrationBodyProduct){
        serviceProduct.updateProduct(registrationBodyProduct);

    }
    @DeleteMapping("/deleteProduct")
    public void deleteProduct(@RequestBody RegistrationBodyProduct registrationBodyProduct){
        serviceProduct.deleteProduct(registrationBodyProduct);

    }



}