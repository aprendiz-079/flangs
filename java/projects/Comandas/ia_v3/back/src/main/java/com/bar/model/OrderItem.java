package com.bar.model;

import java.time.LocalDateTime;

public class OrderItem {
    private int code;
    private int orderId;
    private String name;
    private int quantity;
    private double unitPrice;
    private boolean paid;
    private LocalDateTime createdAt;
    
    public OrderItem() {}
    
    public OrderItem(int code, String name, int quantity, double unitPrice, boolean paid, LocalDateTime createdAt) {
        this.code = code;
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.paid = paid;
        this.createdAt = createdAt;
    }
    
    public int getCode() { return code; }
    public void setCode(int code) { this.code = code; }
    
    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    
    public double getUnitPrice() { return unitPrice; }
    public void setUnitPrice(double unitPrice) { this.unitPrice = unitPrice; }
    
    public boolean isPaid() { return paid; }
    public void setPaid(boolean paid) { this.paid = paid; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    
    public double getTotal() {
        return quantity * unitPrice;
    }
    
    public void incrementQuantity() { this.quantity++; }
    
    public boolean decrementQuantity() {
        if (this.quantity > 1) {
            this.quantity--;
            return true;
        }
        return false;
    }
    
    public String getStatus() { return paid ? "Pago" : "À pagar"; }
}
