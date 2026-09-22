

import com.sun.net.httpserver.*;
import java.sql.*;
import java.util.UUID;

class LoginHandler implements HttpHandler {
    Connection conn = DriverManager.getConnection("jdbc:sqlite:banco.db");

    @Override
    public void handle(HttpExchange ex) throws IOException {
        if("POST".equals(ex.getRequestMethod())) {
            String body = new String(ex.getRequestBody().readAllBytes());
            // body = {"login":"admin","senha":"123"}
            
            JSONObject json = new JSONObject(body); // usa org.json ou Gson
            String login = json.getString("login");
            String senha = json.getString("senha");
            
            // 1. Confere no banco
            PreparedStatement ps = conn.prepareStatement(
                "SELECT id FROM usuarios WHERE login=? AND senha=?"
            );
            ps.setString(1, login);
            ps.setString(2, senha); // Ideal: usar hash MD5/SHA256
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                // 2. Login OK: cria token de sessão
                int userId = rs.getInt("id");
                String token = UUID.randomUUID().toString();
                
                conn.prepareStatement(
                    "INSERT INTO sessoes(token, usuario_id) VALUES(?,?)"
                ).executeUpdate();
                
                // 3. Devolve token pro JS
                String resp = "{\"ok\":true,\"token\":\"" + token + "\"}";
                ex.sendResponseHeaders(200, resp.length());
                ex.getResponseBody().write(resp.getBytes());
            } else {
                // Login falhou
                String resp = "{\"ok\":false}";
                ex.sendResponseHeaders(401, resp.length());
                ex.getResponseBody().write(resp.getBytes());
            }
            ex.close();
        }
    }
}
