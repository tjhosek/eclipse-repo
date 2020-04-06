import java.awt.Color;
import java.awt.Point;

/**
 * 
 * @author Trevor Hosek
 * @version 1.0
 * 3/6/20
 * CSCI-C212
 * 
 * Class for creating and drawing Pentagons.
 *
 */

public class Pentagon extends Polygon
{
	private final static int NUM_SIDES = 5;
	public Pentagon(Color fillColor, Color borderColor, Point[] points)
	{
		super(fillColor, borderColor, points, NUM_SIDES);
	}

	public Pentagon(Color fillColor, Point[] points)
	{
		super(fillColor, points, NUM_SIDES);
	}

	public Pentagon(Point[] points)
	{
		super(points, NUM_SIDES);
	}

}
