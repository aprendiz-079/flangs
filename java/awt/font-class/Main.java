


import java.awt.Frame;
import java.awt.Font;
import java.awt.Label;
import java.awt.Dimension;


public class Main extends Frame
{
	static { new Main().setup(); }

	private void setup()
	{
		setTitle("The Dimension class");
		Dimension dim;
		dim = new Dimension(400, 300);
//		dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setBackground(java.awt.Color.white);
		setSize(dim);
		setLocationRelativeTo(null);
		setLayout(null);

		Label l = new Label("opa");
		l.setLocation(10, 10);
		l.setSize(120,40);
		add(l);

		setFont(new Font("TimesNewRoman", Font.PLAIN, 40));

		setVisible(true);
	}

	public static void main(String[] argv)
	{

	}
}

