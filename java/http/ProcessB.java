
/*
	ProcessB.java
*/


import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.*;

public class ProcessB
{
	public static void main(String[] argv)
	{
		// 1. SERVER: B escuta na porta 8081
		HttpServer server = HttpServer.create(new InetSocketAddress(8081), 0);

		server.createContext("/msg", new HttpHandler()
		{
			@Override
			public void handle(HttpExchange he) throws IOException
			{
				String reqBody = new String(he.getRequestBody().readAllBytes());
				System.out.println("A: " + reqBody);

				String response = "Oi S, aqui eh B. Mensagem recebida!";
				he.sendResponseHeaders(200, response.length());
				he.getResponseBody().write(response.getBytes());
				he.close();
			}
		});

		server.start();
		System.out.println("Processo B rodando na porta 8081.");

		// 2. CLIENT: B manda msg pra A na porta 8081
		Thead.sleep(2000); // espera A subir

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create("http://localhost:8080/msg"))
			.POST(HttpRequest.BodyPublishers.ofString("Oi A, aqui eh o B"))
			.header("Content-Type", "text/plain")
			.build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println("B recebeu resposta de A: " + response.body());
	}
}
