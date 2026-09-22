

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main
{
	private final Object lock = new Object();
	private volatile String option = null;  //option goes on ram
	private volatile boolean running = true;//running goes on ram too
	private int count = 0;

	public static void init()
	{
		Thread ui = new Thread(() ->
		{
			while(running)
			{
				synchronized (lock)
				{
					IO.println("\033[H\033[2J");// asi code to clear the display
					System.out.flush();
					IO.println("==== MENU ====");
					IO.println("Count: " + count++);
					IO.println("Enter q to exit;");
					IO.print("> ");
				}
				try
				{ Thread.sleep(500); }
				catch(InterruptedException e)
				{ Thread.currentThread().interrupt(); }
			}
		});

		Thread input = new Thread(() ->
		{
			try(BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in)))
			{
				while(running)
				{
					String line;
					synchronized(lock) { line = br.readLine(); }

					if (line != null)
					{
						if (line.equalsIgnoreCase("q")) running = false;

						option = line;
						IO.println("U insert: " + line);
					}
				}
			} catch(IOException e)
			{ e.printStackTrace(); }
		});

		ui.setDaemon(true);
		ui.start();
		input.start();

		try
		{ input.join(); }
		catch (InterruptedException e)
		{ Thread.currentThread().interrupt(); }

		IO.println("Exited.");
	}

	public static void main(String[] argv)
	{ init(); }
}
