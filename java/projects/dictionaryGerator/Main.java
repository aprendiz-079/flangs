




public class DictionaryGenerator
{
	private String[] words;

	Main(String[] words)
	{ this.words = words; }

	public void puts(String msg)
	{ System.out.println(msg); }

	public void usage()
	{
		StringBuilder s = new StringBuilder();
		s.append("Usage: DictionaryGenerator <word01> <word02> <word03> <word(n)>");

		puts(s);
	}

	public static void main(String[] argv)
	{
		
	}
}
