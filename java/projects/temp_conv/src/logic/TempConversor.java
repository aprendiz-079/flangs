
package temp_conv.src.logic;

public class TempConversor
{
	private String program_name = "[Temperature conversor]";

	private static void puts(String msg)
	{ System.out.println(msg); }

	public static double ftok(double temp)
	{ return ((temp - 32) * (5.0/9.0) + 273.15); }

	public static double ftoc(double temp)
	{ return ((5.0/9.0) * (temp - 32)); }

	public static double ctof(double temp)
	{ return ((temp * 9.0 / 5.0) + 32); }

	public static double ctok(double temp)
	{ return (temp + 273.15); }

	public static double ktof(double temp)
	{ return ((temp - 273.15) * (9.0/5.0) + 32); }

	public static double ktoc(double temp)
	{ return (temp - 273.15); }
	
	public String get_program_name()
	{ return program_name; }

	private void print_menu()
	{
		puts("Enter the number of the option:\n");
		puts("f = fahrenheit;\nc = celcius;\nk = kelvin;");
		puts("1. ftok;\n2. ftoc;\n3. ctok;\n4. ctof;\n5. ktof;\n6. ktoc;\n");
	}

	private void print_usage()
	{
		puts("Help:");
		puts("<sign-temp>to<sign-temp_to_conv> <temp(decimal)>\n\nf = fahrenheit;\nc = celcius;\nk = kelvin;\n");
		puts("ex:\nftok 123.45 -> 123.45fahrenheit = 323.955...kelvin\n");
	}
}

/*
puts("Usage: convert -temp ftoc <fahr_temp>");
puts("                     ftok <fahr_temp>");
puts("                     ctof <cels_temp>");
puts("                     ctok <cels_temp>");
puts("                     ktoc <kelv_temp>");
puts("                     ktof <kelv_temp>");
*/

/*
	public static void main(String[] argv)
	{
		Scanner sc = new Scanner(System.in);

		TempConversor tc = new TempConversor();

		System.out.print("Enter the temperature: "); tc.temp = sc.nextDouble();

		System.out.println("Valor digitado: " + tc.temp + '\n');

		tc.print_menu(); char op = sc.next().charAt(0);
		switch (op)
		{
			case '1': System.out.println(tc.ftok()); break;
			case '2': System.out.println(tc.ftoc()); break;
			case '3': System.out.println(tc.ctok()); break;
			case '4': System.out.println(tc.ctof()); break;
			case '5': System.out.println(tc.ktof()); break;
			case '6': System.out.println(tc.ktoc()); break;
		}

		sc.close();
//		puts("1. ftok;\n2. ftoc;\n3. ctok;\n4. ctof;\n5. ktof;\n6. ktoc;\n");
	}

*/
