/**
 * 
 * @author Trevor Hosek
 * @version 1.0
 * 2/28/20
 * CSCI-C212
 * 
 * A class for managing complex numbers. Methods that accept the object type can accept the StandardComplex or PolarComplex types.
 *
 */

public class StandardComplex
{
	private double realPart;
	private double imaginaryPart;
	
	public StandardComplex()
	{
		this.realPart = 0;
		this.imaginaryPart = 0;
	}

	/**
	 * @param realPart
	 * @param imaginaryPart
	 */
	public StandardComplex(double realPart, double imaginaryPart)
	{
		super();
		this.realPart = realPart;
		this.imaginaryPart = imaginaryPart;
	}

	/**
	 * @return the realPart
	 */
	public double getRealPart()
	{
		return realPart;
	}

	/**
	 * @param realPart the realPart to set
	 */
	public void setRealPart(double realPart)
	{
		this.realPart = realPart;
	}

	/**
	 * @return the imaginaryPart
	 */
	public double getImaginaryPart()
	{
		return imaginaryPart;
	}

	/**
	 * @param imaginaryPart the imaginaryPart to set
	 */
	public void setImaginaryPart(double imaginaryPart)
	{
		this.imaginaryPart = imaginaryPart;
	}

	@Override
	public String toString()
	{
		return "(" + realPart + ", " + imaginaryPart + "i)";
	}
	
	public StandardComplex getConjugate()
	{
		return new StandardComplex(this.realPart, -this.imaginaryPart);
	}
	
	public PolarComplex getPolarComplex()
	{
		double r = Math.sqrt(Math.pow(realPart, 2.0) + Math.pow(imaginaryPart, 2.0));
		double theta = Math.atan2(realPart, imaginaryPart);
		return new PolarComplex(r, theta);
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
		PolarComplex polarComplex = new PolarComplex();
		StandardComplex other;
		if (getClass() == obj.getClass())
		{
			other = (StandardComplex) obj;
		}
		else if (obj.getClass() == polarComplex.getClass())
		{
			polarComplex = (PolarComplex) obj;
			other = polarComplex.getStandardComplex();
		}
		else 
		{
			return false;
		}
		if (imaginaryPart != other.getImaginaryPart())
		{
			return false;
		}
		if (realPart != other.getRealPart())
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
	public StandardComplex add(Object other)
	{
		StandardComplex adder;
		if(other.getClass() != getClass())
		{
			PolarComplex polarOther = (PolarComplex) other;
			adder = polarOther.getStandardComplex();
		}
		else
		{
			adder = (StandardComplex) other;
		}
		double real = this.getRealPart() + adder.getRealPart();
		double imaginary = this.getImaginaryPart() + adder.getImaginaryPart();
		
		StandardComplex sum = new StandardComplex(real, imaginary);
		return sum;
	}
	
	/**
	 * Subtracts the given Complex number from this complex number.
	 * @param other the complex number to subtract from this one
	 * @return the difference between the two complex numbers
	 */
	public StandardComplex subtract(Object other)
	{
		StandardComplex subtractor;
		if(other.getClass() != getClass())
		{
			PolarComplex polarOther = (PolarComplex) other;
			subtractor = polarOther.getStandardComplex();
		}
		else
		{
			subtractor = (StandardComplex) other;
		}
		double real = this.getRealPart() - subtractor.getRealPart();
		double imaginary = this.getImaginaryPart() - subtractor.getImaginaryPart();
		
		StandardComplex difference = new StandardComplex(real, imaginary);
		return difference;
	}
	
	/**
	 * Multiplies the two complex numbers.
	 * @param other the number to multiply to this one
	 * @return the product of the two complex numbers
	 */
	public StandardComplex multiply(Object other)
	{
		StandardComplex multiplier;
		if(other.getClass() != getClass())
		{
			PolarComplex polarOther = (PolarComplex) other;
			multiplier = polarOther.getStandardComplex();
		}
		else
		{
			multiplier = (StandardComplex) other;
		}
		double real = this.getRealPart() * multiplier.getRealPart() - this.getImaginaryPart() * multiplier.getImaginaryPart();
		double imaginary = this.getRealPart() * multiplier.getRealPart() + this.getImaginaryPart() * multiplier.getImaginaryPart();
		
		StandardComplex product = new StandardComplex(real, imaginary);
		return product;
	}
	
	/**
	 * Divides the two complex numbers
	 * @param other the number to divide to this one
	 * @return the result of the division of the two complex numbers
	 */
	public StandardComplex divide(Object other)
	{
		StandardComplex divisor;
		if(other.getClass() != getClass())
		{
			PolarComplex polarOther = (PolarComplex) other;
			divisor = polarOther.getStandardComplex();
		}
		else
		{
			divisor = (StandardComplex) other;
		}
		double denominator = Math.pow(divisor.getRealPart(), 2) + Math.pow(divisor.getImaginaryPart(),  2);
		
		if (denominator != 0)
		{
			double newRealPart = (this.getRealPart() * divisor.getRealPart() + this.getImaginaryPart() * divisor.getImaginaryPart()) / (Math.pow(divisor.getRealPart(), 2) + Math.pow(divisor.getImaginaryPart(),  2));
			double newImaginaryPart = (this.getImaginaryPart() * divisor.getRealPart() - this.getRealPart() * divisor.getImaginaryPart()) / (Math.pow(divisor.getRealPart(), 2) + Math.pow(divisor.getImaginaryPart(),  2));
			StandardComplex fraction = new StandardComplex(newRealPart, newImaginaryPart);
			return fraction;
		}
		else
		{
			System.out.println("Error: Division by 0.");
		}
		return new StandardComplex();
	}
}
