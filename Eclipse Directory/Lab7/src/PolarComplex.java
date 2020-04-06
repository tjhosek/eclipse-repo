/**
 * 
 * @author Trevor Hosek
 * @version 1.0
 * 2/28/20
 * CSCI-C212
 * 
 * A class for managing polar complex numbers. Methods that accept the object type can accept the StandardComplex or PolarComplex types.
 *
 */

public class PolarComplex
{
	private double amplitude;
	private double angle;
	
	/**
	 * @param amplitude
	 * @param angle
	 */
	public PolarComplex(double amplitude, double angle)
	{
		super();
		this.amplitude = amplitude;
		this.angle = angle;
	}

	public PolarComplex()
	{
		this.amplitude = 0;
		this.angle = 0;
	}

	/**
	 * @return the amplitude
	 */
	public double getAmplitude()
	{
		return amplitude;
	}

	/**
	 * @param amplitude the amplitude to set
	 */
	public void setAmplitude(double amplitude)
	{
		this.amplitude = amplitude;
	}

	/**
	 * @return the angle
	 */
	public double getAngle()
	{
		return angle;
	}

	/**
	 * @param angle the angle to set
	 */
	public void setAngle(double angle)
	{
		this.angle = angle;
	}

	@Override
	public String toString()
	{
		return "(" + amplitude + ", " + angle + ")";
	}
	
	public PolarComplex getConjugate()
	{
		return new PolarComplex(amplitude, 360 - angle);
	}
	
	public StandardComplex getStandardComplex()
	{
		double a = amplitude * Math.cos(angle);
		double b = amplitude * Math.sin(angle);
		return new StandardComplex(a, b);
	}

	@Override
	public boolean equals(Object obj)
	{
		return isEquals(obj);
	}
	
	/**
	 * Returns whether or not the given object is equivalent to this object.
	 * @param obj the object being tested
	 * @return true if the objects are equivalent, false otherwise.
	 */
	public boolean isEquals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		StandardComplex standardComplex = new StandardComplex();
		PolarComplex other;
		if (getClass() == obj.getClass())
		{
			other = (PolarComplex) obj;
		}
		else if (obj.getClass() == standardComplex.getClass()) 
		{
			standardComplex = (StandardComplex) obj;
			other = standardComplex.getPolarComplex();
		}
		else
		{
			return false;
		}
		if (amplitude != other.getAmplitude())
		{
			return false;
		}
		if (angle != other.getAngle())
		{
			return false;
		}
		return true;
	}
	
	/**
	 * Adds the given Complex number to this complex number.
	 * @param other the complex number to add
	 * @return the sum of the two complex numbers
	 */
	public PolarComplex add(Object other)
	{
		PolarComplex adder;
		if(other.getClass() != getClass())
		{
			StandardComplex polarOther = (StandardComplex) other;
			adder = polarOther.getPolarComplex();
		}
		else
		{
			adder = (PolarComplex) other;
		}
		double newAmplitude = this.getAmplitude() + adder.getAmplitude();
		double newAngle = this.getAngle() + adder.getAngle();
		
		PolarComplex sum = new PolarComplex(newAmplitude, newAngle);
		return sum;
	}
	
	/**
	 * Subtracts the given Complex number from this complex number.
	 * @param other the complex number to subtract from this one
	 * @return the difference between the two complex numbers
	 */
	public PolarComplex subtract(Object other)
	{
		PolarComplex subtractor;
		if(other.getClass() != getClass())
		{
			StandardComplex polarOther = (StandardComplex) other;
			subtractor = polarOther.getPolarComplex();
		}
		else
		{
			subtractor = (PolarComplex) other;
		}
		double newAmplitude = this.getAmplitude() - subtractor.getAmplitude();
		double newAngle = this.getAngle() - subtractor.getAngle();
		
		PolarComplex difference = new PolarComplex(newAmplitude, newAngle);
		return difference;
	}
	
	/**
	 * Multiplies the two complex numbers.
	 * @param other the number to multiply to this one
	 * @return the product of the two complex numbers
	 */
	public PolarComplex multiply(Object other)
	{
		PolarComplex multiplier;
		if(other.getClass() != getClass())
		{
			StandardComplex polarOther = (StandardComplex) other;
			multiplier = polarOther.getPolarComplex();
		}
		else
		{
			multiplier = (PolarComplex) other;
		}
		double newAmplitude = this.getAmplitude() * multiplier.getAmplitude() - this.getAngle() * multiplier.getAngle();
		double newAngle = this.getAmplitude() * multiplier.getAmplitude() + this.getAngle() * multiplier.getAngle();
		
		PolarComplex product = new PolarComplex(newAmplitude, newAngle);
		return product;
	}
	
	/**
	 * Divides the two complex numbers
	 * @param other the number to divide to this one
	 * @return the result of the division of the two complex numbers
	 */
	public PolarComplex divide(Object other)
	{
		PolarComplex divisor;
		if(other.getClass() != getClass())
		{
			StandardComplex polarOther = (StandardComplex) other;
			divisor = polarOther.getPolarComplex();
		}
		else
		{
			divisor = (PolarComplex) other;
		}
		double newAmplitude = (this.getAmplitude() * divisor.getAmplitude() + this.getAngle() * divisor.getAngle()) / (Math.pow(divisor.getAmplitude(), 2) + Math.pow(divisor.getAngle(),  2));
		double newAngle = (this.getAngle() * divisor.getAmplitude() - this.getAmplitude() * divisor.getAngle()) / (Math.pow(divisor.getAmplitude(), 2) + Math.pow(divisor.getAngle(),  2));
		
		PolarComplex fraction = new PolarComplex(newAmplitude, newAngle);
		return fraction;
	}
}
