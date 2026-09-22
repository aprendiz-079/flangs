

public class Exercise0904
{
	private static javax.swing.JOptionPane jop = new javax.swing.JOptionPane();
	private static java.util.Random random = new java.util.Random();

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

	private static String generatePassword(int len)
	{
		char[] alph = my_strip(
		"a b c d e f g h i j k l m n o p q r s t u v w x y z").toCharArray();

		String ret = new String("");

		for(int i=1; i<=len; i++)
		{ ret += alph[random.nextInt(alph.length - 1)]; }
		return ret;
	}

	private static String[][] getCandidates()
	{
		//get candidates quantity
		String s = new String("");
		int tentatives = 0;
		while(tentatives <= 3)
		{
			s = jop.showInputDialog(null,"Number of candidates");

			if(s.isEmpty()) jop.showMessageDialog(null,
			"The number of candidates is obrigatorio kraio. Try again." + 
			String.valueOf(tentatives));
			else break;

			tentatives++;
		}
		int candidates_qtt = Integer.parseInt(s);
		if(candidates_qtt < 1) return new String[0][0];
		///

		s = "";
		tentatives = 0;
		String[][] candidates = new String[candidates_qtt][2];
		for(int i=0; i<candidates_qtt; i++)
		{
			//get candidate name
			while(tentatives <= 3)
			{
				s = jop.showInputDialog(null,"Candidate " + String.valueOf(i+1));

				if(s.isEmpty()) jop.showMessageDialog(null,
				"The candidate name cannot be void, kraio." + 
				" Still missing " + String.valueOf(candidates_qtt - i) + " candidates to appoint." + 
				" Tentatives: ." + String.valueOf(tentatives));
				else break;
			}
			if(candidate)
			candidates[i][0] = s;
			//

			//get an password to him
			candidates[i][1] = " - " + generatePassword(8);
			//
		}
		return candidates;
	}

	private static void println(String msg) { System.out.println(msg); }

	private static void print_candidate_table(String[][] table)
	{
		println("Candidates list:\nNo. Name - Password\n");


		for(int i=0; i<table.length/2; i++)
		{ println(String.valueOf(i+1) + table[i][i]); }
	}

	public static void main(String argv[])
	{
		String[][] candidates = getCandidates();
		print_candidate_table(candidates);

		System.exit(0);
	}
}
