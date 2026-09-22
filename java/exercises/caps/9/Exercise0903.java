

public class Exercise0903
{
	private static javax.swing.JOptionPane jop = new javax.swing.JOptionPane();

	private static String getStudentName()
	{
		String name = new String("");

		while(true)
		{
			name = jop.showInputDialog(null,"Enter ur name");

			if(name.length()<=50 && name.length()>=2) break;

			jop.showMessageDialog(null,
				"Invalid name size!\n" + 
				"The student name most have from 2 at 50 chars.");
		}
		return name;
	}

	private static double[] getNotes()
	{
		String note = new String("");
		int notes_qtt = 0;
		double[] notes = new double[10];

		for(int i=0; i<10; i++)
		{
			note = jop.showInputDialog(null,"Note " + String.valueOf(i+1));
			if(note.isEmpty()) break;
			notes[i] = Double.parseDouble(note);
			notes_qtt++;
		}

		//zerar o resto das notas soh por precausao, 
		//para evitar NullPointerException na hora do calculo da media
		for(int i=notes_qtt; i<10; i++) notes[i] = 0.0;

		return notes;
	}

	private static double calcAverage(double[] notes)
	{
		if(notes.length==0) return 0.0;

		int notes_sz = 0;
		double sum = 0.0;
		for(int i=0; i<notes.length; i++)
		{
			sum += notes[i];
			if(notes[i]!=0.0) notes_sz++;
		}

		return sum/notes_sz;
	}

	public static void main(String[] argv)
	{
		String student_name = getStudentName();
		if(student_name=="") System.exit(0);

		double[] notes = getNotes();
		if(notes.length==0)
		{
			jop.showMessageDialog(null,"The notes quantity cannot be 0;");
			System.exit(0);
		}

		String msg = new String(
		"Student name: " + student_name + "\n" + 
		"Notes: " + java.util.Arrays.toString(notes) + "\n" + 
		"Average: " + String.valueOf(calcAverage(notes)));

		jop.showMessageDialog(null,msg);
	}
}
