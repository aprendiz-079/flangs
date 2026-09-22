

package pegassus.spy.src.java.src;


import java.lang.ProcessBuilder;
import java.lang.Process;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public enum ScrcpyFlags
{
VISUAL(1, "--no-control", "--fullscreen"), 

MOUSE
(2, "--mouse=disabled", "--mouse=auto", 
"--mouse=skd", "--mouse=uhid", "--mouse=aoa"), 

KEYBOARD
(3, "--keyboard=disabled", "--keyboard=auto", 
"--keyboard=sdk", "--keyboard=uhid", "--keyboard=aua"), 

MOUSE_AND_KEYBOARD(4, "-n", "--mouse=auto", "--keyboard=auto"), 

FULL(5, ""), CAMERA_ONLY(6, ""), VISUAL_AND_CAMERA(7, ""), 
AUDIO(8, ""), EMPTY(0, "");

	private final int id;
	private final String[] flags;

	ScrcpyFlags(int id, String... flags)
	{ this.id = id; this.flags = flags; }

	public String[] getFlags()
	{ return flags; }
};

public interface CMDs
{
	public void verify_target_xml();
	public void adb_connect();
	public void scrcpy(ScrcpyFlags mode);
}


public class Commands implements CMDs
{
	private static java.io.File f;
	private static java.io.FileReader fr;
	private static java.io.FileNotFoundException fe;

	private static ScrcpyFlags mode = VISUAL; //default option
	private static String target_ip;
	private static String target_port;
	private static boolean adb_connected = false;

	public static void verify_target_xml()
	{}

	public static void adb_connect()
	{
		try
		{
			String command = "adb connect " + target_ip + ":" + target_port;
			ProcessBuilder pb = new ProcessBuilder(command);

			Process pc = pb.start();
			int status = pc.waitFor();
			(status == 0) ? adb_connected = true; : adb_connected = false;

		} catch (Exception e)
		{ System.err.println(e.getMessage()); }
	}

// using 'auto' to mouse and keyboard flags
	public static void scrcpy(ScrcpyFlags mode)
	{
		if (mode == null) { System.out.println("NO MODE DECLARED"); return; }
		String[] flags = mode.getFlags();
		System.println(flags);
	}

	public static void main(String[] argv)
	{ Commands.scrcpy(); }
}
