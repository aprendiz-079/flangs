

import java.awt.*;
import java.awt.event.*;


public class Main
{
	public static void newWindow(int f)
	{
		//the window
		Frame w = new Frame("The Flow layout");
//		w.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		w.setSize(450,260);
		w.setBackground(Color.white);
		w.setResizable(true);
		w.setLocationRelativeTo(null);
		w.setLayout(new FlowLayout(f));

		//labels
		Label l1 = new Label("Esta eh a classe FlowLayout");
		l1.setBackground(new Color(250,250,200));

		//text field
		TextField t1 = new TextField("  ");
		TextField t2 = new TextField("Escreva outra mensagem aqu");

		//buttons
		Button b1 = new Button("Exit");
		b1.setBackground(new Color(250,250,200));
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{ System.exit(0); }
		});

		Button b2 = new Button("RED");
		b2.setBackground(Color.red);

		Button b3 = new Button("GREEN");
		b3.setBackground(Color.green);

		Button b4 = new Button("BLUE");
		b4.setBackground(Color.blue);

		Button b5 = new Button("ORANGE");
		b5.setBackground(Color.orange);

		Button b6 = new Button("GREY");
		b6.setBackground(Color.black.brighter());

		Button b7 = new Button("YELLOW");
		b7.setBackground(Color.yellow);

		Button b8 = new Button("DARK-ORANGE");
		b8.setBackground(Color.orange.darker());

		//add all
		w.add(l1);

		w.add(t1);
		w.add(t2);

		w.add(b1);
		w.add(b2);
		w.add(b3);
		w.add(b4);
		w.add(b5);
		w.add(b6);
		w.add(b7);
		w.add(b8);

		w.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{ System.exit(0); }
		});

		w.setVisible(true);
	}

	public static void main(String[] argv)
	{
		newWindow(0);
		newWindow(1);
		newWindow(2);
	}
}
