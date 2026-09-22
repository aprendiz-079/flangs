

package Formulas.Physics.src.logic;

//import Formulas.Physics.src.gui.Cinematics_GUI.CinematicsMenu;


import java.lang.Math.sqrt;

public class Cinematics
{ { System.out.println("Cinematics initialized !"); }

	public static double acceleration = Constants.gravity;

	public static double getDelta
	(double finalValue, double initialValue)
	{ return (finalValue - initialValue); }

	public class MRU
	{// s = s_0 + vt
		public static double getFinalPosition
		(double initialPosition, double finalVelocity, double finalTemp)
		{ return (initialPosition + finalVelocity * finalTemp); } // allright

		public static double getInitialPosition
		(double finalPosition, double finalVelocity, double finalTemp)
		{ return (finalPosition - finalVelocity * finalTemp); } // allright

		public static double getFinalVelocity
		(double finalPosition, double initialPosition, double finalTemp)
		{ return ((finalPosition - initialPosition) / finalTemp); } // allright

		public static double getFinalTemp
		(double finalPosition, double initialPosition, double finalVelocity)
		{ return ((finalPosition - initialPosition) / finalVelocity); } // allright

		public static double getInitialVelocity()
		{ return 0; }

		public static double getInitialTemp()
		{ return 0; }
	}

	public class MUV
	{
		public class Moviment
		{// s = s_0 + v_0t + \frac{1}{2}at^2 
			public static double getFinalPosition
			(double initialPosition, double initialVelocity, double temp, 
			double acceleration)
			{ return 
(initialPosition - (initialVelocity * temp) - (acceleration * temp * temp)/2); }

			public static double getInitialPosition
			(double finalPosition, double initialVelocity, double temp, 
			double acceleration)
			{ return 
(finalPosition - (initialVelocity * temp) - (acceleration * temp * temp)/2); }

			public static double getInitialVelocity
			(double finalPosition, double initialPosition, double temp, 
			double acceleration)
			{ return 
( ((finalPosition - initialPosition) /temp) - (acceleration * temp/2) ); }

			public static double getAcceleration
			(double finalPosition, double initialPosition, double initialVelocity, 
			double temp)
			{ return 
((finalPosition - initialPosition - (initialVelocity * temp)) * 2 /(temp*temp)); }
		}

		public class Velocity
		{// v = v_0 + at
			public static double getFinalVelocity
			(double initialVelocity, double acceleration, double temp)
			{ return (initialVelocity + (acceleration * temp)); }

			public static double getInitialVelocity
			(double finalVelocity, double acceleration, double temp)
			{ return (finalVelocity - (acceleration * temp)); }

			public static double getAcceleration
			(double finalVelocity, double initialVelocity, double temp)
			{ return ((finalVelocity - initialVelocity) / temp); }

			public static double getTemp
			(double finalVelocity, double initialVelocity, double acceleration)
			{ return ((finalVelocity - initialVelocity)/acceleration); }
		}

		public class Torricelli
		{// v^2 = v_0^2 + 2a\Delta s
			public static double getFinalVelocity
			(double initialVelocity, double acceleration, 
			double finalPosition, double initialPosition)
			{ return 
(Math.sqrt(((initialVelocity*initialVelocity) + 2 * acceleration * (finalPosition - initialPosition)))); }

			public static double getInitialVelocity
			(double finalVelocity, double acceleration, 
			double finalPosition, double initialPosition)
			{ return 
(Math.sqrt(((finalVelocity*finalVelocity) - 2 * acceleration * (finalPosition - initialPosition)))); }

			public static double getAcceleration
			(double initialVelocity, double finalVelocity, 
			double finalPosition, double initialPosition)
			{ return 
( ((finalVelocity * finalVelocity) - (initialVelocity * initialVelocity) / (2 *(finalPosition - initialPosition)) ); }
		}

		public class FreeFall
		{// h = h_0 + v_0t - \frac{1}{2}gt^2

		//  s = s_0 + v_0t + \frac{1}{2}at^2
			public static double acceleration = Constants.gravity;

			public static double getFinalHeight
			(double initialHeight, double initialVelocity, double temp)
			{ return (MUV.Moviment.getFinalPosition
			(initialHeight, initialVelocity, temp, acceleration)); }

			public static double getInitialHeght
			(double finalHeight, double initialVelocity, double temp)
			{ return (MUV.Moviment.getInitialPosition
			(finalHeight, initialVelocity, temp, acceleration)); }

			public static double getInitialVelocity
			(double finalHeight, double initialHeight, double temp)
			{ return (MUV.Moviment.getInitialVelocity
			(finalHeight, initialHeight, temp, acceleration)); }

		}
	}
}
