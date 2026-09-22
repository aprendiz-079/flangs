
// buffereds
import java.io.BufferedWriter;
import java.io.BufferedReader;
//

// io managers
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
//

// streams
import java.io.FileInputStream;
import java.io.FileOutputStream;
//

import java.io.File;

//import java.lang.StringBuffer;

import java.io.IOException; // standart Exception
import java.io.FileNotFoundException;


public class Main
{
	private static void p(String s)
	{ System.out.println(s); }

	private static void print_metadata(String path)
	{
		File f = new File(path);

		p("File name: " + f.getName());
		p("Path: "      + f.getPath());
		p("Abs Path: "  + f.getAbsolutePath());
		p("Parent: "    + f.getParent());
		p(f.exists() ? "exist" : "does not exists");
		p(f.canWrite() ? "writable" : "is not writable");
		p(f.canRead() ? "readable" : "is not readable");
		p("is " + (f.isDirectory() ? "" : "not ") + "a directory");
		p(f.isFile() ? "is a normal file" : "migth be a named pipe");
		p(f.isAbsolute() ? "is absolute" : "is not absolute");
		p("File last modified: " + f.lastModified());
		p("File size: " + f.length() + " Bytes");
	}

	private static StringBuffer cat(String file)
	{
		if(file == null || file.isEmpty()) return null;
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

			String _s = new String();
			StringBuffer s = new StringBuffer();

			while(_s != null)
			{
				s.append(_s + "\n");
				_s = reader.readLine();
			}

//			System.out.println(s);
			return s;
		}
		catch(FileNotFoundException e)
		{ System.out.println(e.getMessage()); }
		catch(IOException e)
		{ System.out.println(e.getMessage()); }
	}

	private static void write_in_file(String file)
	{
		if(file == null || file.isEmpty()) return;

		try
		{
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));

			String txt = "escrevido no final do file...";
			StringBuffer content = cat(file);
			String newContent = content + txt;
			writer.write(newContent);

			writer.close();
		}
		catch(FileNotFoundException e)
		{ System.out.println(e.getMessage()); }
		catch(IOException e)
		{ System.out.println(e.getMessage()); }
	}

	public static void main(String[] argv)/* throws FileNotFoundException*/
	{
//		print_metadata("/home");
//		cat("Tasks.java");
		write_in_file("Tasks.java");
	}
}
