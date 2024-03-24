package com.example.demo.api.model;

/**
 * A Data Transfer Object (DTO) used for carrying user registration data.
 * It encapsulates the user details submitted during the registration process,
 * including email, username, password, and role.
 */
public class RegistrationBody {

    private Long id;
    private String email;
    private String username;
    private String password;
    private String role;

    /**
     * Gets the ID of the user.
     * This may not be used directly in registration but is useful for consistency in DTOs.
     *
     * @return The ID of the user.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the user.
     *
     * @param id The new ID value for the user.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the email of the user.
     *
     * @return The email address of the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the user.
     *
     * @param email The new email address for the user.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the username of the user.
     *
     * @return The username of the user.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user.
     *
     * @param username The new username for the user.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password of the user.
     * Note: In a real-world application, this would be a hashed password rather than plain text.
     *
     * @return The password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password The new password for the user.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the role of the user.
     *
     * @return The role assigned to the user.
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the role of the user.
     *
     * @param role The new role for the user.
     */
    public void setRole(String role) {
        this.role = role;
    }
}