package com.bar;

import com.bar.service.OrderService;
import com.bar.service.MenuService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.net.InetSocketAddress;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

public class Main {
    private static OrderService orderService = new OrderService();
    private static MenuService menuService = new MenuService();
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    public static void main(String[] args) throws IOException {
        Database.initialize();
        
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        
        // API REST
        server.createContext("/api/orders", new OrdersHandler());
        server.createContext("/api/menu", new MenuHandler());
        
        // Arquivos estáticos (frontend)
        server.createContext("/", new StaticFileHandler());
        
        server.setExecutor(null);
        System.out.println("🚀 Servidor rodando em http://localhost:8080");
        server.start();
    }
    
    // Handler para arquivos estáticos
    static class StaticFileHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String path = exchange.getRequestURI().getPath();
            
            // Redireciona raiz para index.html
            if ("/".equals(path)) path = "/index.html";
            
            // Remove barra inicial
            if (path.startsWith("/")) path = path.substring(1);
            
            // Adiciona prefixo do frontend
            Path filePath = Paths.get("../frontend", path);
            
            if (Files.exists(filePath) && !Files.isDirectory(filePath)) {
                String contentType = getContentType(path);
                exchange.getResponseHeaders().set("Content-Type", contentType);
                byte[] fileBytes = Files.readAllBytes(filePath);
                exchange.sendResponseHeaders(200, fileBytes.length);
                OutputStream os = exchange.getResponseBody();
                os.write(fileBytes);
                os.close();
            } else {
                // 404
                String response = "404 Not Found";
                exchange.sendResponseHeaders(404, response.length());
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        }
        
