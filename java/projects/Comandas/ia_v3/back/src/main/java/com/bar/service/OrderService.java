package com.bar.service;

import com.bar.Database;
import java.sql.*;
import java.util.*;

public class OrderService {
    
    public Map<String, Object> createOrder(String clientName) {
        try {
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO orders (client_name) VALUES (?)",
                Statement.RETURN_GENERATED_KEYS
            );
            ps.setString(1, clientName);
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int orderId = rs.getInt(1);
                addLog(orderId, "Comanda criada", 0);
                return getOrder(orderId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Map<String, Object> getOrder(int orderId) {
        try {
            Connection conn = Database.getConnection();
            
            // Busca comanda
            PreparedStatement ps = conn.prepareStatement(
                "SELECT * FROM orders WHERE id = ?"
            );
            ps.setInt(1, orderId);
            ResultSet rs = ps.executeQuery();
            
            if (!rs.next()) return null;
            
            Map<String, Object> order = new LinkedHashMap<>();
            order.put("id", rs.getInt("id"));
            order.put("clientName", rs.getString("client_name"));
            order.put("open", rs.getInt("is_open") == 1);
            order.put("createdAt", rs.getString("created_at"));
            
            // Busca itens
            PreparedStatement psItems = conn.prepareStatement(
                "SELECT * FROM order_items WHERE order_id = ? ORDER BY code"
            );
            psItems.setInt(1, orderId);
            ResultSet rsItems = psItems.executeQuery();
            
            List<Map<String, Object>> items = new ArrayList<>();
            double credit = 0, debit = 0;
            
            while (rsItems.next()) {
                Map<String, Object> item = new LinkedHashMap<>();
                item.put("code", rsItems.getInt("code"));
                item.put("name", rsItems.getString("name"));
                item.put("quantity", rsItems.getInt("quantity"));
                item.put("unitPrice", rsItems.getDouble("unit_price"));
                item.put("total", rsItems.getInt("quantity") * rsItems.getDouble("unit_price"));
                item.put("paid", rsItems.getInt("is_paid") == 1);
                item.put("dateTime", rsItems.getString("created_at"));
                
                if (rsItems.getInt("is_paid") == 1) {
                    credit += rsItems.getInt("quantity") * rsItems.getDouble("unit_price");
                } else {
                    debit += rsItems.getInt("quantity") * rsItems.getDouble("unit_price");
                }
                
                items.add(item);
            }
            
            order.put("items", items);
            order.put("credit", credit);
            order.put("debit", debit);
            order.put("balance", credit - debit);
            
            // Busca logs
            PreparedStatement psLogs = conn.prepareStatement(
                "SELECT * FROM order_logs WHERE order_id = ? ORDER BY id"
            );
            psLogs.setInt(1, orderId);
            ResultSet rsLogs = psLogs.executeQuery();
            
            List<Map<String, Object>> logs = new ArrayList<>();
            while (rsLogs.next()) {
                Map<String, Object> log = new LinkedHashMap<>();
                log.put("timestamp", rsLogs.getString("created_at"));
                log.put("description", rsLogs.getString("description"));
                log.put("balanceAfter", rsLogs.getDouble("balance_after"));
                logs.add(log);
            }
            order.put("logs", logs);
            
            return order;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Map<String, Object>> listOrders() {
        List<Map<String, Object>> orders = new ArrayList<>();
        try {
            Connection conn = Database.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id FROM orders ORDER BY id DESC");
            
            while (rs.next()) {
                orders.add(getOrder(rs.getInt("id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
    
    public Map<String, Object> addItem(int orderId, String name, int quantity, double unitPrice, boolean paid) {
        try {
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO order_items (order_id, name, quantity, unit_price, is_paid) VALUES (?,?,?,?,?)"
            );
            ps.setInt(1, orderId);
            ps.setString(2, name);
            ps.setInt(3, quantity);
            ps.setDouble(4, unitPrice);
            ps.setInt(5, paid ? 1 : 0);
            ps.executeUpdate();
            
            String type = paid ? "crédito" : "débito";
            double total = quantity * unitPrice;
            double balance = getBalance(orderId);
            addLog(orderId, String.format("%s; R$ %.2f; qtd: %d; total: R$ %.2f; %s", 
                name, unitPrice, quantity, total, type), balance);
            
            return getOrder(orderId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Map<String, Object> incrementItem(int orderId, int itemCode) {
        try {
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                "UPDATE order_items SET quantity = quantity + 1 WHERE code = ? AND order_id = ?"
            );
            ps.setInt(1, itemCode);
            ps.setInt(2, orderId);
            ps.executeUpdate();
            
            addLog(orderId, "Item incrementado +1", getBalance(orderId));
            return getOrder(orderId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Map<String, Object> decrementItem(int orderId, int itemCode) {
        try {
            Connection conn = Database.getConnection();
            
            // Verifica quantidade atual
            PreparedStatement check = conn.prepareStatement(
                "SELECT quantity, name FROM order_items WHERE code = ? AND order_id = ?"
            );
            check.setInt(1, itemCode);
            check.setInt(2, orderId);
            ResultSet rs = check.executeQuery();
            
            if (rs.next()) {
                int qty = rs.getInt("quantity");
                String name = rs.getString("name");
                
                if (qty > 1) {
                    PreparedStatement ps = conn.prepareStatement(
                        "UPDATE order_items SET quantity = quantity - 1 WHERE code = ? AND order_id = ?"
                    );
                    ps.setInt(1, itemCode);
                    ps.setInt(2, orderId);
                    ps.executeUpdate();
                } else {
                    PreparedStatement ps = conn.prepareStatement(
                        "DELETE FROM order_items WHERE code = ? AND order_id = ?"
                    );
                    ps.setInt(1, itemCode);
                    ps.setInt(2, orderId);
                    ps.executeUpdate();
                }
                
                addLog(orderId, "Item decrementado -1", getBalance(orderId));
            }
            
            return getOrder(orderId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Map<String, Object> markAsPaid(int orderId, int itemCode) {
        try {
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                "UPDATE order_items SET is_paid = 1 WHERE code = ? AND order_id = ? AND is_paid = 0"
            );
            ps.setInt(1, itemCode);
            ps.setInt(2, orderId);
            ps.executeUpdate();
            
            addLog(orderId, "Item marcado como PAGO", getBalance(orderId));
            return getOrder(orderId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Map<String, Object> removeItem(int orderId, int itemCode) {
        try {
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                "DELETE FROM order_items WHERE code = ? AND order_id = ?"
            );
            ps.setInt(1, itemCode);
            ps.setInt(2, orderId);
            ps.executeUpdate();
            
            addLog(orderId, "Item removido", getBalance(orderId));
            return getOrder(orderId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Map<String, Object> closeOrder(int orderId) {
        try {
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                "UPDATE orders SET is_open = 0 WHERE id = ?"
            );
            ps.setInt(1, orderId);
            ps.executeUpdate();
            
            addLog(orderId, "COMANDA FECHADA", getBalance(orderId));
            return getOrder(orderId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void deleteOrder(int orderId) {
        try {
            Connection conn = Database.getConnection();
            conn.createStatement().execute("DELETE FROM order_logs WHERE order_id = " + orderId);
            conn.createStatement().execute("DELETE FROM order_items WHERE order_id = " + orderId);
            conn.createStatement().execute("DELETE FROM orders WHERE id = " + orderId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private double getBalance(int orderId) {
        Map<String, Object> order = getOrder(orderId);
        if (order != null) {
            return (double) order.get("balance");
        }
        return 0;
    }
    
    private void addLog(int orderId, String description, double balanceAfter) {
        try {
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO order_logs (order_id, description, balance_after) VALUES (?,?,?)"
            );
            ps.setInt(1, orderId);
            ps.setString(2, description);
            ps.setDouble(3, balanceAfter);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
