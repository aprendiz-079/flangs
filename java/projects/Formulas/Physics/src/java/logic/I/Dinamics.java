

package Formulas.Physics.src.logic;

import Formulas.Physics.src.gui.*;


public class Dinamics extends PhysicsGUI
{
	{ System.out.println("Dinamics initialized !"); }

	private static final double gravity = Constants.gravity;

	Force force = new Force();
	WeightForce weight_force = new WeightForce();
	FrictionForce friction_force = new FrictionForce();
	ElasticForce elastic_force = new ElasticForce();

	private class Force
	{
		private double getForce
		(double mass, double acceleration)
		{ return (mass * acceleration); }

		private double getMass
		(double force, double acceleration)
		{ return (force / acceleration); }

		private double getAcceleration
		(double force, double mass)
		{ return (force / mass); }
	}

	private class WeightForce
	{
		private double getWeight(double mass)
		{ return (mass * gravity); }

		private double getMass(double weight)
		{ return (weight / gravity); }
	}

	private class FrictionForce
	{
		private double getForce
		(double coeficient, double normalForce)
		{ return (coeficient * normalForce); }

		private double getCoeficient
		(double force, double normalForce)
		{ return (force / normalForce); }

		private double getNormalForce
		(double force, double coeficient)
		{ return (force / coeficient); }
	}

	private class ElasticForce
	{
		private double getForce(
		double coeficient, double distance)
		{ return (-coeficient * distance); }

		private double getCoeficient
		(double force, double distance)
		{ return (force / distance); }

		private double getDistance
		(double force, double coeficient)
		{ return (force / coeficient); }
	}

/*
	public static void main(String[] argv)
	{
		Dinamics dinamics = new Dinamics();
//		Dinamics.Force force = dinamics.new Force();

//		System.out.println(force.getForce(80.0, gravity));
		System.out.println(dinamics.force.getForce(80.0, gravity));
	}*/
}
