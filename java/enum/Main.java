

public class Main
{
  private static void p(String s)
  { System.out.println((s==null || s.isEmpty()) ? "" : s); }

  public static void main(String[] argv)
  {
    CardValue vc = CardValue.ACE;
    p(String.valueOf(vc.ordinal()));
  }
}


public enum CardValue
{
  ACE,THO,THREE,FOUR,FIVE,SIX,
  SEVEN,EIGHT,NINE,TEN,JACK,QUEEN,KING;

  public int blackJackValue()
  { return (this==JACK || this==QUEEN || this==KING) ? 10 : 1 + ordinal(); }

  public String toString()
  {
    switch(this)
    {
      case ACE:   return "Ace";
      case JACK:  return "Jack";
      case QUEEN: return "Quenn";
      case KING:  return "King";
      default:
        int numericValue = 1 + ordinal();
        return "" + numericValue;
    }
  }
}
