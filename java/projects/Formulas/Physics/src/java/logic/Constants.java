

package Formulas.Physics.src.logic;


import java.lang.Math;


public class Constants
{
	public enum Fundamentals
	{
		SPEED_LIGHT(299.729.458, "m/s"),
		PLANKS_CONSTANT(6.626e-34, "J*s"),
		UNIVERSAL_GRAVITATIONAL_CONSTANT(6.674e-11, "N*m^2 / kg^2"),
		ELEMENTARY_CHARGE(1.602e-19, "C"),
		ELECTRON_MASS(9.109e-31, "kg"),
		
		ACCELERATION_DUE_TO_GRAVITY_AT_THE_EARTH_SURFACE(9.8066499999999997853, "m/s^2"),

		Constatns(double value, String unit)
		{ this.value = value; this.unit = unit; }

		public double getValue() { return value; }
		public double getUnit() { return unit; }
	}

	public enum Electromagnetics
	{
		
	}
}
