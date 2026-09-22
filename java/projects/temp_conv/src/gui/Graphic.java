

package temp_conv.src.gui;

import static temp_conv.src.logic.TempConversor.*;

import java.awt.Frame;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.Font;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Button;
import java.awt.TextField;

import java.io.IOException;

import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Graphic
{
	public boolean windowIsOpen = false;
	
	public Frame window = new Frame();

	public Panel io_panel = new Panel(new FlowLayout(1));
	public Panel buttons_panel = new Panel(new GridLayout(3,2,10,10));
		
	public TextField input_txt = new TextField(50);
	public TextField output_txt = new TextField(50);


	public Graphic()
	{
		setupWindow();
	
		setupPage();
	}	

	public void setupPage()
	{
		input_txt.setEditable(true);
		output_txt.setEditable(false);
	
		io_panel.add(input_txt);
		io_panel.add(output_txt);

		Button ktoc = new Button()
		{{
			setLabel("K to C");
			setBackground(new Color(0xEEEEEE));
			addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{ input_txt.setText(() -> {
					
				}); }
			});
		}};/*
		Button ktof = new Button()
		{{
			setLabel("K to F");
			setBackground(new Color(0xEEEEEE));
			addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{ ktof(Double.valueOf(input_txt.getText())); }
			});
		}};
		Button ctok = new Button()
		{{
			setLabel("C to K");
			setBackground(new Color(0xEEEEEE));
			addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{ ctok(Double.valueOf(input_txt.getText())); }
			});
		}};
		Button ctof = new Button()
		{{
			setLabel("C to F");
			setBackground(new Color(0xEEEEEE));
			addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{ ctof(Double.valueOf(input_txt.getText())); }
			});
		}};
		Button ftoc = new Button()
		{{
			setLabel("F to C");
			setBackground(new Color(0xEEEEEE));
			addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{ ftoc(Double.valueOf(input_txt.getText())); }
			});
		}};
		Button ftok = new Button()
		{{
			setLabel("F to K");
			setBackground(new Color(0xEEEEEE));
			setSize(60,80);
			addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{ ftok(Double.valueOf(input_txt.getText())); }
			});
		}};
		*/
		buttons_panel.add(ftok);
		buttons_panel.add(ftoc);
		buttons_panel.add(ctof);
		buttons_panel.add(ktof);
		buttons_panel.add(ctok);
		buttons_panel.add(ktof);
		
		window.add(io_panel);
		window.add(buttons_panel);
	}

	public void setupWindow()
	{
		if (windowIsOpen == true) System.exit(0);

		Frame w = window;
		w.setTitle("TEMPERATURE CONVERSOR");
		w.setSize(new Dimension(440, 700));
		w.setBackground(new Color(0x80D8FF));
		w.setLayout(new FlowLayout(1));
		
		w.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				windowIsOpen = false;
				w.setVisible(false);
			}
		});

		w.setVisible(true);

		windowIsOpen = true;
	}
}
