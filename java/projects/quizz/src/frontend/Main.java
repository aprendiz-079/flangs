
/*
Main.java
Settings.java
*/


package quizz.src.frontend;

import java.awt.Frame;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.Color;
import java.awt.Button;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.Panel;

import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Main
{
	public Frame window;                        // window main

	public CardLayout cards = new CardLayout(); // the cards set

	public Panel pages = new Panel(cards);      // pages set

//pages
	public Panel main_page, settings, level1,level2,level3,
	all_flags, europe, asia, north_america, south_america,
	africa, australia_and_oceania, capitals;

	public Panel four_countries, four_flags, colour_the_flags_e, 
	quiz_e, drag_and_drop, six, colour_the_flags_h, 
	one_minute_countries, one_minute_flags, quiz_h, maps, 
	mixed_questions, flashcards, table;
//

//challenges buttos
	public Map<String, Button> challenges = new HashMap<>(Map.of(
	"four countries_btn", four_countries_btn, 
	"four_flags_btn", four_flags_btn, 
	"colour_the_flags_e_btn", colour_the_flags_e_btn, 
	"quiz_e_btn", quiz_e_btn, 
	"drag_and_drop_btn", drag_and_drop_btn, 
	"siz_btn", six_btn, 
	"colour_the_flags_h_btn", colour_the_flags_h_btn, 
	"one_minute"one_minute_countries_btn, one_minute_flags_btn, quiz_h_btn, maps_btn, 
	mixed_questions_btn, flashcards_btn, table_btn
	));
//

	public Label pontuation;
	public int successes = 0;
	public int failures = 0;

	public Main()
	{
		setupWindow();
		setupMainPage();
		setupPages();
		createChallenges();
		setupChallenges();
		window.add(pages);
	}

	public void setupWindow()
	{
		window = new Frame();
		Frame w = window;
		w.setTitle("Quizz Flags");
		w.setSize(new Dimension(460,960));
		w.setResizable(false);
		w.setLocationRelativeTo(null);
		w.setBackground(new Color(0xE0E0E0));
		w.setLayout(new BorderLayout());

		w.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{ System.exit(0); }
		});

		setupMainPage();
	}

	public void setupChallenges()
	{
		Panel head = new Panel(new BorderLayout());
		Panel head_l = new Panel(new GridLayout(1,2,5,5));
		pontuation = new Label("S: " + 
			successes + "\n" + "F: " + failures);
		Button cb = new Button("<-");

		head_l.add(pontuation);


		four_countries = new Panel(new BorderLayout());

		pages.add(four_countries, "four_countries");
	}

	public void setupPages()
	{
		setupLevels();
		setupAllFlags();
		setupEurope();
		setupAsia();
		setupNorthAmerica();
		setupSouthAmerica();
		setupAfrica();
		setupAustraliaAndOceania();
	}

	public void setupAustraliaAndOceania()
	{
		australia_and_oceania = setupChallange("Australia and Oceania");
		pages.add(australia_and_oceania, "australia_and_oceania");
	}

	public void setupAfrica()
	{
		africa = setupChallange("Africa");
		pages.add(africa, "africa");
	}

	public void setupSouthAmerica()
	{
		south_america = setupChallange("South America");
		pages.add(south_america, "south_america");
	}

	public void setupNorthAmerica()
	{
		north_america = setupChallange("North America");
		pages.add(north_america, "north_america");
	}

	public void setupAsia()
	{
		asia = setupChallange("Asia");
		pages.add(asia, "asia");
	}

	public void setupEurope()
	{
		europe = setupChallange("Europe");
		pages.add(europe, "europe");
	}

	public void setupAllFlags()
	{
		all_flags = setupChallange("All Flags");
		pages.add(all_flags, "all_flags");
	}

	public void setupLevels()
	{
		level1 = setupChallange("Level 1");
		level2 = setupChallange("Level 2");
		level3 = setupChallange("Level 3");
		pages.add(level1, "level1");
		pages.add(level2, "level2");
		pages.add(level3, "level3");
	}
	
	

	public Panel createChallanges()
	{
		Panel level = new Panel(new BorderLayout());

		Panel head = new Panel(new BorderLayout()); // head

//  head left
		Panel head_l = new Panel(new GridLayout(1,2,5,1));

		Button comeback_btn = new Button("<-");
		comeback_btn.setSize(new Dimension(25,25));
		comeback_btn.addActionListener(e -> cards.show(pages, "main"));

		Label label = new Label(op);

		label.setFont(new Font("Arial", Font.PLAIN, 20));

		head_l.add(comeback_btn);
		head_l.add(label);
//

//  head right
		Panel head_r = new Panel();
		Button dump = new Button("Dump");
		dump.setBackground(Color.blue);

		Button settings = new Button("Set...");

		head_r.add(dump);
		head_r.add(settings);
//

		head.add(head_l, BorderLayout.WEST);      // add head_l to head
		head.add(head_r, BorderLayout.EAST);      // add head_r to head

		level.add(head, BorderLayout.NORTH);     // add head to level

		Panel body = new Panel(new GridLayout(15,1,1,5));


			four_countries_btn       = new Button("4 Countries");
			body.add(four_countries_btn);
			four_countries_btn.addActionListener(e -> cards.show(pages, "four_countries"));

			Button four_flags_btn           = new Button("4 Flags");
			body.add(four_flags_btn);
			four_flags_btn.addActionListener(e -> cards.show(pages, "four_flags"));

			Button drag_and_drop_btn        = new Button("Drag and Drop");
			body.add(drag_and_drop_btn);
			drag_and_drop_btn.addActionListener(e -> cards.show(pages, "drag_and_drop"));

			Button six                      = new Button("Six");
			body.add(six);
			six.addActionListener(e -> cards.show(pages, "six"));

			Button colour_the_flags_h_btn   = new Button("Colour the flag (Hard)");
			body.add(colour_the_flags_h_btn);
			colour_the_flags_h_btn.addActionListener(e -> cards.show(pages, "colour_the_flags_h"));

			Button colour_the_flags_e_btn   = new Button("Colour the Flags (Easy)");
			body.add(colour_the_flags_e_btn);
			colour_the_flags_e_btn.addActionListener(e -> cards.show(pages, "colour_the_flags_e"));

			Button quiz_e_btn               = new Button("Quiz (Easy)");
			body.add(quiz_e_btn);
			quiz_e_btn.addActionListener(e -> cards.show(pages, "quiz_e"));

			Button quiz_h_btn               = new Button("Quiz (Hard)");
			body.add(quiz_h_btn);
			quiz_h_btn.addActionListener(e -> cards.show(pages, "quis_h"));

			Button mixed_questions_btn      = new Button("Mixed Questions");
			body.add(mixed_questions_btn);
			mixed_questions_btn.addActionListener(e -> cards.show(pages, "mixed_questions"));

			Button mixed_questions_btn      = new Button("Mixed Questions");
			body.add(mixed_questions_btn);

			Button one_minute_countries_btn = new Button("1 Minute : Countries");
			body.add(one_minute_countries_btn);
			one_minute_countries_btn.addActionListener(e -> cards.show(pages, "one_minute_countries"));

			Button one_minute_flags_btn     = new Button("1 Minute : Flags");
			body.add(one_minute_flags_btn);
			one_minute_flags_btn.addActionListener(e -> cards.show(pages, "one_minutes_flags"));

			Button maps_btn                 = new Button("Maps");
			body.add(maps_btn);
			maps_btn.addActionListener(e -> cards.show(pages, "maps"));

			Button flashcards_btn           = new Button("Flashcards");
			body.add(flashcards_btn);
			flashcards_btn.addActionListener(e -> cards.show(pages, "flashcards"));

			Button table_btn                = new Button("Table");
			body.add(table_btn);
			table_btn.addActionListener(e -> cards.show(pages, "table"));

			level.add(body, BorderLayout.CENTER);
		}
		return level;
	}

	public void setupMainPage()
	{
//  head panel
		Panel head = new Panel(new BorderLayout());

		Label l1 = new Label("Flags of The World");
		l1.setFont(new Font("Arial", Font.PLAIN, 20));

		head.add(l1, BorderLayout.WEST);

		Dimension sz = new Dimension(10,20);
		Button settings = new Button("Set...");
		settings.setSize(sz);

		Button brightness = new Button("Bright");
		brightness.setSize(sz);

		Button volume = new Button("Vol...");
		volume.setSize(sz);

		Panel head_right = new Panel(new GridLayout(1,3,5,1));
		head_right.add(volume);
		head_right.add(brightness);
		head_right.add(settings);

		head.add(head_right, BorderLayout.EAST);
//

//  body panel
		Panel body = new Panel(new GridLayout(6,2,5,5));

		Color buttons_color = new Color(0xEEEEEE);
		Color c = buttons_color;

		Button level1_btn = new Button("Level 1");
		level1_btn.setBackground(c);

		Button level2_btn = new Button("Level 2");
		level2_btn.setBackground(c);

		Button level3_btn = new Button("Level 3");
		level3_btn.setBackground(c);

		Button allflags_btn = new Button("All Falgs");
		allflags_btn.setBackground(c);

		Button europe_btn = new Button("Europe");
		europe_btn.setBackground(c);

		Button asia_btn = new Button("Asia");
		asia_btn.setBackground(c);

		Button north_america_btn = new Button("N. America");
		north_america_btn.setBackground(c);

		Button south_america_btn = new Button("S. America");
		south_america_btn.setBackground(c);

		Button africa_btn = new Button("Africa");
		africa_btn.setBackground(c);

		Button australia_and_oceania_btn = new Button("Australia \nand \nOceania");
		australia_and_oceania_btn.setBackground(c);

		Button capitals_btn = new Button("Capitals");
		capitals_btn.setBackground(c);

		body.add(level1_btn);
		body.add(level2_btn);
		body.add(level3_btn);
		body.add(allflags_btn);
		body.add(europe_btn);
		body.add(asia_btn);
		body.add(north_america_btn);
		body.add(south_america_btn);
		body.add(africa_btn);
		body.add(australia_and_oceania_btn);
		body.add(capitals_btn);
//

//  the main panel
		main_page = new Panel(new BorderLayout());
		main_page.add(head, BorderLayout.NORTH);
		main_page.add(body, BorderLayout.CENTER);
//
//		pages.add(main_page, "main");

		level1_btn.addActionListener(e -> cards.show(pages, "level1"));
		level2_btn.addActionListener(e -> cards.show(pages, "level2"));
		level3_btn.addActionListener(e -> cards.show(pages, "level3"));
		allflags_btn.addActionListener(e -> cards.show(pages, "all_flags"));
		europe_btn.addActionListener(e -> cards.show(pages, "europe"));
		asia_btn.addActionListener(e -> cards.show(pages, "asia"));
		north_america_btn.addActionListener(e -> cards.show(pages, "north_america"));
		south_america_btn.addActionListener(e -> cards.show(pages, "south_america"));
		africa_btn.addActionListener(e -> cards.show(pages, "africa"));
		australia_and_oceania_btn.addActionListener(e -> cards.show(pages, "australia_and_oceania"));
		capitals_btn.addActionListener(e -> cards.show(pages, "capitals"));


		pages.add(main_page, "main");

	}

	public static void main(String[] argv)
	{
		Main m = new Main();
		try
		{ m.window.setVisible(true); }
		catch(Exception e) { System.out.println(e.getMessage()); }
	}
}
