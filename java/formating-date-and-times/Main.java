

import java.text.DateFormat;
import java.util.Date;
import java.text.ParseException;

import javax.swing.JOptionPane;


public class Main extends JOptionPane
{
  private static void p(String s)
  { System.out.println(s); }

  private static void a()
  {
    Date today = new Date();

    DateFormat df = DateFormat.getDateInstance();
    p("Object class:\t" + df.getClass().getName());
    p("Standart format:\t" + df.format(today));

    df = DateFormat.getDateInstance(DateFormat.SHORT);
    p("Short format:\t\t" + df.format(today));

    df = DateFormat.getDateInstance(DateFormat.MEDIUM);
    p("Medium format:\t\t" + df.format(today));

    df = DateFormat.getDateInstance(DateFormat.LONG);
    p("Long format:\t\t" + df.format(today));

    df = DateFormat.getDateInstance(DateFormat.FULL);
    p("Full format:\t\t" + df.format(today));
  }

  private static void b()
  {
    DateFormat df = DateFormat.getDateInstance();
    df.setLenient(false);
    String s;

    while(true)
    {
      try
      {
        s = showInputDialog(null, "Input an data (dd/mm/aaaa)");
        if(s == null || s.isEmpty()) break;

        Date date = df.parse(s);
        showMessageDialog(null, 
        "Date informed: " + df.format(date), 
        "Message", INFORMATION_MESSAGE);
      }catch(ParseException e)
      { showMessageDialog(null, "Invalid date", "Error", ERROR_MESSAGE); }
    }
  }

  public static void main(String[] argv)
  {
//    a();
    b();
  }
}
