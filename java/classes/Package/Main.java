


public class Main
{
	public static void main(String[] argv)
	{
		for(Package p : Package.getPackages()) 
			System.out.println(p.getName());
	}
}
