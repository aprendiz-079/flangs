

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*
Burlando a classe Void ksksks
rodar com java --add-opens java.base/java.lang=ALL-UNNAMED
*/

public class Main
{
	public static void main(String []argv)
	{
		try
		{
			Constructor<Void> c = void.class.getDeclaredConstructor();
			c.setAccessible(true);
			Void v = c.newInstance();
		}
		catch(NoSuchMethodException nsme)
		{}
		catch(InstantiationException ie)
		{}
		catch(IllegalAccessException iae)
		{}
		catch(InvocationTargetException ite)
		{}
	}
}
