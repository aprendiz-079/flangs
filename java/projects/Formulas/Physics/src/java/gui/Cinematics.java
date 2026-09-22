

package Formulas.Physics.src.java.main.gui.Cinematics_GUI;
import Formulas.Physics.src.java.main.Main;


import Formulas.Physics.src.logic.Cinematics;

public class CinematicsMenu extends Main
{ { System.out.println("Cinematics Menu initialized !"); }


	public CinematicMenu()
	{
		setupWindow();
		setupButtons();
	}

	private void setupButtons()
	{
		setButton
		("Movimento Retilineo Uniforme (MRU)\n\
		       s = s_0 + vt      ",
		380, "MRU");
		
		setButton
		("Movimento Uniformemente Variado (MUV)\n\	
		   ");
//		setButton();
	}

	private void setButton(String text, int y, byte index)
	{
		Button btn = new Button(text);

		btn.setBounds(10, y, 750, 30);

		btn.setBackground(Color.GREEN);
		window.add(btn);

		btn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
			}
		});
	}

}
