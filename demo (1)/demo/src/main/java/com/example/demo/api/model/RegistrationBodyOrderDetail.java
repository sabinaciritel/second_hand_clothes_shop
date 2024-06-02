package com.example.demo.api.model;

import java.util.Objects;

/**
 * A model class representing registration data for order details.
 */
public class RegistrationBodyOrderDetail {
    private int product;
    private String username;
    private int quantity;

    // Getters and setters


    public int getProduct() {
        return product;
    }

    public void setProduct(int productid) {
        this.product = productid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistrationBodyOrderDetail that = (RegistrationBodyOrderDetail) o;
        return quantity == that.quantity && Objects.equals(product, that.product) && Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, username, quantity);
    }
}
