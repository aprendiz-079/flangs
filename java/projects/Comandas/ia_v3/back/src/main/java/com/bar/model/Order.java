package com.bar.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private String clientName;
    private List<OrderItem> items;
    private List<OrderLog> logs;
    private boolean open;
    private LocalDateTime createdAt;
    
    public Order() {
        this.items = new ArrayList<>();
        this.logs = new ArrayList<>();
    }
    
    public Order(int id, String clientName, boolean open, LocalDateTime createdAt) {
        this.id = id;
        this.clientName = clientName;
        this.items = new ArrayList<>();
        this.logs = new ArrayList<>();
        this.open = open;
        this.createdAt = createdAt;
    }
    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getClientName() { return clientName; }
    public void setClientName(String clientName) { this.clientName = clientName; }
    
    public List<OrderItem> getItems() { return items; }
    public void setItems(List<OrderItem> items) { this.items = items; }
    
    public List<OrderLog> getLogs() { return logs; }
    public void setLogs(List<OrderLog> logs) { this.logs = logs; }
    
    public boolean isOpen() { return open; }
    public void setOpen(boolean open) { this.open = open; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    
    public double getCredit() {
        return items.stream()
            .filter(OrderItem::isPaid)
            .mapToDouble(OrderItem::getTotal)
            .sum();
    }
    
    public double getDebit() {
        return items.stream()
            .filter(i -> !i.isPaid())
            .mapToDouble(OrderItem::getTotal)
            .sum();
    }
    
    public double getBalance() {
        return getCredit() - getDebit();
    }
    
    public OrderItem getItemByCode(int code) {
        for (OrderItem item : items) {
            if (item.getCode() == code) {
                return item;
            }
        }
        return null;
    }
    
    public void addLog(String description, double balanceAfter) {
        logs.add(new OrderLog(description, balanceAfter));
    }
}
