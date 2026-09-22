

import java.awt.*;
import java.awt.event.*;

public class Program
{
	public Frame window = new Frame("Calculadora de Pressao");
//	public Font font = new Font("Arial", Font.PLAIN, 20);
//	public int width = w.getFontMetrics(font).stringWidth(" ") * 45;
//	public int height = w.getFontMetrics(font).stringHeight(" ") * 34;
	public int width  = 800;
	public int height = 300;

	public Panel center_panel;

	private void start()
	{
		configWindow();
		configMainPage();
	}

	public void configWindow()
	{
		Frame w = window;

		w.setSize(new Dimension(width,height));
		w.setLocationRelativeTo(null);
		w.setResizable(false);
		w.setLayout(new BorderLayout());

		w.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{ System.exit(0); }
		});

		w.setVisible(true);
	}

	public void configMainPage()
	{
/*
		String s = "_";
		for(int i = 1; i <= width / 18; i++) s += "_";
		Label divisor = new Label(s);
		divisor.setFont(new Font("Arial", Font.PLAIN, 20));
*/
		Label title_lbl = new Label("Calculadora de pressao");
		title_lbl.setFont(new Font("Arial", Font.PLAIN, 30));

		Panel title = new Panel(new FlowLayout(1));
		title.add(title_lbl);

		center_panel = new Panel(new GridLayout(3,1,10,10));

		Panel informations_panel = new Panel(new FlowLayout(0));
		Label definition = new Label("P = F/A = N/m² = 1 pascal ou 1 Pa portanto: Pa = kg/ms²");
		definition.setFont(new Font("Arial", Font.PLAIN, 20));

		Label units = new Label("1 atm = 760 mm de Hg ou 13 596kg/m³ * 9.80665m/s² * 0.76m = 101.325kg/ms² ~= 1.013e5 Pa");
		units.setFont(new Font("Arial", Font.PLAIN, 20));

		informations_panel.add(definition);
		informations_panel.add(units);
//		informations_panel.add(divisor);

		Panel inputs_panel = new Panel(new FlowLayout(1));
		Panel metadata_panel = new Panel(new FlowLayout(0));

		Label formula_lbl = new Label("P = y * Z");
		formula_lbl.setFont(new Font("Arial", Font.PLAIN, 16));

		Panel formula_panel = new Panel(new GridLayout(1,3,2,2));
		TextField p_in = new TextField(1);
		TextField y_in = new TextField(1);
		TextField z_in = new TextField(1);
		formula_panel.add(p_in);
		formula_panel.add(y_in);
		formula_panel.add(z_in);

		inputs_panel.add(formula_lbl);
		inputs_panel.add(formula_panel);
//		inputs_panel.add(divisor);

		center_panel.add(informations_panel);
		center_panel.add(inputs_panel);
		center_panel.add(metadata_panel);

		window.add(title, BorderLayout.NORTH);
		window.add(center_panel, BorderLayout.CENTER);
	}

	public static void main(String[] argv)
	{ new Program().start(); }
}
