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
 * Class for creating and drawing Polygons.
 *
 */
public class Polygon extends Shape
{
	Point[] points;
	
	public Polygon(Color fillColor, Color borderColor, Point[] points)
	{
		super(fillColor, borderColor, points[0].x, points[0].y);
		this.points = points;
	}

	public Polygon(Color fillColor, Point[] points)
	{
		super(fillColor, points[0].x, points[0].y);
		this.points = points;
	}

	public Polygon(Point[] points)
	{
		super(points[0].x, points[0].y);
		this.points = points;
	}
	
	/**
	 * @param fillColor
	 * @param borderColor
	 * @param x
	 * @param y
	 * @param points
	 */
	protected Polygon(Color fillColor, Color borderColor, Point[] points, int numPoints)
	{
		super(fillColor, borderColor, points[0].x, points[0].y);
		if(points.length == numPoints)
		{
			this.points = points;
		}
		else
		{
			this.points = new Point[numPoints];
		}
	}

	/**
	 * @param fillColor
	 * @param x
	 * @param y
	 * @param points
	 */
	protected Polygon(Color fillColor, Point[] points, int numPoints)
	{
		super(fillColor, points[0].x, points[0].y);
		if(points.length == numPoints)
		{
			this.points = points;
		}
		else
		{
			this.points = new Point[numPoints];
		}
	}

	/**
	 * @param x
	 * @param y
	 * @param points
	 */
	protected Polygon(Point[] points, int numPoints)
	{
		super(points[0].x, points[0].y);
		if(points.length == numPoints)
		{
			this.points = points;
		}
		else
		{
			this.points = new Point[numPoints];
		}
	}

	/**
	 * @return the points
	 */
	public Point[] getPoints()
	{
		return points;
	}

	/**
	 * @param points the points to set
	 */
	public void setPoints(Point[] points)
	{
		this.points = points;
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
		a = this.points[this.points.length - 1];
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
		{
			Graphics2D g2D = (Graphics2D) g;
			int[] xPoints = new int[this.points.length];
			int[] yPoints = new int[this.points.length];
			for(int i = 0; i < this.points.length; i++)
			{
				xPoints[i] = this.points[i].x;
				yPoints[i] = this.points[i].y;
			}
			g2D.setColor(getBorderColor());
			g2D.drawPolygon(xPoints, yPoints, this.points.length);
			g2D.setColor(getFillColor());
			g2D.fillPolygon(xPoints, yPoints, this.points.length);
		}
	}

}
