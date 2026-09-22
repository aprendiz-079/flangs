

package Formulas.Physics.src.java.main;
import Formuas.Physics.src.java.main.gui.Cinematics_GUI;


import java.awt.*;
import java.awt.event.*;


public class Main extends Frame
{
	private int width, heigth;

	public Main(int _width, int _height)
	{
		width = _width;
		heigth = _heigth;

		Menu menu = new Menu();
	}

	public Main()
	{
		width = 800;
		height = 600;
	}


	public class Menu
	{
		private int w, h;

		private Button btn;
		private Panel pn;

		public Menu(int _w, int _h)
		{
			w = _w;
			h = _h;

			setupWindow(w, h);
		}

		public void setupWindow(int _w, int _h)
		{
			setTitle("PHYSICS MENU");
			setLayout(null);
			setBackground(new Color(100, 100, 100));
			setSize(_w, _h);
		}

	}
}
