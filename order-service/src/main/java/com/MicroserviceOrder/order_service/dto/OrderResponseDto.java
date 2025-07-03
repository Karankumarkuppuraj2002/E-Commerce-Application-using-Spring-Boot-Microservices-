package com.MicroserviceOrder.order_service.dto;



public class OrderResponseDto {
    private Long orderId;
    private Long productId;
    private int quantity;
    private double totalPrize;

    public OrderResponseDto() {

    }


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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

    public double getTotalPrize() {
        return totalPrize;
    }

    public void setTotalPrize(double totalPrize) {
        this.totalPrize = totalPrize;
    }

    public OrderResponseDto(Long orderId, Long productId, int quantity, double totalPrize) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.totalPrize = totalPrize;
    }

    private  String productName;
    private  double productPrize;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrize() {
        return productPrize;
    }

    public void setProductPrize(double productPrize) {
        this.productPrize = productPrize;
    }

    public OrderResponseDto(String productName, double productPrize) {
        this.productName = productName;
        this.productPrize = productPrize;
    }

    public void setOrderId() {

    }
}

