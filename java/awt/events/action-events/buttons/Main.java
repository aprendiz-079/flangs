



import java.awt.event.*;
import java.awt.*;

public class Main
{
	private Frame window = new Frame("Buttons");
	public boolean windowColorIsBlack = false;

	private static void startWindow()
	{
		Main m = new Main();
		m.createWindow();
		m.window.setVisible(true);
	}

	public void createWindow()
	{
		Frame w = window;
		w.setSize(Toolkit.getDefaultToolkit().getScreenSize());
//		w.setLocationRelativeTo(null);
		w.setBackground(Color.white);
		w.setResizable(true);

		//create label
		String s = "Aperte qualquer botao para \nmudar a cor de fundo.";
		Label l = new Label(s);
		l.setLocation(10,10);
		l.setSize(s.length() * 10, 16);
		l.setBackground(Color.black);
		l.setForeground(Color.white);
		l.setFont(new Font("Arial", Font.BOLD | Font.PLAIN, 16));
		w.add(l);//add label

		//create button
		Button b = new Button("BLACK");
//		b.setLocation(100,100);
		b.setSize(50,50);
		b.setBackground(Color.red);
		b.setForeground(Color.white);

		b.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (!windowColorIsBlack)
				{ window.setBackground(Color.black); windowColorIsBlack = true; }
				else
				{ window.setBackground(Color.white); windowColorIsBlack = false; }
			}
		});//add action button

		Panel p = new Panel();
		p.add(b);
		w.add(p, BorderLayout.SOUTH);//add button

		//add windowEvent
		w.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{ System.exit(0); }
		});
	}

	public static void main(String[] argv)
	{ startWindow(); }
}
