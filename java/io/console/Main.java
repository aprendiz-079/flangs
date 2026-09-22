

import java.io.IOException;

//import java.io.InputStream;// System.in
import java.io.InputStreamReader;

import java.io.BufferedReader;


public class Main
{
	public static void main(String[] argv)
	{ new FromKeyboard(); }
}

class FromKeyboard
{
	FromKeyboard()
	{ start(); }

	private void start()
	{
		String name = "";
		System.out.print("Enter ur name:  ");

		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			name = reader.readLine();
		}
		catch (IOException e)
		{ e.printStackTrace(); }

		System.out.println("Welcome, " + name);
	}
}
