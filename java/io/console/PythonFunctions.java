

//import java.io.InputStream; // System.in

import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.io.IOException;


public class PythonFunctions
{
	protected static String input(String txt)
	{
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			print(txt);
			String s = reader.readLine();
			reader.close();
			return s;
		}catch(IOException e)
		{ e.printStackTrace(); }
		return "";
	}

	protected static void print(Object o)
	{ System.out.print(o); }

	protected static void print(Object[] o)
	{ System.out.print(o); }

	public static void main(String[] argv)
	{
		String s = input("Type anything: ");
		print("u typed: " + s + "\n");
	}
}
