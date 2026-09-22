

package yt-dlp.src.logic;

import java.lang.ProcessBuilder;
import java.lang.Process;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Commands
{
	private pb = new ProcessBuilder();

	public void yt-dlp(String[] argv) throws IOException
	{
		
	}
}

/*

public class Run_bash_command
{
	public static void main(String[] argv)
	{
		try
		{
			ProcessBuilder pb = new ProcessBuilder("bash", "-c", "ls -la");
			Process pc = pb.start();
			BufferedReader output = new BufferedReader
			(new InputStreamReader(pc.getInputStream()));

			String line;
			while ((line = output.readLine()) != null)
			{ System.out.println(line); }
		} catch (IOException e)
		{ System.err.println("Erro cd IO: " + e.getMessage()); }
	}
}
*/
