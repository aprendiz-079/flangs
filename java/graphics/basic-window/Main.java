

import java.awt.Graphics;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;


public class Main
{
  public class Display extends JPanel
  {
    public static void paintComponent(Graphics g)
    {
      super.paintComponent(g);// is protected
      g.drawString("opa", 20, 30);
    }

    public static class ButtonHandler implements ActionListener
    { public void ationPerformed(ActionEvent e) { System.exit(0); } }
  }

  public static void main(String[] argv)
  {
    Display display = new Display();
    JButton ok_btn = new JButton("OK");
    ok_btn.addActionListener(listener);

    JPanel content = new JPanel();
    content.setLayout(new BorderLayout());
    content.add(display, BorderLayout.CENTER);
    content.add(ok_btn, BorderLayout.SOUTH);

    JFrame window = new JFrame("basic window");
    window.setContentPane(content);
    window.setSize(250, 100);
    window.setVisible(true);
  }
}
