

import javax.swing.JOptionPane;

public class Inviteds
{
	public static void main(String argv[])
	{
		int friends_qtt = 0; //quantity

		while(friends_qtt<=0)
		{
			String str = "Number of friends";
			str = JOptionPane.showInputDialog(null,str);
			if(str==null) System.exit(0);
			friends_qtt = Integer.parseInt(str);
		}

		String friends[] = new String[friends_qtt];

		for(int i=1; i<=friends.length; i++)
		{
			String str = "Friend " + i;
			str = JOptionPane.showInputDialog(null,str);
			if(str==null) break;
			str = str.trim();
			friends[i-1] = str;
		}

		String msg = "Friends list:";
		for(int position=0; position<friends.length; position++)//leitura, soma, 
		{
			if(friends[position]==null) break;
			msg += "\n- " + friends[position];
		}

		JOptionPane.showMessageDialog(null,msg);
		System.exit(0);
	}
}
