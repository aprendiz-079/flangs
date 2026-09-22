

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;


public class Main
{
	public static void main(String[] argv)
	{
		Person p = new Person();

		p.print_cpf();
		try
		{
			Field f = Person.class.getDeclaredField("cpf");
			//f.trySetAcceddible();
			f.setAccessible(true);
			f.set(p, "000-000-0000-00");
		}
		catch(NoSuchFieldException nefe)
		{}
//		catch(InvocationTargetException ite)
//		{}
		catch(IllegalAccessException iae)
		{}
		p.print_cpf();
	}
}

class Person
{
	private String cpf = "093-233-2333-11";

	public void print_cpf()
	{ System.out.println(cpf); }
}
