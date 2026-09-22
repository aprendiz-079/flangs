

import java.util.Map;
import java.util.LinkedHashMap;


public class Main
{
	public static void main(String[] argv)
	{
		Map<Integer, String> students = new LinkedHashMap<>();
		students.put(0, "a");
		students.put(1, "b");
		students.put(2, "c");

		String[] values = new String[students.size()];

		int i = 0;
		for(Integer k : students.keySet().toArray(new Integer[]{})) values[i++] = students.get(k);

		for(String s : values) System.out.println(s);
	}
}
