

import java.util.List;
import java.util.ArrayList;

public class Main
{
	private static void a()
	{
		List<? extends Number> numbers = new ArrayList<Integer>(3, 2, 1);
		Number n = numbers.get(0);
//		numbers.add(1);
	}

	public static void main(String[] argv)
	{
		a();
	}
}
