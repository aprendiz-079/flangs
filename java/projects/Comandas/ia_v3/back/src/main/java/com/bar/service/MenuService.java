package com.bar.service;

import com.bar.Database;
import java.sql.*;
import java.util.*;

public class MenuService {
    
    public Map<String, Object> getOrganizedMenu() {
        Map<String, Map<String, Map<String, List<Map<String, Object>>>>> result = new LinkedHashMap<>();
        List<String> categoryOrder = Arrays.asList("Bebidas", "Comestíveis", "Limpeza");
        
        try {
            Connection conn = Database.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM menu ORDER BY code");
            
            while (rs.next()) {
                String cat = rs.getString("category");
                String sub = rs.getString("subcategory");
                String subsub = rs.getString("sub_subcategory");
                
                Map<String, Object> item = new LinkedHashMap<>();
                item.put("id", rs.getString("id"));
                item.put("code", rs.getString("code"));
                item.put("name", rs.getString("name"));
                item.put("price", rs.getDouble("price"));
                item.put("category", cat);
                item.put("subcategory", sub);
                item.put("subSubcategory", subsub);
                
                result.putIfAbsent(cat, new LinkedHashMap<>());
                result.get(cat).putIfAbsent(sub, new LinkedHashMap<>());
                result.get(cat).get(sub).putIfAbsent(subsub, new ArrayList<>());
                result.get(cat).get(sub).get(subsub).add(item);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        // Ordenar categorias
        Map<String, Object> sorted = new LinkedHashMap<>();
        for (String cat : categoryOrder) {
            if (result.containsKey(cat)) {
                sorted.put(cat, result.get(cat));
            }
        }
        for (String cat : result.keySet()) {
            if (!sorted.containsKey(cat)) {
                sorted.put(cat, result.get(cat));
            }
        }
        
        return sorted;
    }
    
    public Map<String, Object> getItemById(String id) {
        try {
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM menu WHERE id = ?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                Map<String, Object> item = new LinkedHashMap<>();
                item.put("id", rs.getString("id"));
                item.put("code", rs.getString("code"));
                item.put("name", rs.getString("name"));
                item.put("price", rs.getDouble("price"));
                item.put("category", rs.getString("category"));
                item.put("subcategory", rs.getString("subcategory"));
                item.put("subSubcategory", rs.getString("sub_subcategory"));
                return item;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Map<String, Object> getItemByCode(String code) {
        try {
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM menu WHERE code = ?");
            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                Map<String, Object> item = new LinkedHashMap<>();
                item.put("id", rs.getString("id"));
                item.put("code", rs.getString("code"));
                item.put("name", rs.getString("name"));
                item.put("price", rs.getDouble("price"));
                item.put("category", rs.getString("category"));
                item.put("subcategory", rs.getString("subcategory"));
                item.put("subSubcategory", rs.getString("sub_subcategory"));
                return item;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
