import java.awt.Color;
import java.awt.Point;

/**
 * 
 * @author Trevor Hosek
 * @version 1.0
 * 3/6/20
 * CSCI-C212
 * 
 * Class for creating and drawing Hexagons.
 *
 */

public class Hexagon extends Polygon
{
	private final static int NUM_SIDES = 6;
	public Hexagon(Color fillColor, Color borderColor, Point[] points)
	{
		super(fillColor, borderColor, points, NUM_SIDES);
	}

	public Hexagon(Color fillColor, Point[] points)
	{
		super(fillColor, points, NUM_SIDES);
	}

	public Hexagon(Point[] points)
	{
		super(points, NUM_SIDES);
	}
}
