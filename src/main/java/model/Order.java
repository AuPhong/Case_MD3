package model;

import java.util.Date;

public class Order {
    private int orderId;
    private Date orderDate;
    private int status;
    private int customerId;
    private int sellerId;
    private int productId;
    private int productQuantity;
    private double totalPrice;


    public Order() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Order(Date orderDate, int status, int customerId, int sellerId, int productId, int productQuantity, double totalPrice) {
        this.orderDate = orderDate;
        this.status = status;
        this.customerId = customerId;
        this.sellerId = sellerId;
        this.productId = productId;
        this.productQuantity = productQuantity;
        this.totalPrice = totalPrice;
    }

    public Order(Date orderDate, int customerId, int status) {
        this.orderDate = orderDate;
        this.customerId = customerId;
        this.status = status;
    }

    public Order(int orderId, Date orderDate, int customerId, int sellerId, int status) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customerId = customerId;
        this.sellerId = sellerId;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public int isStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
