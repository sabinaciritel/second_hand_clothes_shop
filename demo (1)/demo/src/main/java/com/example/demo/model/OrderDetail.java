package com.example.demo.model;

import jakarta.persistence.*;

/**
 * Represents the details of an order in the online store.
 * This includes the product purchased and the user who made the purchase.
 * Each order detail is associated with one product and one user, forming a many-to-one relationship
 * with both the Product and User entities.
 */
@Entity
@Table(name = "order_details")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private int quantity;

    // Standard getters and setters are documented for their general purpose and use.

    /**
     * Gets the unique identifier for the order detail.
     * @return The ID of the order detail.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the order detail.
     * @param id The new ID for the order detail.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the product associated with this order detail.
     * @return The product.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Sets the product this detail is associated with.
     * @param product The product.
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Gets the user associated with this order detail.
     * @return The user.
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user this detail is associated with.
     * @param user The user.
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets the quantity of the product.
     * @return The quantity.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the product for this detail.
     * @param quantity The new quantity.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
