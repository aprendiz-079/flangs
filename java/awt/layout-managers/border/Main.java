

import java.awt.event.*;
import java.awt.*;
import java.util.Random;


public class Main
{
	private static void new_window()
	{
		Frame w = new Frame("The BorderLayout class");
		w.setSize(new Dimension(400,300));
		w.setResizable(true);
		w.setLocation(
			new Random().nextInt(50,100), 
			new Random().nextInt(50,100));

		//set a aleatory background
		w.setBackground(new Color(
			new Random().nextInt(256), 
			new Random().nextInt(256), 
			new Random().nextInt(256)));


		Panel p = new Panel();
		p.setLayout(new FlowLayout(1));
		p.setBackground(Color.white.darker());

		String s = "Main";
		Label l = new Label(s);
		l.setFont(new Font("Arial",Font.BOLD | Font.PLAIN, 20));
		p.add(l);

		w.add(p,BorderLayout.NORTH);

		w.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{ System.exit(0); }
		});

		w.setVisible(true);
	}

	public static void main(String[] argv)
	{
		new_window();
	}
}
