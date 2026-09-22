



public class Main
{
	public static class Person implements Cloneable
	{
		private String name;

		public Person(String name)
		{ this.name = name; }
		
		public Person(Person other)
		{ this.name = other.name; }
		
		public String getName(){ return name; }
		
		public Person clone()
		{
			try
			{
					return (Person) super.clone();
			}catch(CloneNotSupportedException e)
			{ return null; }
		}
	}

	public static void main(String[] argv)
	{
		Person p1 = new Person("jorge");
		System.out.println("p1 name: " + p1.getName());
		
		Person p2 = p1.clone();
		System.out.println("p2 name: " + p2.getName());
		
	}
}
