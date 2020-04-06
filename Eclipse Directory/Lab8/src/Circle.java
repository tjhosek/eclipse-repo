import java.awt.Color;

/**
 * 
 * @author Trevor Hosek
 * @version 1.0
 * 3/6/20
 * CSCI-C212
 * 
 * Class for creating and drawing Circles.
 *
 */

public class Circle extends Oval
{

	public Circle(Color fillColor, Color borderColor, int x, int y, int diameter)
	{
		super(fillColor, borderColor, x, y, diameter, diameter);
		// TODO Auto-generated constructor stub
	}

	public Circle(Color fillColor, int x, int y, int diameter)
	{
		super(fillColor, x, y, diameter, diameter);
		// TODO Auto-generated constructor stub
	}

	public Circle(int x, int y, int diameter)
	{
		super(x, y, diameter, diameter);
		// TODO Auto-generated constructor stub
	}

}
