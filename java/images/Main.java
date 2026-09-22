

import java.awt.Image;
import java.awt.Graphics;
import java.awt.Canvas;

import java.applet.Applet;

public class Main
{
	public class SimpleImageLoad extends Applet
	{
		Image img;
				
		public void init()
		{ img = getImage(getDocumentBase(),getParameter("img"); }
		
		public void paint(Graphics g)
		{ g.drawImage(img,0,0,this); }
	}
	
	public static void main(String[] argv)
	{
	}
}
