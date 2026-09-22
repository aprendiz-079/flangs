
import javax.swing.JOptionPane;


public class Vehicle
{
	private String plate;
	private int year;


	public Vehicle()
	{ this("",0); }

	public Vehicle(String plate, int year)
	{
		this.plate = plate;
		this.year = year;
	}

	public String getPlate()
	{ return plate; }

	public int getYear()
	{ return year; }

	public void setPlane(String pane)
	{ this.plate = plate; }

	public void setYear(int year)
	{ this.year = year; }

	public void setYear(String year)
	{ this.year = Integer.parseInt(year); }

	public void printData()
	{
		String s = "Vehicle Data:\n\n" + 
		           "Plate"
	}
}