        private String getContentType(String path) {
            if (path.endsWith(".html")) return "text/html; charset=UTF-8";
            if (path.endsWith(".css")) return "text/css";
            if (path.endsWith(".js")) return "application/javascript";
            if (path.endsWith(".json")) return "application/json";
            if (path.endsWith(".png")) return "image/png";
            return "text/plain";
        }
    }
    
    // Handler da API de pedidos
    static class OrdersHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            // Configura CORS
            exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
            exchange.getResponseHeaders().set("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
            exchange.getResponseHeaders().set("Access-Control-Allow-Headers", "Content-Type");
            
            if ("OPTIONS".equals(exchange.getRequestMethod())) {
                exchange.sendResponseHeaders(204, -1);
                return;
            }
            
            String path = exchange.getRequestURI().getPath();
            String method = exchange.getRequestMethod();
            
            try {
                // GET /api/orders - Lista todas
                if (path.equals("/api/orders") && "GET".equals(method)) {
                    List<Map<String, Object>> orders = orderService.listOrders();
                    sendJson(exchange, 200, orders);
                    return;
                }
                
                // POST /api/orders - Cria comanda
                if (path.equals("/api/orders") && "POST".equals(method)) {
                    Map<String, Object> body = readJson(exchange);
                    String clientName = (String) body.get("clientName");
                    Map<String, Object> order = orderService.createOrder(clientName);
                    sendJson(exchange, 201, order);
                    return;
                }
                
                // GET /api/orders/{id} - Detalhes
                if (path.matches("/api/orders/\\d+$") && "GET".equals(method)) {
                    int orderId = extractId(path);
                    Map<String, Object> order = orderService.getOrder(orderId);
                    if (order != null) {
                        sendJson(exchange, 200, order);
                    } else {
                        sendJson(exchange, 404, Map.of("error", "Comanda não encontrada"));
                    }
                    return;
                }
                
                // DELETE /api/orders/{id} - Remove
                if (path.matches("/api/orders/\\d+$") && "DELETE".equals(method)) {
                    int orderId = extractId(path);
                    orderService.deleteOrder(orderId);
                    sendJson(exchange, 200, Map.of("success", true));
                    return;
                }
                
                // POST /api/orders/{id}/close - Fechar
                if (path.matches("/api/orders/\\d+/close$") && "POST".equals(method)) {
                    int orderId = extractId(path);
                    Map<String, Object> order = orderService.closeOrder(orderId);
                    sendJson(exchange, 200, order);
                    return;
                }
                
                // POST /api/orders/{id}/items - Adicionar item
                if (path.matches("/api/orders/\\d+/items$") && "POST".equals(method)) {
                    int orderId = extractId(path);
                    Map<String, Object> body = readJson(exchange);
                    String name = (String) body.get("name");
                    int qty = ((Number) body.get("quantity")).intValue();
                    double price = ((Number) body.get("unitPrice")).doubleValue();
                    boolean paid = body.get("paid") != null && (Boolean) body.get("paid");
                    
                    Map<String, Object> order = orderService.addItem(orderId, name, qty, price, paid);
                    sendJson(exchange, 200, order);
                    return;
                }
                
                // POST /api/orders/{id}/items/{code}/increment
                if (path.matches("/api/orders/\\d+/items/\\d+/increment$")) {
                    String[] parts = path.split("/");
                    int orderId = Integer.parseInt(parts[3]);
                    int itemCode = Integer.parseInt(parts[5]);
                    Map<String, Object> order = orderService.incrementItem(orderId, itemCode);
                    sendJson(exchange, 200, order);
                    return;
                }
                
                // POST /api/orders/{id}/items/{code}/decrement
                if (path.matches("/api/orders/\\d+/items/\\d+/decrement$")) {
                    String[] parts = path.split("/");
                    int orderId = Integer.parseInt(parts[3]);
                    int itemCode = Integer.parseInt(parts[5]);
                    Map<String, Object> order = orderService.decrementItem(orderId, itemCode);
                    sendJson(exchange, 200, order);
                    return;
                }
                
                // POST /api/orders/{id}/items/{code}/pay
                if (path.matches("/api/orders/\\d+/items/\\d+/pay$")) {
                    String[] parts = path.split("/");
                    int orderId = Integer.parseInt(parts[3]);
                    int itemCode = Integer.parseInt(parts[5]);
                    Map<String, Object> order = orderService.markAsPaid(orderId, itemCode);
                    sendJson(exchange, 200, order);
                    return;
                }
                
                // DELETE /api/orders/{id}/items/{code}
                if (path.matches("/api/orders/\\d+/items/\\d+$") && "DELETE".equals(method)) {
                    String[] parts = path.split("/");
                    int orderId = Integer.parseInt(parts[3]);
                    int itemCode = Integer.parseInt(parts[5]);
                    Map<String, Object> order = orderService.removeItem(orderId, itemCode);
                    sendJson(exchange, 200, order);
                    return;
                }
                
                sendJson(exchange, 404, Map.of("error", "Rota não encontrada"));
                
            } catch (Exception e) {
                e.printStackTrace();
                sendJson(exchange, 500, Map.of("error", e.getMessage()));
            }
        }
        
        private int extractId(String path) {
            String[] parts = path.split("/");
            return Integer.parseInt(parts[3]);
        }
    }
    
    // Handler da API do cardápio
    static class MenuHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
            exchange.getResponseHeaders().set("Access-Control-Allow-Methods", "GET, OPTIONS");
            exchange.getResponseHeaders().set("Access-Control-Allow-Headers", "Content-Type");
            
            if ("OPTIONS".equals(exchange.getRequestMethod())) {
                exchange.sendResponseHeaders(204, -1);
                return;
            }
            
            String path = exchange.getRequestURI().getPath();
            
            try {
                // GET /api/menu - Cardápio organizado
                if (path.equals("/api/menu") && "GET".equals(exchange.getRequestMethod())) {
                    Map<String, Object> menu = menuService.getOrganizedMenu();
                    sendJson(exchange, 200, menu);
                    return;
                }
                
                // GET /api/menu/{id} - Item por ID
                if (path.matches("/api/menu/[^/]+$")) {
                    String itemId = path.substring("/api/menu/".length());
                    Map<String, Object> item = menuService.getItemById(itemId);
                    if (item != null) {
                        sendJson(exchange, 200, item);
                    } else {
                        sendJson(exchange, 404, Map.of("error", "Item não encontrado"));
                    }
                    return;
                }
                
                // GET /api/menu/code/{code} - Item por código
                if (path.matches("/api/menu/code/\\d+$")) {
                    String code = path.substring("/api/menu/code/".length());
                    Map<String, Object> item = menuService.getItemByCode(code);
                    if (item != null) {
                        sendJson(exchange, 200, item);
                    } else {
                        sendJson(exchange, 404, Map.of("error", "Código não encontrado"));
                    }
                    return;
                }
                
                sendJson(exchange, 404, Map.of("error", "Rota não encontrada"));
                
            } catch (Exception e) {
                e.printStackTrace();
                sendJson(exchange, 500, Map.of("error", e.getMessage()));
            }
        }
    }
    
    // Utilitários
    private static void sendJson(HttpExchange exchange, int status, Object data) throws IOException {
        String json = gson.toJson(data);
        exchange.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
        byte[] response = json.getBytes(StandardCharsets.UTF_8);
        exchange.sendResponseHeaders(status, response.length);
        OutputStream os = exchange.getResponseBody();
        os.write(response);
        os.close();
    }
    
    private static Map<String, Object> readJson(HttpExchange exchange) throws IOException {
        InputStreamReader isr = new InputStreamReader(exchange.getRequestBody(), StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);
        StringBuilder body = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            body.append(line);
        }
        return gson.fromJson(body.toString(), Map.class);
    }
}
