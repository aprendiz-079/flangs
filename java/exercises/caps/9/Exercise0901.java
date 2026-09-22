

//public class Exercice0901 extends javax.swing.JOptionPane, java.util.Random
//Exercice0901 extends 
//sub3                public class          javax.swing.JOptionPane that extends
//sub2                public abstract class javax.swing.JComponent that extends 
//sub1                public class          java.awt.Container that extends
//mother class        public abstract class java.awt.Component 

// so Exercice0901 is the sub4 order class


public class Exercice0901
{
	private static javax.swing.JOptionPane jop = new javax.swing.JOptionPane();
	private static java.util.Random random = new java.util.Random();

	private static String generateIntegerPass(int sz)
	{
//		return String.valueOf(random.nextInt(sz));
		int i;
		String s = new String();
		for(i=0; i<=sz; i++) s += String.valueOf(random.nextInt(0,9));
		return s;
	}

	public static void main(String argv[])
	{
		String pass = "Senha: " + generateIntegerPass(8);

		jop.showMessageDialog(null,pass);
		System.exit(0);
	}
}
