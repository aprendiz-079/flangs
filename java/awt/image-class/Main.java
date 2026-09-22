


import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Label;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Graphics;


public class Main extends Frame
{
	static { new Main().setup(); }

	Image img;

	private void setup()
	{
		setTitle("The Image class");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(dim);
		setResizable(true);
		setLocationRelativeTo(null);
		setBackground(Color.lightGray);

		img = Toolkit.getDefaultToolkit().getImage("./image/img.png");
		setLayout(null);
		String s = "Imagem: ";
		Label l = new Label(s);
		l.setLocation(10,10);
		l.setSize(s.length(),20);
		add(l);

		setVisible(true);
	}

	public void paint(Graphics g)
	{
		if(img!=null)
		{
			g.drawImage(img,0,20,this);
			super.paint(g);
		}
	}

	public static void main(String[] argv)
	{}
}
