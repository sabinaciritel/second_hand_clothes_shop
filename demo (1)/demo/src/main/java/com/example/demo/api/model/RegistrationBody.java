
 package com.example.demo.api.model;

import jakarta.persistence.Column;
 /**
  * A model class representing registration data.
  */
public class RegistrationBody {
    private Long id;
    private String email;
    private String username;
    private String password;
    private String role;
     /**
      * Retrieves the ID of the registration body.
      *
      * @return the ID of the registration body
      */
    public Long getId() {
        return id;
    }


     /**
      * Sets the ID of the registration body.
      *
      * @param id the ID of the registration body to set
      */
    public void setId(Long id) {
        this.id = id;
    }
     /**
      * Retrieves the email of the registration body.
      *
      * @return the email of the registration body
      */
    public String getEmail() {
        return email;
    }
     /**
      * Sets the email of the registration body.
      *
      * @param email the email of the registration body to set
      */
    public void setEmail(String email) {
        this.email = email;
    }
     /**
      * Retrieves the username of the registration body.
      *
      * @return the username of the registration body
      */
    public String getUsername() {
        return username;
    }
     /**
      * Sets the username of the registration body.
      *
      * @param username the username of the registration body to set
      */
    public void setUsername(String username) {
        this.username = username;
    }
     /**
      * Retrieves the password of the registration body.
      *
      * @return the password of the registration body
      */
    public String getPassword() {
        return password;
    }
     /**
      * Sets the password of the registration body.
      *
      * @param password the password of the registration body to set
      */
    public void setPassword(String password) {
        this.password = password;
    }
     /**
      * Retrieves the role of the registration body.
      *
      * @return the role of the registration body
      */
    public String getRole() {
        return role;
    }
     /**
      * Sets the role of the registration body.
      *
      * @param role the role of the registration body to set
      */
    public void setRole(String role) {
        this.role = role;
    }
}