package com.bar;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private static final String DB_URL = "jdbc:sqlite:comanda.db";
    private static Connection connection;
    
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(DB_URL);
        }
        return connection;
    }
    
    public static void initialize() {
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            
            // Tabela de comandas
            stmt.execute("""
                CREATE TABLE IF NOT EXISTS orders (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    client_name TEXT NOT NULL,
                    is_open INTEGER DEFAULT 1,
                    created_at TEXT DEFAULT (datetime('now','localtime'))
                )
            """);
            
            // Tabela de itens
            stmt.execute("""
                CREATE TABLE IF NOT EXISTS order_items (
                    code INTEGER PRIMARY KEY AUTOINCREMENT,
                    order_id INTEGER NOT NULL,
                    name TEXT NOT NULL,
                    quantity INTEGER DEFAULT 1,
                    unit_price REAL NOT NULL,
                    is_paid INTEGER DEFAULT 0,
                    created_at TEXT DEFAULT (datetime('now','localtime')),
                    FOREIGN KEY (order_id) REFERENCES orders(id)
                )
            """);
            
            // Tabela de logs
            stmt.execute("""
                CREATE TABLE IF NOT EXISTS order_logs (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    order_id INTEGER NOT NULL,
                    description TEXT NOT NULL,
                    balance_after REAL NOT NULL,
                    created_at TEXT DEFAULT (datetime('now','localtime')),
                    FOREIGN KEY (order_id) REFERENCES orders(id)
                )
            """);
            
            // Tabela do cardápio
            stmt.execute("""
                CREATE TABLE IF NOT EXISTS menu (
                    id TEXT PRIMARY KEY,
                    code TEXT UNIQUE NOT NULL,
                    name TEXT NOT NULL,
                    price REAL NOT NULL,
                    category TEXT NOT NULL,
                    subcategory TEXT NOT NULL,
                    sub_subcategory TEXT NOT NULL
                )
            """);
            
            stmt.close();
            
            // Insere cardápio padrão se vazio
            seedMenu();
            
            System.out.println("✅ Banco de dados inicializado");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private static void seedMenu() {
        try {
            Connection conn = getConnection();
            PreparedStatement check = conn.prepareStatement("SELECT COUNT(*) FROM menu");
            ResultSet rs = check.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) return;
            
            String[][] items = {
                // Bebidas não alcoólicas
                {"100", "Água Mineral", "4.00", "Bebidas", "Não Alcoólicas", "Água"},
                {"101", "Água com Gás", "5.00", "Bebidas", "Não Alcoólicas", "Água"},
                {"102", "Coca-Cola", "8.00", "Bebidas", "Não Alcoólicas", "Refrigerantes"},
                {"103", "Guaraná Antarctica", "7.50", "Bebidas", "Não Alcoólicas", "Refrigerantes"},
                {"104", "Sprite", "7.50", "Bebidas", "Não Alcoólicas", "Refrigerantes"},
                {"105", "Suco de Laranja", "12.00", "Bebidas", "Não Alcoólicas", "Sucos"},
                
                // Cervejas
                {"200", "Heineken Long Neck", "14.00", "Bebidas", "Alcoólicas", "Cervejas"},
                {"201", "Stella Artois Long Neck", "15.00", "Bebidas", "Alcoólicas", "Cervejas"},
                {"202", "Corona Long Neck", "16.00", "Bebidas", "Alcoólicas", "Cervejas"},
                {"203", "Brahma Chopp 300ml", "9.00", "Bebidas", "Alcoólicas", "Cervejas"},
                {"204", "Original 600ml", "18.00", "Bebidas", "Alcoólicas", "Cervejas"},
                {"205", "Antarctica SubZero Lata 269ml", "3.50", "Bebidas", "Alcoólicas", "Cervejas"},
                {"206", "Brahma Chopp Lata 269ml", "3.50", "Bebidas", "Alcoólicas", "Cervejas"},
                
                // Destilados
                {"210", "Absolut Vodka (dose)", "22.00", "Bebidas", "Alcoólicas", "Destilados/Vodka"},
                {"211", "Smirnoff Vodka (dose)", "16.00", "Bebidas", "Alcoólicas", "Destilados/Vodka"},
                {"220", "Johnnie Walker Black (dose)", "30.00", "Bebidas", "Alcoólicas", "Destilados/Whisky"},
                {"221", "Jack Daniels (dose)", "28.00", "Bebidas", "Alcoólicas", "Destilados/Whisky"},
                {"230", "Cachaça Salinas (dose)", "15.00", "Bebidas", "Alcoólicas", "Destilados/Cachaça"},
                
                // Comestíveis
                {"300", "Porção de Batata Frita", "32.00", "Comestíveis", "Entradas", "Frituras"},
                {"301", "Porção de Mandioca Frita", "28.00", "Comestíveis", "Entradas", "Frituras"},
                {"302", "Bolinhos de Bacalhau (6 un)", "42.00", "Comestíveis", "Entradas", "Salgados"},
                {"310", "Filé Mignon à Parmegiana", "68.00", "Comestíveis", "Pratos Principais", "Carnes"},
                {"311", "Picanha Grelhada (200g)", "62.00", "Comestíveis", "Pratos Principais", "Carnes"},
                {"312", "Salmão Grelhado", "72.00", "Comestíveis", "Pratos Principais", "Peixes"},
                {"320", "Petit Gâteau", "28.00", "Comestíveis", "Sobremesas", "Doces"},
            };
            
            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO menu (code, name, price, category, subcategory, sub_subcategory, id) VALUES (?,?,?,?,?,?,?)"
            );
            
            for (int i = 0; i < items.length; i++) {
                String[] item = items[i];
                ps.setString(1, item[0]);
                ps.setString(2, item[1]);
                ps.setDouble(3, Double.parseDouble(item[2]));
                ps.setString(4, item[3]);
                ps.setString(5, item[4]);
                ps.setString(6, item[5]);
                ps.setString(7, "menu-" + (i + 1));
                ps.executeUpdate();
            }
            
            System.out.println("✅ Cardápio padrão inserido");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
