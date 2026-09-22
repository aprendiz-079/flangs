

import java.net.InetAddress;


public class Main
{
	public static void main(String[] argv)
	{
		try
		{
			InetAddress addr = InetAddress.getByName("google.com");
			System.out.println(addr.isReachable(500) ? "Alcancavel" : "Inalcancavel");
		}
		catch (Exception e)
		{ e.printStackTrace(); }
	}
}
