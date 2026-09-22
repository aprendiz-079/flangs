

public class Main
{
	private static void func(String[] words)
	{
		// passagem por referencia
		words[0] = "";
	}

	public static void main(String[] argv)
	{
		// String[] a = new String[size];
		// String []a = { ... };
		// String[] a = new String[]{ ... };


		String[] a = { "opa", "bom", "dia" }; // definition

		// passing arrays to functions
//		func(a); // normal mode

		func(new String[]{ "opa", "bom", "dia" }); // anonymous array

		//passagem por referencia:
		func(a);

		System.out.println(a[0] + a[1]);
	}
}
