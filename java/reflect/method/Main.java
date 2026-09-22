

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;


public class Main
{
	public static void main(String[] argv)
	{
		Person p = new Person();

		try
		{
		Method m = Person.class.getDeclaredMethod("get_cpf");
		m.setAccessible(true);

		String cpf = (String) m.invoke(p);
		System.out.println(cpf);
		}
		catch(NoSuchMethodException nsme)
		{}
		catch(IllegalAccessException iae)
		{}
		catch(InvocationTargetException ite)
		{}
	}
}


class Person
{
	private String cpf = "091-123-1232-09";

	private String get_cpf()
	{ return cpf; }
}
