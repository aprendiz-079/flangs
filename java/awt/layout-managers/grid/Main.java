

import java.awt.*;
import java.awt.event.*;


public class Main
{
	public static void main(String[] argv)
	{
		Frame w = new Frame("The GridLayout class");
		w.setSize(new Dimension(200,200));
		w.setLocationRelativeTo(null);
		w.setBackground(Color.black);
		w.setResizable(false);
		w.setLayout(new BorderLayout(5,5));

		//setting p1
		Panel p1 = new Panel();
		p1.setSize(195,180);
		p1.setLocation(5,20);
		p1.setLayout(new GridLayout(4,4,2,2));
		//

		//setting buttons
		Button b1 = new Button("1");
		b1.setBackground(Color.white);

		Button b2 = new Button("2");
		b2.setBackground(Color.white);

		Button b3 = new Button("3");
		b3.setBackground(Color.white);

		Button b4 = new Button("4");
		b4.setBackground(Color.white);

		Button b5 = new Button("5");
		b5.setBackground(Color.white);

		Button b6 = new Button("6");
		b6.setBackground(Color.white);

		Button b7 = new Button("7");
		b7.setBackground(Color.white);

		Button b8 = new Button("8");
		b8.setBackground(Color.white);

		Button b9 = new Button("9");
		b9.setBackground(Color.white);

		Button b0 = new Button("0");
		b0.setBackground(Color.white);


		Button b10 = new Button("SUM");
		b10.setBackground(Color.white);

		Button b11 = new Button("SUB");
		b11.setBackground(Color.white);

		Button b12 = new Button("DIV");
		b12.setBackground(Color.white);

		Button b13 = new Button("MUL");
		b13.setBackground(Color.white);

		Button b14 = new Button("SQRT");
		b14.setBackground(Color.white);

		Button b15 = new Button("15");
		b15.setBackground(Color.white);
		//

		//add buttons
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);
		p1.add(b5);
		p1.add(b6);
		p1.add(b7);
		p1.add(b8);
		p1.add(b9);
		p1.add(b0);

		p1.add(b10);
		p1.add(b11);
		p1.add(b12);
		p1.add(b13);
		p1.add(b14);
		p1.add(b15);
		//

		w.add(p1, BorderLayout.CENTER);

		w.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{ System.exit(0); }
		});

		w.setVisible(true);
	}
}
