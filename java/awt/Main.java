

import java.awt.*;
import java.awt.event.*;


public class Main
{
	public static void main(String[] argv)
	{
		Frame w = new Frame("Test");
		w.setSize(new Dimension(400,300));
		w.setResizable(false);
		w.setLocationRelativeTo(null);
		w.setBackground(new Color(0xE0E0E0));
		w.setLayout(new BorderLayout());


		Panel p0 = new Panel(new GridLayout(1,2));


		Button b1 = new Button("O");
		b1.setBackground(new Color(0x424242));
		Button b2 = new Button("X");
		b2.setBackground(new Color(0x424242));

		Panel p1 = new Panel(new FlowLayout(0));
		p1.setBackground(Color.orange);
		p1.add(b1);
		p1.add(b2);

		Button b3 = new Button("A");
		b3.setBackground(new Color(0x424242));
		Button b4 = new Button("B");
		b4.setBackground(new Color(0x424242));
		Button b5 = new Button("C");
		b5.setBackground(new Color(0x424242));
		Button b6 = new Button("D");
		b6.setBackground(new Color(0x424242));

		Panel p2 = new Panel(new FlowLayout(2));
		p2.setBackground(Color.blue);
		p2.add(b3);
		p2.add(b4);
		p2.add(b5);
		p2.add(b6);


		p0.add(p1);
		p0.add(p2);

		w.add(p0, BorderLayout.NORTH);

		Panel p = new Panel();
		p.setBackground(Color.green);

		w.add(p, BorderLayout.CENTER);

		w.setVisible(true);
	}
}
