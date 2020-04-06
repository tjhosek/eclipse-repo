import java.awt.Color;

/**
 * 
 * @author Trevor Hosek
 * @version 1.0
 * 3/6/20
 * CSCI-C212
 * 
 * Class for creating and drawing Squares.
 *
 */

public class Square extends Rectangle
{

	public Square(Color fillColor, Color borderColor, int x, int y, int sideLength)
	{
		super(fillColor, borderColor, x, y, sideLength, sideLength);
		// TODO Auto-generated constructor stub
	}

	public Square(Color fillColor, int x, int y, int sideLength)
	{
		super(fillColor, x, y, sideLength, sideLength);
		// TODO Auto-generated constructor stub
	}

	public Square(int x, int y, int sideLength)
	{
		super(x, y, sideLength, sideLength);
		// TODO Auto-generated constructor stub
	}

}
