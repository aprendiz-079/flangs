

import static java.util.Arrays.fill;
import static java.util.Arrays.sort;


public class Main
{
	private static void pln(String s)
	{ System.out.println(s); }

	private static void p(String s)
	{ System.out.print(s); }

	private static void using_fill()
	{
		int[] a = new int[]{1, 4, 3, 2, 5};

		fill(a, 0);
		for(int n : a)
		{ pln(String.valueOf(n)); }
	}

	private static void using_sort()
	{
		int[] a = new int[]{3, 4, 1, 2, 9, 5, 6, 7};

		for(int n : a)
		{ p(String.valueOf(n) + " "); }
		p("\n");

		sort(a);

		for(int n : a)
		{ p(String.valueOf(n) + " "); }
		p("\n");
	}

	public static void main(String[] argv)
	{
//		using_fill();
		using_sort();
	}
}
