package com.MicroserviceOrder.order_service.entity;

import jakarta.persistence.*;
@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int OrderId;
    private Long productId;
    private int quantity;

    public long getOrderId() {
        return OrderId;
    }

    public void setOrderId(int orderId) {
        OrderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Order(int orderId, Long productId, int quantity) {
        OrderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
    }
}

