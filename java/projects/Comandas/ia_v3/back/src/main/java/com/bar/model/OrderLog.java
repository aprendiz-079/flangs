package com.bar.model;

import java.time.LocalDateTime;

public class OrderLog {
    private int id;
    private int orderId;
    private String description;
    private double balanceAfter;
    private LocalDateTime createdAt;
    
    public OrderLog() {}
    
    public OrderLog(String description, double balanceAfter) {
        this.description = description;
        this.balanceAfter = balanceAfter;
        this.createdAt = LocalDateTime.now();
    }
    
    public OrderLog(int id, String description, double balanceAfter, LocalDateTime createdAt) {
        this.id = id;
        this.description = description;
        this.balanceAfter = balanceAfter;
        this.createdAt = createdAt;
    }
    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public double getBalanceAfter() { return balanceAfter; }
    public void setBalanceAfter(double balanceAfter) { this.balanceAfter = balanceAfter; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    
    public String getFormattedTimestamp() {
        return createdAt.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM HH:mm"));
    }
    
    public String getFormattedBalance() {
        String prefix = balanceAfter >= 0 ? "+ " : "- ";
        return prefix + "R$ " + String.format("%.2f", Math.abs(balanceAfter));
    }
}
