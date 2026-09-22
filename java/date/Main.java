

import java.util.Date;


public class Main
{
  private static void p(String s)
  { System.out.println(s); }


  private static void a()
  {
    Date dt = new Date();

    p(String.valueOf(dt) + " = " + String.valueOf(dt.getTime()));
    dt.setTime(0);
    p(dt + " = " + dt.getTime());
  }

  private static void b()
  {
    Date now = new Date();
    p(now + " = " + now.getTime());

    Date dt = new Date(1234567890000L);
    p(dt + " = " + dt.getTime());

    dt.setTime(0);
    p(dt + " = " + dt.getTime());

    dt.setTime(40L * 365 * 24 * 60 * 60 * 1000);
    p(dt + " = " + dt.getTime());

    dt.setTime(dt.getTime() + 11 * 24 * 60 * 0 * 1000);
    p(dt + " = " + dt.getTime());
  }


  public static void main(String[] argv)
  {
//    a();
    b();
  }
}
