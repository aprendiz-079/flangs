
/*
	ProccessA
*/


import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.*;

public class ProcessA
{
	private int source_port = 8080;
	private int destine_port = 8081;
	private String destine_addr = "http://localhost:" + destine_port;
	private String source_addr = "http://localhost:" + source_port;

	private void run_server()
	{
		HttpServer server = HttpServer.create(new InetSocketAddress(source_port), 0);
		server.createContext("/msg", new HttpHandler()
		{
			@Override
			public void handle(HttpExchange he) throws IOException
			{
				String reqBody = new String(he.getRequestBody().readAllBytes());
				System.out.println("B: " + reqBody);

				String response = "Sucess.";
				he.sendResponseHeaders(200, response.length());
				he.getResponseBody().write(response.getBytes());
				he.close();
			}
		});

		server.start();
		System.out.println("Processo A rodando na porta 8080.");
	}

	public void send_req(String msg, String addr)
	{
//		if ()
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create())
			.POST(HttpRequest.BodyPublishers.ofString("Oi B, aqui eh o A"))
			.header("Content-Type", "text/plain")
			.build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println("B: " + response.body());
	}

	public static void main(String[] argv)
	{
		new ProcessA().run_server();
	}
}
