


import java.awt.Frame;
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
		setBackground(java.awt.Color.orange.brighter());
		setSize(dim);
		setVisible(true);
	}

	public static void main(String[] argv)
	{

	}
}
