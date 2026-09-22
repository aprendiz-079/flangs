

import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

import java.io.FileOutputStream;
import java.io.FileInputStream;

import java.io.Serializable;
import java.io.IOException;


class Person implements Serializable
{
	public String name;
	public transient int age; // not be save

	public Person(String name, int age)
	{ this.name = name; this.age = age; }
}

public class Main
{
	public static void main(String[] argv) throws IOException, ClassNotFoundException
	{
		Person p1 = new Person("Ana", 20);

		// serialise
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.txt"));
		oos.writeObject(p1);
		oos.close();

		// unserialise
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.txt"));
		Person p2 = (Person) ois.readObject();

		IO.println(p2.name);
		IO.println(p2.age); // 0 -> default to primitive types, null to Object
	}
}
