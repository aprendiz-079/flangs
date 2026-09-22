

import javax.swing.*;

import java.awt.Color;

public class Main extends JFrame
{

	public Main()
	{ this.setTitle("The JFrame class."); }

	public void a()
	{
		this.setBounds(200,150,400,300);
	}

	public void b()
	{
		this.setLocation(50,100);
		this.setSize(600,450);
		this.getContentPane().setBackground(Color.orange.brighter());
	}

	public static void main(String[] argv)
	{
		Main m = new Main();
		m.a();
		m.b();
		m.setVisible(true);
	}
}
