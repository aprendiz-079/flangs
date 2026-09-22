

public class Main
{
	String s;

	Main(String s)
	{	this.s = s; }

/*
	private void println()
	{ System.out.println(this); }
	//erro: pega o metodo toString() de String,
	// que retorna getClass().getName() + "@" + Integer.toHaxSring(hashcode());
	// solucao:
	// sobreescrever o metodo toString
*/

	@Override
	public String toString()
	{ return s; }

	private void println()
	{ System.out.println(this); }

	public static void main(String[] argv)
	{
		Main s = new Main("opa");
		s.println();
	}
}

