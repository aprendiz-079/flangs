


public class Vetor
{
	//declaration sintax:
	//<type>[] <name>;
	//<type> <name>[];

	//instanciation sintax:
	//<name> = new <type>[<positions>];

	//declaration and instanciation sintax:
	//<type>[] <name> = new <type>[<positions>];
	//<type> <name>[] = new <type>[<positions>];


	//adding data sintax:
	//<type>[] <name> = {<value_1>, <value_2>, ..., <value_n>};
	//<type> <name>[] = {<value_1>, <value_2>, ..., <value_n>};

	//<type>[] <name> = new <type>[]{<value_1>, <value_2>, ..., <value_n>};
	//<type> <name>[] = new <type>[]{<value_1>, <value_2>, ..., <value_n>};


	public static void main(String argv[])
	{
		int vetor[] = new int[]{3, 4, 5, 3};
		System.out.println(vetor.instanceOf(Integer) ? "true" : "false");
	}
}
