
package com.example.demo.api.controller.auth;

import com.example.demo.api.model.LoginBody;
import com.example.demo.api.model.RegistrationBody;
import com.example.demo.model.User;
import com.example.demo.service.ServiceUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthentificationController {
    private ServiceUser serviceUser;

    public AuthentificationController(ServiceUser serviceUser) {
        this.serviceUser = serviceUser;
    }
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = serviceUser.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }



    /**
     * Registers a new user with the details provided in the registration body.
     *
     * @param registrationBody The registration details including email, username, password, and role.
     */

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegistrationBody registrationBody) {
        try {
            serviceUser.registerUser(registrationBody);
            return ResponseEntity.ok("Successfully registered user");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Registration failed: " + e.getMessage());
        }
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
    @PutMapping ("/update")
    public void updateUser(@RequestBody RegistrationBody registrationBody){
        serviceUser.updateUser(registrationBody);
    }
    /**
     * Deletes a user based on the details provided in the registration body. Similar to finding a user,
     * deletion typically requires a unique identifier within the {@code RegistrationBody}.
     *
     * @param registrationBody The user details to identify which user to delete.
     */
    @DeleteMapping ("/delete")
    public void deleteUser(@RequestBody RegistrationBody registrationBody){
        serviceUser.deleteUser(registrationBody);
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginBody loginBody) {
        User user = serviceUser.authenticateUser(loginBody);
        if (user != null) {
            return ResponseEntity.ok(user.getRole());
        } else {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }



}