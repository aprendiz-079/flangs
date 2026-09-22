

public class Main
{
	private static String my_strip(String s)
	{
		String ret = new String("");
		for(int i=0; i<s.length(); i++)
		{
			if(s.charAt(i)==' ') continue;
			ret += s.charAt(i);
		}
		return ret;
	}
	public static void main(String[] argv)
	{
		String s = new String("a b c d e f g h i j k l m n o p q r s t u v w x y z");
		IO.println(my_strip(s));
/*
		int i = 0;
		for(char ch : alphabet)
		IO.println("char[" + String.valueOf(i++) + "] = " + String.valueOf(ch));
		*/
	}
}
