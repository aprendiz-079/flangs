

import java.io.IOException;

public class Main
{
	private static void println(String s)
	{ System.out.println(s); }

	public static void main(String[] argv)
	{
		Runtime rt = Runtime.getRuntime();

		println("Nucleos disponiveis: ");
		System.out.println(rt.availableProcessors());

		println("Memoria disponivel");
		System.out.println(rt.freeMemory());

		println("Rodando xterm");
		try
		{
//			@SuppressWarnings("deprecation")
			rt.exec("xterm");
		}catch(IOException e){}
	}
}
