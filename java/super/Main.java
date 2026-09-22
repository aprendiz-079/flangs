

public class Main
{
	private static void run()
	{ new Soon(); }

	private static class Father
	{
		private static void talk()
		{ System.out.println("opa"); }
	}

	private static class Soon extends Father
	{ protected Soon() { super.talk(); } }

	public static void main(String[] argv)
	{ run(); }
}
