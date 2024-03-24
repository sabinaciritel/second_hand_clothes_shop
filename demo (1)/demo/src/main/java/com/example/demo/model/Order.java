package com.example.demo.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The Order entity represents an order placed by a user in the online store.
 * It contains the user who placed the order, the shipping address, the order status,
 * and a list of order details that enumerate the purchased products and their quantities.
 */
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String shippingAddress;

    @Column(nullable = false)
    private String status;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails = new ArrayList<>();

    /**
     * Default constructor for Order entity.
     */
    public Order() {
    }

    /**
     * Constructs a new Order with the given user, shipping address, and status.
     *
     * @param user             The user who placed the order.
     * @param shippingAddress  The address to which the order will be shipped.
     * @param status           The current status of the order (e.g., "Pending", "Shipped", "Delivered").
     */
    public Order(User user, String shippingAddress, String status) {
        this.user = user;
        this.shippingAddress = shippingAddress;
        this.status = status;
    }

    // Standard getters and setters are documented for their general purpose and use.

    /**
     * Gets the unique identifier for the order.
     * @return the ID of the order.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the order.
     * @param id the new ID of the order.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the user who placed the order.
     * @return the user associated with the order.
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user who placed the order.
     * @param user the new user associated with the order.
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets the shipping address for the order.
     * @return the shipping address.
     */
    public String getShippingAddress() {
        return shippingAddress;
    }

    /**
     * Sets the shipping address for the order.
     * @param shippingAddress the new shipping address.
     */
    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    /**
     * Gets the status of the order.
     * @return the current status of the order.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the order.
     * @param status the new status of the order.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the details for the order.
     * @return a list of order details.
     */
    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    /**
     * Sets the details for the order.
     * @param orderDetails a new list of order details.
     */
    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}