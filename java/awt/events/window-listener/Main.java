

import java.util.List;
import java.util.ArrayList;

import java.awt.Frame;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Label;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Main extends Frame implements WindowListener
{
	public ArrayList<Label> labels = new ArrayList<>();
	public Dimension dim;

	public void createWindow()
	{
		setTitle("The event set");
		dim = new Dimension(400,300);
		setSize(dim);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
 		setBackground(Color.white);

		String s = "This program close the window.";
		Label l1 = new Label(s);
		l1.setLocation(10,10);
		l1.setSize(s.length() * 10,20);
		l1.setBackground(Color.black);
		labels.add(l1);
		add(l1);
		addWindowListener(this);
		setVisible(true);
	}

	public void windowClosing(WindowEvent e)
	{ System.exit(0); }

	public void windowActivated(WindowEvent e)
	{}

	public void windowDeactivated(WindowEvent e)
	{}

	public void windowDeiconified(WindowEvent e)
	{}

	public void windowIconified(WindowEvent e)
	{}

	public void windowOpened(WindowEvent e)
	{}

	public void windowClosed(WindowEvent e)
	{}

	public static void main(String[] argv)
	{ new Main().createWindow(); }
}
