

import java.io.Console;


public class Main
{
	private static void println(Object s)
	{ System.out.println(s); }

	private static void print(Object s)
	{ System.out.print(s); }

	public static void main(String[] argv)
	{
		char[] chars = { 'o','p','a','.',' ','b','o','m',' ','d','i','a' };

		String s = new String(chars);
		println(s);

//		s = new String(chars, 2, 3);
//		println(s);
		println((char)200);
		Console console = System.console();

		if(console != null)
		{
			char[] pass = console.readPassword("Enter your password: ");
			console.printf("the password lenght is: " + pass.length + "\n");
		}
	}
}
