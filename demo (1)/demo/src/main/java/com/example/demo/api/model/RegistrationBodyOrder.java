package com.example.demo.api.model;

import com.example.demo.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

/**
 * A model class representing registration data for orders.
 */
public class RegistrationBodyOrder {
    private Long id;
    private String username;

    private String shippingAddress;

    private String status;
    /**
     * Retrieves the ID of the order registration body.
     *
     * @return the ID of the order registration body
     */
    public Long getId() {
        return id;
    }
    /**
     * Sets the ID of the order registration body.
     *
     * @param id the ID of the order registration body to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * Retrieves the username associated with the order registration body.
     *
     * @return the username associated with the order registration body
     */
    public String getUsername() {
        return username;
    }
    /**
     * Sets the username associated with the order registration body.
     *
     * @param username the username associated with the order registration body to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * Retrieves the shipping address of the order registration body.
     *
     * @return the shipping address of the order registration body
     */
    public String getShippingAddress() {
        return shippingAddress;
    }
    /**
     * Sets the shipping address of the order registration body.
     *
     * @param shippingAddress the shipping address of the order registration body to set
     */
    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
    /**
     * Retrieves the status of the order registration body.
     *
     * @return the status of the order registration body
     */
    public String getStatus() {
        return status;
    }
    /**
     * Sets the status of the order registration body.
     *
     * @param status the status of the order registration body to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistrationBodyOrder that = (RegistrationBodyOrder) o;
        return Objects.equals(id, that.id) && Objects.equals(username, that.username) && Objects.equals(shippingAddress, that.shippingAddress) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, shippingAddress, status);
    }
}
