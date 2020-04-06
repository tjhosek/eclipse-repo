import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 * 
 * @author Trevor Hosek
 * @version 1.0
 * 3/6/20
 * CSCI-C212
 * 
 * Class for creating and drawing Quadrilaterals.
 *
 */
public class Quadrilateral extends Shape
{
	protected static final int N_POINTS = 4;
	private Point[] points = new Point[N_POINTS];
	
	/**
	 * 
	 * @param fillColor Color to fill the quadrilateral with
	 * @param borderColor Color to surround the quadrilateral
	 * @param points the points that make up the quadrilateral. The first point in this list is the point that represents the quadrilateral's location.
	 */
	public Quadrilateral(Color fillColor, Color borderColor, Point[] points)
	{
		super(fillColor, borderColor, points[0].x, points[0].y);
		if(points.length == N_POINTS)
		{
			this.points = points;
		}
	}

	/**
	 * 
	 * @param fillColor Color to fill the quadrilateral with
	 * @param points the points that make up the quadrilateral. The first point in this list is the point that represents the quadrilateral's location.
	 */
	public Quadrilateral(Color fillColor, Point[] points)
	{
		super(fillColor, points[0].x, points[0].y);
		if(points.length == N_POINTS)
		{
			this.points = points;
		}
	}

	/**
	 * 
	 * @param points the points that make up the quadrilateral. The first point in this list is the point that represents the quadrilateral's location.
	 */
	public Quadrilateral(Point[] points)
	{
		super(points[0].x, points[0].y);
		if(points.length == N_POINTS)
		{
			this.points = points;
		}
	}

	// The following protected constructors are what are called by the Rectangle class in order to restrict what counts as a rectangle
	
	/**
	 * @param fillColor
	 * @param borderColor
	 * @param x
	 * @param y
	 */
	protected Quadrilateral(Color fillColor, Color borderColor, int x, int y, int height, int width)
	{
		super(fillColor, borderColor, x, y);
		this.points = getPointList(x, y, height, width);
	}

	/**
	 * @param fillColor
	 * @param x
	 * @param y
	 * @param points
	 */
	protected Quadrilateral(Color fillColor, int x, int y, int height, int width)
	{
		super(fillColor, x, y);
		this.points = getPointList(x, y, height, width);
	}

	/**
	 * @param x
	 * @param y
	 * @param points
	 */
	protected Quadrilateral(int x, int y, int height, int width)
	{
		super(x, y);
		this.points = getPointList(x, y, height, width);
	}

	/**
	 * Used to get a list of points for the Constructors that are called by the Rectangle class
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @return
	 */
	static private Point[] getPointList(int x, int y, int height, int width)
	{
		Point[] points = new Point[N_POINTS];
		points[0] = new Point(x, y);
		points[1] = new Point(x + width, y);
		points[2] = new Point(x + width, y + height);
		points[3] = new Point(x, y + height);
		return points;
	}
	
	/**
	 * @return the points
	 */
	public Point[] getPoints()
	{
		return points;
	}

	/**
	 * @param points the points to set. Must be of length 4 or it will not set the points.
	 */
	public void setPoints(Point[] points)
	{
		if(points.length == N_POINTS)
		{
			this.points = points;
		}
	}
	
	@Override
	public int getX()
	{
		return this.points[0].x;
	}
	
	@Override
	public int getY()
	{
		return this.points[0].y;
	}
	
	@Override
	public void setX(int x)
	{
		int shift = this.points[0].x - x;
		this.points[0].x = x;
		for(int i = 1; i < this.points.length; i++)
		{
			this.points[i].x -= shift;
		}
	}
	
	@Override
	public void setY(int y)
	{
		int shift = this.points[0].y - y;
		this.points[0].y = y;
		for(int i = 1; i < this.points.length; i++)
		{
			this.points[i].y -= shift;
		}
	}
	
	@Override
	double getArea()
	{
		double area = 0;
		Point a;
		Point b;
		for(int i = 0; i < this.points.length - 1; i++)
		{
			a = this.points[i];
			b = this.points[i + 1];
			area += (a.x + b.y - a.y * b.x);
		}
		a = this.points[N_POINTS - 1];
		b = this.points[0];
		area += (a.x + b.y - a.y * b.x);
		area = Math.abs(area/2);
		
		return area;
	}

	@Override
	double getPerimeter()
	{
		double perimeter = 0;
		for(int i = 0; i < this.points.length; i++)
		{
			if(i < this.points.length - 1)
			{
				perimeter += points[i].distance(points[i + 1]);
			}
			else
			{
				perimeter += points[i].distance(points[0]);
			}
		}
		return perimeter;
	}

	@Override
	void draw(Graphics g)
	{
		Graphics2D g2D = (Graphics2D) g;
		int[] xPoints = new int[N_POINTS];
		int[] yPoints = new int[N_POINTS];
		for(int i = 0; i < this.points.length; i++)
		{
			xPoints[i] = this.points[i].x;
			yPoints[i] = this.points[i].y;
		}
		g2D.setColor(getBorderColor());
		g2D.drawPolygon(xPoints, yPoints, N_POINTS);
		g2D.setColor(getFillColor());
		g2D.fillPolygon(xPoints, yPoints, N_POINTS);
	}

}
