

import java.awt.Frame;
import java.awt.Color;


public class Main extends Frame
{
	static { new Main().setup(); }

	private void setup()
	{
		setTitle("The Color class");
		Color color = Color.orange.brighter();
		setBackground(color);
		setVisible(true);
	}

	public static void main(String[] argv)
	{
		
	}
}
