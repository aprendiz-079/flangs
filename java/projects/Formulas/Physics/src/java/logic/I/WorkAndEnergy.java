

package Formulas.Physics.src.logic;


import java.lang.Math;

private class WorkAndEnergy
{
	private static final double gravity = Constants.gravity;

	private class WorkConstantForce
	{// W = F * d * cos(theta)

		private double getWork
		(double force, double distance, int degree)
		{ return (force * distance * Math.cos(degree));}

		private double getForce
		(double work, double distance, int degree)
		{ return (work / (distance * Math.cos(degree))); }

		private double getDistance
		(double work, double force, double degree)
		{ return (work / (force * Math.cos(degree))); }

		private double getDegree
		(double work, double force, double distance)
		{ return Math.acos( (work / (force * distance)) ); }
	}

	private class KineticEnergy
	{// E_c = (1/2) * m * v^2

		private double getEnergy
		(double mass, double velocity)
		{ return ( (mass * Math.pow(velocity, 2))/2 ); }

		private double getMass
		(double energy, double velocity)
		{ return ( 2 * (energy * Math.pow(velocity, 2)) ); }

		private double getVelocity
		(double energy, double mass)
		{ return Math.sqrt( 2 * (energy / mass) ); }
	}

	private class GravitationalPotentialEnergy
	{// E_g = m * g * h

		private double getEnergy
		(double mass, double height)
		{ return (mass * gravity * height); }

		private double getMass
		(double energy, double height)
		{ return (energy / (height * gravity)); }

		private double getHeight
		(double energy, double mass)
		{ return (energy / (mass * gravity)); }
	}

	private class ElasticPotentialEnergy
	{// E_e = (1/2) * k * x^2

		private double getEnergy
		(double coeficient, double distance)
		{ return ( (coeficient * Math.pow(distance, 2))/2 ); }

		private double getCoeficient
		(double energy, double distance)
		{ return ( 2*(energy / Math.pow(distance, 2)) ); }

		private double getDistance
		(double energy, double coeficient)
		{ return ( Math.sqrt( 2*(energy/coeficient) ) ); }
	}

	private class WorkEnergyTheorem
	{// W_total = K - K_0
	// W_total = F * D = (1/2)* m * (v^2 - v_0^2)
		private double getWork
		(double mass, double finalVelocity, double initialVelocity)
		{ return (0.5 * mass * (Math.pow(finalVelocity, 2) - Math.pow(initialVelocity, 2))); }

		private double getMass
		(double work, double finalVelocity, double initialVelocity)
		{ return ( (2*work) / (Math.pow(finalVelocity, 2) - Math.pow(initialVelocity, 2))); }

		private double getFinalVelocity
		(double work, double mass, double initialVelocity)
		{ return ( (2 * work/mass) + Math.pow(initialVelocity, 2) ); }

		private double getInitialVelocity
		(double work, double mass, double finalVelocity)
		{ return ( -(2 * work/mass) + Math.pow(finalVelocity, 2)); }
	}

	private class ConservationOfMechanicalEnergy
	{// E_m = E_c + E_p
	// Elastic: (1/2) * m * v^2 + (1/2) * k * x^2
	// Gravitational: (1/2) * m * v^2 + m * g * h

		private double getMechanicalEnergy // E_m = E_c + E_p(e|g)
		(double kineticEnergy, double potentialEnergy)
		{ return (kineticEnergy + potentialEnergy); }

		private double getKineticEnergy // E_c = E_m - E_p(e|g)
		(double mechanicalEnergy, double potentialEnergy)
		{ return (mechanicalEnergy - potentialEnergy); }


		private double getPotentialEnergy // E_p(e|g) = E_m - E_C
		(double mechanicalEnergy, double potentialEnergy)
		{ return (mechanicalEnergy - potentialEnergy); }


		private class GravitationalEnergy
		{// E_g = E_m - E_c
		//  E_g = (1/2) * g * m * h
			private double getMass // m = 2E_m / ( (g * h) + v^2 )
			(double mechanicalEnergy, double height, double velocity)
			{return (2*mechanicalEnergy / ((gravity * height) + Math.pow(velocity, 2)) );}

			private double getHeight // h = (2E-M / gm) - (v^2/g)
			(double mechanicalEnergy, double mass, double velocity)
			{ return ( ((2 * mechanicalEnergy) / (gravity * mass)) - (Math.pow(velocity, 2)/gravity) ); }

//    get the velovity from kinetic energy by gravitational energy
			private double getVelocity // v = ( (2E_m/m) - (gh) )^(1/2)
			(double mechanicalEnergy, double mass, double height)
			{ return ( Math.sqrt( ((2 * mechanicalEnergy) - (gravity * height)) / mass) ); }
		}

		private class ElasticEnergy
		{// E_e = E_m - E_c
		//  E_e = (1/2) * k * x^2

			private double getElasticCoeficient // k = (2E_m/x^2) - (mv^2/x^2)
			(double mechanicalEnergy, double mass, double velocity, double distance)
			{ return (((2*mechanicalEnergy) - (mass * Math.pow(velocity, 2))) / Math.pow(distance,2)); }

			private double getDistance // x = ((2E_mk - mv^2)/h)^(1/2)
			(double mechanicalEnergy, double height, double mass, double velocity)
			{ return (Math.sqrt(((2 * mechanicalEnergy)-(mass * Math.pow(velocity, 2)))/height)); }

			private double getVelocity // v = ((2E_m - k*v^2)/m)^(1/2)
			(double mechanicalEnergy, double mass, double coeficient, double distance)
			{ return (Math.sqrt((2*mechanicalEnergy/mass)-(coeficient*distance*distance))); }
		}
	}
}
