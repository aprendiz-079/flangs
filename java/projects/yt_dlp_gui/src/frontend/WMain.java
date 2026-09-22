
package yt_dlp_gui.src.frontend;

import java.awt.*;
import java.awt.event.*;

public class WMain extends Frame
{
	private TextField url_field;
	private TextArea console;

	WMain()
	{
		super("YT-DLP-GUI");
		setup_window();

		create_menubar();
		create_components();

		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{ exitApp(); }
		});
	}

	private void setup_window()
	{
		setSize(800, 600);
		setBackground(new Color(245, 245, 245));
		setLayout(new BorderLayout(10, 10));

		Panel main_panel = new Panel(new BorderLayout(10, 10));
		main_panel.setBackground(new Color(245, 245, 245));
		add(main_panel, BorderLayout.CENTER);
	}

	private void create_menubar()
	{
		MenuBar mb = new MenuBar();

		// Menu file
		Menu file_menu = new Menu("File");

		MenuItem sfo = new MenuItem("Set file out");
		sfo.setShortcut(new MenuShortcut(KeyEvent.VK_N));
		sfo.addActionListener(e -> set_file_out());

		MenuItem 
	}

	private void create_components()
	{
		Panel main_panel = (Panel) getComponent(0);
		Panel form_panel = new Panel(new GridBagLayout());
		form_panel.setBackground(Color.WHITE);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.fill = GridBagConstraints.HORIZONTAL;

		// title
	}

	private void setup_buttons()
	{
		set_help_btn();
		set_download_btn();
		set_get_formats_btn();
		set_set_format_btn();
	}

	private void set_help_btn()
	{}

	private void set_download_btn()
	{}

	private void set_get_formats_btn()
	{}

	private void set_set_format_btn()
	{}

	private void exit_app()
	{ System.out.println("Closing app."); System.exit(0);}

	public static void main(String[] argv)
	{
		WMain wm = new WMain();
	}
}
