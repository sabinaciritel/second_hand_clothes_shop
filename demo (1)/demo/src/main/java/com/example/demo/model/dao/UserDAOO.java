package com.example.demo.model.dao;

import com.example.demo.model.Order;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

/**
 * The UserDAOO interface provides methods for CRUD operations on Order entities.
 * It extends CrudRepository to leverage standard CRUD method implementations.
 * It specifies custom search operations for Order entities related to users.
 */
public interface UserDAOO extends CrudRepository<Order, Long> {
    /**
     * Searches and returns an order based on the associated username.
     *
     * @param username The username to base the search on. This is a string
     *                 that represents the unique identifier of the user associated with the order.
     * @return An instance of the Order class corresponding to the specified user. If no order
     *         is associated with the given username, returns null.
     */

    Order findByUsername(String username);

}