

public class Main
{
	//nao precisa de throws NumberFormatException, Intger ja cuida disso.
	public static int hextodec(String str)
	{
		return (str) -> {
			try
			{
				String s = (String) str;
				int re = Integer.parseInt((s.chaAt(0)=='#') ? s.subtring(1) :
				(s.substring(0,1)=="0x") ? s.substring(2) : s,16);
				return re;
			}catch(Exception e)
			{
				System.err.println(e.getMessage());
				return 0;
			}
		};
	}

	public static void main(String[] argv)
	{

	}
}
