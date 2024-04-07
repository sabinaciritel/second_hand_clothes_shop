package com.example.demo.service;

import com.example.demo.api.model.RegistrationBody;
import com.example.demo.model.User;
import com.example.demo.model.dao.UserDAO;
import org.springframework.stereotype.Service;
/**
 * Service class for managing user operations.
 * This service provides methods to register, update, find, and delete users in the application.
 */
@Service
public class ServiceUser {
    private UserDAO userDAO;
    /**
     * Constructs a ServiceUser with the specified User Data Access Object (DAO).
     *
     * @param userDAO the UserDAO to be used for user operations.
     */
    public ServiceUser(UserDAO userDAO){

        this.userDAO=userDAO;

    }

    /**
     * Registers a new user with the details provided in the registration body.
     *
     * @param registrationBody the registration details of the user.
     * @return the registered User entity.
     */
    public User registerUser(RegistrationBody registrationBody) {
        User user = new User();
        user.setId(registrationBody.getId());
        user.setEmail(registrationBody.getEmail());
        user.setUsername(registrationBody.getUsername());
        user.setPassword(registrationBody.getPassword());
        user.setRole(registrationBody.getRole());
        return userDAO.save(user);

    }
    /**
     * Updates an existing user with the details provided in the registration body.
     *
     * @param registrationBody the updated details of the user.
     * @return the updated User entity.
     */
    public User updateUser(RegistrationBody registrationBody) {
        User user = findUser(registrationBody);

        user.setEmail(registrationBody.getEmail());
        user.setPassword(registrationBody.getPassword());
        user.setRole(registrationBody.getRole());

        return userDAO.save(user);

    }
    /**
     * Deletes a user based on the details provided in the registration body.
     *
     * @param registrationBody the details of the user to delete.
     */
    public void deleteUser(RegistrationBody registrationBody) {
        User user = new User();
        user =findUser(registrationBody);
        user.setEmail(registrationBody.getEmail());
        user.setPassword(registrationBody.getPassword());
        user.setRole(registrationBody.getRole());
        userDAO.delete(user);

    }

    /**
     * Finds a user based on the details provided in the registration body.
     * This implementation specifically uses the username to find the user.
     *
     * @param registrationBody the details of the user to find.
     * @return the found User entity, or null if the user does not exist.
     */
    public User findUser(RegistrationBody registrationBody) {
        User user = new User();
        System.out.println(registrationBody.getId());
        System.out.println(registrationBody.getEmail());
        user = userDAO.findByUsername(registrationBody.getUsername());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getRole());
        return user;

    }
}