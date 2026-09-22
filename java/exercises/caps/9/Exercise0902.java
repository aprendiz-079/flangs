

public class Exercise0902
{
	private static javax.swing.JOptionPane jop = new javax.swing.JOptionPane();
	private static java.util.Random random = new java.util.Random();

	private static String[] getNames(int qtt)
	{
		int i;
		String names[] = new String[qtt];
		for(i=1; i<=qtt; i++)
		{
			names[i-1] = jop.showInputDialog(null,"Name of " + String.valueOf(i) + " person");
//			System.out.println(names[i-1]);
		}
		return names;
	}

	private static String getSortedName(String[] names)
	{ return names[random.nextInt(names.length - 1)]; }

	public static void main(String argv[])
	{ jop.showMessageDialog( null,getSortedName(getNames(5)) ); }
}
