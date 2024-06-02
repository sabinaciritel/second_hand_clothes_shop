package com.example.demo.api.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A model class representing registration data for orders.
 */
public class RegistrationBodyOrder {
    private String username;
    private String shippingAddress;

    // Getters and setters


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistrationBodyOrder that = (RegistrationBodyOrder) o;
        return Objects.equals(username, that.username) && Objects.equals(shippingAddress, that.shippingAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, shippingAddress);
    }
}
