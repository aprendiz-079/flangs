

/*
sealed timeline:
2020 java 15 preview 1
2021 java 16 previes 2
2021 java lts 17

classe filha de sealed tem que ser:
sealed, non-sealed ou final
*/

public class Main
{
	private static void p(String s)
	{ System.out.print(s); }

	private static sealed class Father permits John, Maria
	{ protected final void father_talk() { p("opa do pai"); } }

 	private static final class John extends Father
	{
		public static final void talk_from_father()
		{ new Father().father_talk(); p(" pelo john\n"); }

		public static final void john_talk() { p("opa do john\n"); }
	}

	private static non-sealed class Maria extends Father
	{//protected inutil aqui ksksksk
		protected static final void talk_from_father()
		{ new Father().father_talk(); p(" pela maria\n"); }

		protected static final void fathers_talk() { new Father().father_talk(); }

		private void maria_talk() { p("opa da maria\n"); }
	}

	private static final class Stranger extends Maria
	{
		public static final void stranger_talk_from_father()
		{ fathers_talk(); p(" pelo estranho\n"); }

		public static final void _maria_talk()
		{ new Maria().maria_talk(); }

//		@Override
		public final void maria_talk()
		{ p("opa. metodo sobrescrito !\n"); }
	}

	public static void main(String[] argv)
	{
		new Father().father_talk();
		p("\n\n");
		John.talk_from_father();
		p("\n\n");
		John.john_talk();

/*
		Maria.talk_from_father(); //err
		Maria.maria_talk();       //err
*/
		p("\n\n");
		new Stranger().maria_talk();
		Stranger._maria_talk();
		p("\n\n");
		Stranger.stranger_talk_from_father();
	}
}
