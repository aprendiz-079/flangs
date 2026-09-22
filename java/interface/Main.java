

/*
interfaces sao 
em interfaces metodos sao implicitamente publicos, 
atribtos sao implicitamente static final.
*/

sealed class Animals extends Main permits Dog, Cat
{
  protected void println(String s)
  { p(s); }

  protected static void to_walk()
  { p("walking ...\n"); }
}

final class Dog extends Animals implements Main.DogsActions
{
  private String name;
  private int age;

  public Dog(String name, int age)
  {
    this.name = name;
    this.age = age;
  }

  public void yap()
  { println("yaping ..."); }

  public void get_the_ball()
  { println("the dog goes to get the ball ..."); }

  public void bite()
  { println("biting ..."); }
}

final class Cat extends Animals implements Main.CatsActions
{
  private String name;
  private int age;

  public Cat(String name, int age)
  {
    this.name = name;
    this.age = age;
  }

  public void meow()
  { println("meowing ..."); }

  public void purr()
  { println("purring ..."); }

  public void to_rustle()
  { println("tustling ..."); }
}

public sealed class Main permits Animals
{
  protected static void p(String s)
  { System.out.println(s); }

  public interface CatsActions
  {
    void meow();

    void purr();

    void to_rustle();

    default void std()
    { p("opa"); }
  }

  public interface DogsActions
  {
    void yap();

    void get_the_ball();

    void bite();
  }

  public static void main(String[] argv)
  {
  	Main.Animal main = new Main.Ani;

    p(String.valueOf(cat.meow()));

    NumericTest isEven = (n) -> (n % 2) == 0;

    if(isEven.test(10)) p("10 is even");
    if(isEven.test(1)) p("1 is odd");
  }
}

interface NumericTest
{
	boolean test(int n);
}
