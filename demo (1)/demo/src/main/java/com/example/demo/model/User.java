package com.example.demo.model;

import com.example.demo.observerPattern.Observer;
import jakarta.persistence.*;

import java.util.Objects;

/**
 * The User entity represents a user in the database.
 * Each user has a unique identifier, an email address, a username, a password, and a role.
 * Both the email and the username are unique within the system, ensuring that there are no duplicate accounts.
 */
@Entity
@Table(name = "users")
public class User implements Observer {

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
    public void update() {
        System.out.println("Atenție! Stocul unui produs a ajuns la 0.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(email, user.email) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, username, password, role);
    }
}