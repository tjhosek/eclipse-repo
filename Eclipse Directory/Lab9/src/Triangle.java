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
 * Class for creating and drawing Triangles.
 *
 */

public class Triangle extends Shape
{
	private final int N_POINTS = 3;
	private Point[] points = new Point[N_POINTS];
	
	public Triangle(Color fillColor, Color borderColor, Point[] points)
	{
		super(fillColor, borderColor, points[0].x, points[0].y);
		if(points.length == N_POINTS)
		{
			this.points = points;
		}
	}

	public Triangle(Color fillColor, Point[] points)
	{
		super(fillColor, points[0].x, points[0].y);
		if(points.length == N_POINTS)
		{
			this.points = points;
		}
	}

	public Triangle(Point[] points)
	{
		super(points[0].x, points[0].y);
		if(points.length == N_POINTS)
		{
			this.points = points;
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
			this.points[i].x = this.points[i].x - shift;
		}
	}
	
	@Override
	public void setY(int y)
	{
		int shift = this.points[0].y - y;
		this.points[0].y = y;
		for(int i = 1; i < this.points.length; i++)
		{
			this.points[i].y = this.points[i].y - shift;
		}
	}
	
	@Override
	double getArea()
	{
		Point a = this.points[0];
		Point b = this.points[1];
		Point c = this.points[2];
		double area = Math.abs((a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y))/2);
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
