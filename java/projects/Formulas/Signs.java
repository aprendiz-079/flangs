

package Formulas;

public class Signs
{ { System.out.println("Signs initialized !"); }

	public static double factorial(double n)
	{
		if (n < 0)
		{ throw new IllegalArgumentException("n < 0"); }
		else if (n == 0 || n == 1) { return 1; }
		else
		{
			double result = 1;
			for (int i = 1; i <= n; i++)
			{ result *= i; }
			return result;
		}
	}
}

