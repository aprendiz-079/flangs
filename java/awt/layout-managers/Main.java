

import java.awt.*;

public class Main
{
	public static void main(String[] argv)
	{
		Frame m = new Frame("No Title");
		Panel north_panel = new Panel();
		Panel center_panel = new Panel();
		Panel south_panel = new Panel();

		north_panel.add(new Button("One"));
		north_panel.add(new Button("Two"));
		north_panel.add(new Button("Three"));

		center_panel.setLayout(new GridLayout(4,4));
		center_panel.add(new TextField("First"));
		center_panel.add(new TextField("Second"));
		center_panel.add(new TextField("Third"));
		center_panel.add(new TextField("Fourth"));

		south_panel.setLayout(new BorderLayout());
		south_panel.add(new Checkbox("Casado"), BorderLayout.CENTER);
		south_panel.add(new Checkbox("Solteiro"), BorderLayout.EAST);
		south_panel.add(new Checkbox("Separado"), BorderLayout.WEST);

		m.add(north_panel, BorderLayout.NORTH);
		m.add(center_panel, BorderLayout.CENTER);
		m.add(south_panel, BorderLayout.SOUTH);
		m.setSize(new Dimension(300,300));
		m.setVisible(true);
	}
}
