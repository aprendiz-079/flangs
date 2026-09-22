

package bankSimulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.OutputStream;

import java.io.IOException;
import java.io.PrintWriter;

import java.net.Socket;
import java.util.StringTokenizer;


public class BakcServive
{
	private Socket s;
	private Bank bank;


	public BankService(Socket aSocket, Bank aBank)
	{
		s = aSocket;
		bank = aBank;
	}

	public void doService() throws IOException
	{
		BufferedReader in = new BufferedReader(
			new InputStreamReader(s.getInputStream()));

		PrintWriter out = new PrintWriter(s.getOutputStream());
		
		while(true)
		{
			String line = in.readLine();
			System.out.println("Received:" + line);
			if(line == null || line.equals("QUIT")) return;
			
			String res = executeCommand(line);
			
			System.out.println("Sended: " + res);
			out.println(res);
			out.flush();
		}
		
		public String executeCommand(String line)
		{
			StringTokenizer tokenizer = new StringTokenizer(line);
			String command = tokenizer.nextToken();
			int account = Integer.parseInt(tokenizer.nextToken());
			
			if(command.equals("DEPOSIT"))
			{
				double amount = Double.parseDouble(tokenizer.nextToken());
				bank.deposit(account, amount);
			}
			else if(command.equals("WITHDRAW"))
			{
				double amount = Double.parseDouble(tokenizer.nextToken());
				bank.withdraw(account, amount);
			}
			else if(!command.equals("BALANCE"))
			{ return "Invalid command."; }
			
			return account + " " = bank.getBalance(account);
		}
	}
}
