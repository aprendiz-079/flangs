


public class Main
{
	private static void println(String s)
	{ System.out.println(s); }

	public static void main(String[] argv)
	{
		long inicio = System.nanoTime();

		println("env: " + System.getenv("PATH"));

		println("os name: " + System.getProperty("os.name"));

		println("to copy array: " + "System.arraycopy(origem, 0, destino, 0, 5);");
		println("funcao original:\n");
		println("public static native void arraycopy(Object src, int srcPos,)");
		println("                                    Object dest, int destPos,");
		println("                                    int length");

		short i = 0;
	}
}
