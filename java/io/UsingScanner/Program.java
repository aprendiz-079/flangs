

import java.util.Scanner;


public class Program
{
	protected static class Output
	{
		public Output()
		{ print("Aoba, esta eh uma impresao de uma linha na saida padrao\n"); }

		protected static void print(String s)
		{ System.out.print(s); }
	}

//	pprivate class Input
	protected static class Input
	{
		private Scanner sc = new Scanner(System.in);

		protected char readFirstChar()
		{
			char re =sc.next().charAt(0);
			sc.close();
			return re;
		}

		protected String readLine(String txt)
		{
			Output.print(txt);
			String re = new String(sc.nextLine());
			sc.close();
			return re;
		}

		protected double readDouble()
		{
			double re = sc.nextDouble();
			sc.close();
			return re;
		}
	}


	public static void main(String[] argv)
	{
		String s = new Input().readLine(">");
		Output.print(s + "\n");

/*
		// se nunguem fosse etatico
		Program pm = new Program();
		Program.Output out = pm.new Output();
		Program.Input in_s = pm.new Input();

		out.printString("Digite algo: ");

		String _string = in_s.readChar();

		out.printString("O primeiro caractere eh: " + _string.charAt(0) + '\n');

//		in_s.sc.close();

		out.printChar(_char);
*/
	}
}
