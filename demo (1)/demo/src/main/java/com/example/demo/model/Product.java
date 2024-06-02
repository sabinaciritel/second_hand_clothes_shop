package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

/**
 * The Product entity represents a product in the online store.
 * It contains information about the product such as its name, description, price, and quantity in stock.
 * Each product has a unique identifier and must have a non-null name, price, and stock quantity.
 */
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 1000)
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private int stockQuantity;
    @Lob
    @Column(name = "image", columnDefinition="LONGBLOB")
    private byte[] image;

    /**
     * Default constructor for Product entity.
     */
    public Product() {
    }

    /**
     * Constructs a new Product with the specified name, description, price, and stock quantity.
     *
     * @param name          The name of the product, which is a non-nullable field.
     * @param description   A brief description of the product, limited to 1000 characters.
     * @param price         The price of the product, which is a non-nullable field.
     * @param stockQuantity The number of units of the product available in stock, which is a non-nullable field.
     */
    public Product(String name, String description, BigDecimal price, int stockQuantity,byte[] image) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.image = image;
    }

    // Getters and setters are documented for accessibility by the JPA and other calling classes.

    /**
     * Gets the ID of the product.
     * @return The unique identifier of the product.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the product.
     * @param id The unique identifier to be assigned to the product.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the name of the product.
     * @return The name of the product.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the product.
     * @param name The new name for the product.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description of the product.
     * @return The description of the product.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the product.
     * @param description The new description for the product.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the price of the product.
     * @return The price of the product.
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets the price of the product.
     * @param price The new price for the product.
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Gets the stock quantity of the product.
     * @return The stock quantity of the product.
     */
    public int getStockQuantity() {
        return stockQuantity;
    }

    /**
     * Sets the stock quantity of the product.
     * @param stockQuantity The new stock quantity for the product.
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
}