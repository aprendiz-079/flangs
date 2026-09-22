


import java.awt.*;
import java.awt.event.*;


public class Main extends Frame /*implements ActionListener*/
{
	public Panel     max,pbot,p1,p2,p3;
//	public TextField tx1,tx2;
	public Label     l1,l2,l3;
	public Button    b1,b2,b3;


	public Main()
	{
		int green  = 0x43A047;
		int orange = 0xEF6C00;
		int yellow = 0xFFEB3B;

		//setting window
		setTitle("The CardLayout class");
		setSize(new Dimension(300,200));
		setLocationRelativeTo(null);
		setResizable(true);
		setBackground(new Color(0x263238));
		setLayout(new BorderLayout(5,5));

		//setting buttons
		b1 = new Button("Green");
		b1.setBackground(new Color(green));
		b1.setForeground(Color.black);
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{ (CardLayout)max.getLayout().show(max,"p1"); }
		});

		b2 = new Button("Orange");
		b2.setBackground(new Color(orange));
		b2.setForeground(Color.white);
		b2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{ ((CardLayout)max.getLayout()).show(max,"p2"); }
		});

		b3 = new Button("Yellow");
		b3.setBackground(new Color(yellow));
		b3.setForeground(Color.black);
		b3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{ ((CardLayout)max.getLayout()).show(max,"p3"); }
		});

		//setting labels
		l1 = new Label("The color is green.");
		l2 = new Label("The color is orange.");
		l3 = new Label("The color is yellow.");

		//setting text fields
//		tx1 = new TextField("write here");
//		tx2 = new TextField();

		//setting main panels
		max = new Panel();                    //max
		max.setSize(100,200);
		max.setLayout(new CardLayout());

		pbot = new Panel();                   //pbot
		pbot.setSize(100,200);
		pbot.setLayout(new GridLayout(3,1));
		//add buttons to pbot
		pbot.add(b1);
		pbot.add(b2);
		pbot.add(b3);

		//settting sub panels (cards)
		p1 = new Panel();                     //p1
		p1.setBackground(new Color(green));
		p1.setLayout(new FlowLayout());
		p1.add(l1);

		p2 = new Panel();                     //p2
		p2.setBackground(new Color(orange));
		p2.setLayout(new FlowLayout());
		p2.add(l2);

		p3 = new Panel();                     //p3
		p3.setBackground(new Color(yellow));
		p3.setLayout(new FlowLayout());
		p3.add(l3);

		max.add(p1, "p1");
		max.add(p2, "p2");
		max.add(p3, "p3");

		add(max, BorderLayout.CENTER);
		add(pbot,BorderLayout.WEST);

		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{ System.exit(0); }
		});
	}

/*
	public void actionPerformed(ActionEvent e)
	{
		CardLayout cl = (CardLayout) max.getLayout();

		if(e.getSource()==b1)
		{ cl.show(max, "p1"); }

		if(e.getSource()==b2)
		{ cl.show(max, "p2"); }

		if(e.getSource()==b3)
		{ cl.show(max, "p3"); }

		cl.show(max, 
		(e.getSource()==b1) ? "p1" : 
		(e.getSource()==b2) ? "p2" : "p3");

	}
*/
	public static void main(String[] argv)
	{
		Main m = new Main();
		m.setVisible(true);
	}
}
