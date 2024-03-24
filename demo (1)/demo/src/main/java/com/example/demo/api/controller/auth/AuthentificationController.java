package com.example.demo.api.controller.auth;

import com.example.demo.api.model.RegistrationBody;
import com.example.demo.service.ServiceUser;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for authentication-related actions including user registration, finding, updating, and deletion.
 * This controller handles HTTP requests for various authentication and user management operations.
 */
@RestController
@RequestMapping("/auth")
public class AuthentificationController {

    private final ServiceUser serviceUser;

    /**
     * Constructs an AuthentificationController with the specified user service.
     *
     * @param serviceUser The service for user operations, including registration, finding, updating, and deleting users.
     */
    public AuthentificationController(ServiceUser serviceUser) {
        this.serviceUser = serviceUser;
    }

    /**
     * Registers a new user with the details provided in the registration body.
     *
     * @param registrationBody The registration details including email, username, password, and role.
     */
    @PostMapping("/register")
    public void registerUser(@RequestBody RegistrationBody registrationBody){
        serviceUser.registerUser(registrationBody);
    }

    /**
     * Finds a user based on the details provided in the registration body. Typically, this operation might require
     * a unique identifier or username within the {@code RegistrationBody}.
     *
     * @param registrationBody The user details to use for finding a specific user.
     */
    @GetMapping("/find")
    public void findUser(@RequestBody RegistrationBody registrationBody){
        serviceUser.findUser(registrationBody);
    }

    /**
     * Updates an existing user's details. This method expects a complete {@code RegistrationBody} that includes
     * the identifier of the user to update along with the new details.
     *
     * @param registrationBody The updated user details.
     */
    @PutMapping("/update")
    public void updateUser(@RequestBody RegistrationBody registrationBody){
        serviceUser.updateUser(registrationBody);
    }

    /**
     * Deletes a user based on the details provided in the registration body. Similar to finding a user,
     * deletion typically requires a unique identifier within the {@code RegistrationBody}.
     *
     * @param registrationBody The user details to identify which user to delete.
     */
    @DeleteMapping("/delete")
    public void deleteUser(@RequestBody RegistrationBody registrationBody){
        serviceUser.deleteUser(registrationBody);
    }
}