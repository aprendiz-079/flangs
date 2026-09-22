

// -ea: enable assertions
// -da: disable assertions

// -ea:com.myproject

public class Main
{
	public static void main(String[] argv)
	{
		int a = 12;
		int b = 0;

		assert a == b : "A nao eh igual a b";
	}
}
