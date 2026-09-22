

package bankSimulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.OutputStream;

import java.io.IOException;
import java.io.PrintWriter;

import java.net.Socket;


public class BanckClient
{
	public static void main(String[] argv) throws IOException
	{
		final int SBAP_PORT = 8888;
		Socket s = new Socket("localhost", SBAP_PORT);
		InputStream in = s.getInputStream();
		OutputStream out = s.getOutputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		PrintWriter writer = new PrintWriter(out);

		String command = "DEPOSIT 3 10000\n";
		System.out.println("Sending: " + command);
		writer.print(command);
		writer.flush();
		String res = reader.readLine();
		System.out.println("Received: " + res);

		command = "QUIT\n";
		System.out.println("Sending: " + command);
		writer.print(command);
		writer.flush();

		s.close();
	}
}
