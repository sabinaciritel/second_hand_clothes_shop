
package com.example.demo.api.controller.auth;

import com.example.demo.api.model.RegistrationBody;
import com.example.demo.api.model.RegistrationBodyProduct;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.service.ServiceProduct;
import com.example.demo.service.ServiceUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

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
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllUsers() {
        List<Product> products = serviceProduct.findAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
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
        serviceProduct.findProduct(registrationBodyProduct.getId());

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
    @PostMapping("/{id}/uploadImage")
    public ResponseEntity<String> uploadImage(@PathVariable Long id, @RequestParam("image") MultipartFile file) {
        try {
            Optional<Product> productOptional = serviceProduct.findProduct(id);
            if (!productOptional.isPresent()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
            }
            Product product = productOptional.get();
            product.setImage(file.getBytes());
            serviceProduct.updProduct(product);
            return ResponseEntity.ok("Image uploaded successfully");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload image");
        }
    }

    @GetMapping("/{id}/image")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        Optional<Product> productOptional = serviceProduct.findProduct(id);
        if (!productOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        Product product = productOptional.get();
        byte[] image = product.getImage();
        return ResponseEntity.ok().contentType(org.springframework.http.MediaType.IMAGE_JPEG).body(image);
    }



}