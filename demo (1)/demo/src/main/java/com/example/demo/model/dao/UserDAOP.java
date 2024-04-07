package com.example.demo.model.dao;

import com.example.demo.model.Product;
import com.example.demo.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * The UserDAOP interface extends CrudRepository to provide CRUD operations for Product entities.
 * It offers standard CRUD functionalities along with additional querying capabilities specifically for Product entities.
 */
public interface UserDAOP extends CrudRepository<Product, Long> {

    /**
     * Searches for and returns a product based on its name.
     *
     * @param name The name of the product to search for. This is a string that represents
     *             the unique name of the product.
     * @return A Product instance that matches the specified name. If no product is found with the given name,
     *         returns null.
     */
    Product findByName(String name);

}