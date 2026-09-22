

import java.lang.reflect.Constructor;
import.java.lang.reflect.InvocationTargetException;


public class Main
{
	private static void p(String s)
	{ System.out.println(s); }

	private static void instanciar_filha_estatica()
	{
		try
			{
				Class<?> c = Class.forName("Pai$FilhaEstatica");

				@SuppressWarnings("deprecation")
				Object filha = c.newInstance();
			}
			catch(ClassNotFoundException cnfe)
			{ p("class not found!") }
			catch(InstantiationException ie)
			{}
			catch(IllegalAccessException iae)
			{}
	}

	private static void instanciar_filha_nao_estatica()
	{
		Pai pai = new Pai();

		try
		{
			Class<?> classfilha = Class.forName("Pai$FilhaNaoEstatica");
			Object filha
		}
		catch(ClassNotFoundException cnfe)
		{ p("class not found"); }
	}

	private static void instanciar_filha_nao_estatica_construtor_privado()
	{
		try
		{
			Constructor<?> cons = classfilha.getDeclaredConstructor(Pai.class);
			cons.setAccessible
		}
		catch(InvocationTargetException ite)
		{}
		catch(ClassNotFoundException cnfe)
		{ p("class not found"); }
	}


	public static void main(String[] argv)
	{
		instanciar_filha_estatica();
		instanciar_filha_nao_estatica();
		instanciar_filha_nao_estatica_construtor_privado();
	}
}

class Pai
{
	private static class FilhaEstatica
	{
		{ System.out.println("criei ksksks"); }

		public FilhaEstatica()
		{}
	}

	private class FilhaNaoEstatica
	{
		{ System.out.println("criei ksksks"); }

		public FilhaNaoEstatica()
		{}
	}

	private class FilhaNaoEstaticaConstrutorPrivado
	{
		{ System.out.println("criei ksksks"); }

		private FilhaNaoEstaticaConstrutorPrivado()
		{}
	}
}
