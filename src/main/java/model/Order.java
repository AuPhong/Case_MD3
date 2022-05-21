package model;

import java.util.Date;

public class Order {
    private int orderId;
    private Date orderDate;
    private int customerId;
    private int sellerId;
    private boolean status;

    public Order() {
    }

    public Order(int orderId, Date orderDate, int customerId, int sellerId, boolean status) {
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
