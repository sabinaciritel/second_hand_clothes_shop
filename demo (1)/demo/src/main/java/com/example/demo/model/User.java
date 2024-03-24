package com.example.demo.model;

import jakarta.persistence.*;

/**
 * The User entity represents a user in the database.
 * Each user has a unique identifier, an email address, a username, a password, and a role.
 * Both the email and the username are unique within the system, ensuring that there are no duplicate accounts.
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true) // Ensures the username is unique and required
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;

    /**
     * Default constructor for User entity.
     */
    public User() {}

    /**
     * Constructs a new User with the specified email, username, password, and role.
     *
     * @param email    The user's email address, must be unique.
     * @param username The user's username, must be unique.
     * @param password The user's password.
     * @param role     The user's role within the system.
     */
    public User(String email, String username, String password, String role) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // Getters and Setters

    /**
     * Gets the user's ID.
     * @return The unique ID of the user.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the user's ID.
     * @param id The unique ID to be assigned to the user.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the user's email address.
     * @return The email address of the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the user's email address.
     * @param email The new email address for the user.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the username of the user.
     * @return The username of the user.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user.
     * @param username The new username for the user.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the user's password.
     * @return The password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the user's password.
     * @param password The new password for the user.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the role of the user within the system.
     * @return The role of the user.
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the role of the user within the system.
     * @param role The new role for the user.
     */
    public void setRole(String role) {
        this.role = role;
    }
}