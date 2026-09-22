

package Formulas;

//import Signs;

/*
  n! / [k! * (n - k)!]
*/

public class BinominalCoeficient
{
	{ System.out.println("Binominal Coeficient intialized !"); }

	public static void usage
	{ System.out.println("Binominal Coeficient:\n  n! / [k! * (n - k)!]\n"); }

	private static double n, k;

	public BinominalCoeficient(double _n, double _k)
	{ n = _n; k = _k;
		return 
		( Signs.factorial(n) / (Signs.factorial(k) * Signs.factorial(n - k)) );
	}
}
