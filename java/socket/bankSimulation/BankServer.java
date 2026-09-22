

package bankSimulation;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BankServer
{
	public static void main(String[] argv) throws IOException
	{
		final int ACCOUNTS_LENTH = 10;
		Bank bank = new Bank(ACCOUNTS_LENGTH);
		final int SBAP_PORT = 8888;
		ServerSocket server = new ServerSocket(SBAP_PORT);
		System.out.println("Wainting for customers to connect ...");

		while(1)
		{
			Socket s = server.accept();

			BankService service = new BankService(s, bank);
			service.doService();
			s.close();
		}
	}
}
