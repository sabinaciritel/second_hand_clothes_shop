package com.example.demo.model;

import jakarta.persistence.*;

/**
 * Represents the details of an order in the online store.
 * This includes the order it's related to, the product purchased, and the quantity of that product.
 * Each order detail is associated with one product and belongs to one order, forming a many-to-one relationship
 * with both the Order and Product entities.
 */
@Entity
@Table(name = "order_details")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private int quantity;

    /**
     * Default constructor for OrderDetail entity.
     */
    public OrderDetail() {
    }

    /**
     * Creates an order detail with specified order, product, and quantity.
     *
     * @param order    The order this detail belongs to.
     * @param product  The product being ordered.
     * @param quantity The quantity of the product.
     */
    public OrderDetail(Order order, Product product, int quantity) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }

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
     * Gets the order associated with this detail.
     * @return The order.
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Sets the order this detail is associated with.
     * @param order The order.
     */
    public void setOrder(Order order) {
        this.order = order;
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