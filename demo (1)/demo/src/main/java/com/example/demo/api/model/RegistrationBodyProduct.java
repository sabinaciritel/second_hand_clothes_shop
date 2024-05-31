package com.example.demo.api.model;

import jakarta.persistence.Column;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * A model class representing registration data for products.
 */
public class RegistrationBodyProduct {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private int stockQuantity;
    private byte[] image;
    /**
     * Retrieves the ID of the product registration body.
     *
     * @return the ID of the product registration body
     */
    public Long getId() {
        return id;
    }
    /**
     * Sets the ID of the product registration body.
     *
     * @param id the ID of the product registration body to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * Retrieves the name of the product.
     *
     * @return the name of the product
     */
    public String getName() {
        return name;
    }
    /**
     * Sets the name of the product.
     *
     * @param name the name of the product to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Retrieves the description of the product.
     *
     * @return the description of the product
     */
    public String getDescription() {
        return description;
    }
    /**
     * Sets the description of the product.
     *
     * @param description the description of the product to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Retrieves the price of the product.
     *
     * @return the price of the product
     */
    public BigDecimal getPrice() {
        return price;
    }
    /**
     * Sets the price of the product.
     *
     * @param price the price of the product to set
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    /**
     * Retrieves the stock quantity of the product.
     *
     * @return the stock quantity of the product
     */
    public int getStockQuantity() {
        return stockQuantity;
    }
    /**
     * Sets the stock quantity of the product.
     *
     * @param stockQuantity the stock quantity of the product to set
     */
    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistrationBodyProduct that = (RegistrationBodyProduct) o;
        return stockQuantity == that.stockQuantity && Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, stockQuantity);
    }
}
