

import java.awt.event.*;
import java.awt.*;

import java.util.ArrayList;

public class Main extends Frame
{
	public ArrayList<Label> labels = new ArrayList<>();

	public void createWindow()
	{
		setTitle("Using the WindowAdapter class");
		setSize(new Dimension(400,300));
		setLocationRelativeTo(null);
		setLayout(null);
		setBackground(Color.white);

		String s = "sla porra";
		Label l1 = new Label(s);
		l1.setLocation(10,10);
		l1.setSize(s.length() * 10, 10 * 2);
		l1.setFont(new Font("Arial", Font.BOLD | Font.PLAIN, 20));
		l1.setForeground(Color.white);
		l1.setBackground(Color.black);
		labels.add(l1);
		add(l1);

		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{ System.exit(0); }
		});

		setVisible(true);
	}

	public static void main(String[] argv)
	{ new Main().createWindow(); }
}
