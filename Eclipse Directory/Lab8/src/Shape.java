import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * 
 * @author Trevor Hosek
 * @version 1.0
 * 3/6/20
 * CSCI-C212
 * 
 * Class for creating and drawing different shapes.
 *
 */

public abstract class Shape
{
	private Color fillColor;
	private Color borderColor;
	private boolean isFilled;
	private Point location;
	private int dx;
	private int dy;
	
	
	/**
	 * @param fillColor
	 * @param borderColor
	 * @param x
	 * @param y
	 */
	public Shape(Color fillColor, Color borderColor, int x, int y)
	{
		this.fillColor = fillColor;
		this.borderColor = borderColor;
		this.isFilled = true;
		this.location = new Point(x, y);
	}
	
	/**
	 * @param fillColor
	 * @param x
	 * @param y
	 */
	public Shape(Color fillColor, int x, int y)
	{
		this.fillColor = fillColor;
		this.borderColor = Color.black;
		this.isFilled = true;
		this.location = new Point(x, y);
	}

	/**
	 * @param x
	 * @param y
	 */
	public Shape(int x, int y)
	{
		this.fillColor = Color.white;
		this.borderColor = Color.black;
		this.isFilled = true;
		this.location = new Point(x, y);
	}

	/**
	 * @return the fillColor
	 */
	public Color getFillColor()
	{
		return fillColor;
	}

	/**
	 * @param fillColor the fillColor to set
	 */
	public void setFillColor(Color fillColor)
	{
		this.fillColor = fillColor;
	}

	/**
	 * @return the borderColor
	 */
	public Color getBorderColor()
	{
		return borderColor;
	}

	/**
	 * @param borderColor the borderColor to set
	 */
	public void setBorderColor(Color borderColor)
	{
		this.borderColor = borderColor;
	}

	/**
	 * @return the location
	 */
	public Point getLocation()
	{
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(Point location)
	{
		this.location = location;
	}
	
	/**
	 * gets the x value of this shape's position
	 * @return the x position of the shape
	 */
	public int getX()
	{
		return this.location.x;
	}
	
	/**
	 * sets the x value of this shape's position
	 * @param x the new x value of the shape
	 */
	public void setX(int x) 
	{
		this.location.x = x;
	}
	
	/**
	 * gets the y value of this shape's position
	 * @return the y position of the shape
	 */
	public int getY()
	{
		return this.location.y;
	}
	
	/**
	 * sets the y value of this shape's position
	 * @param y the new y value of the shape
	 */
	public void setY(int y) 
	{
		this.location.y = y;
	}
	
	/**
	 * @return the dx
	 */
	public int getDx()
	{
		return dx;
	}

	/**
	 * @param dx the dx to set
	 */
	public void setDx(int dx)
	{
		this.dx = dx;
	}

	/**
	 * @return the dy
	 */
	public int getDy()
	{
		return dy;
	}

	/**
	 * @param dy the dy to set
	 */
	public void setDy(int dy)
	{
		this.dy = dy;
	}

	/**
	 * Checks to see if the shape is filled
	 * @return true if fill color is white, false otherwise
	 */
	public boolean isFilled()
	{
		return this.fillColor == Color.white;
	}
	
	/**
	 * Moves the location by dx and dy
	 * @param dx the change in the x position of the shape
	 * @param dy the change in the y position of the shape
	 */
	public void moveLocation(int dx, int dy)
	{
		this.setX(this.getX() + dx);
		this.setY(this.getY() + dy);
	}
	
	/**
	 * Gets the area of the shape
	 * @return the area as a double
	 */
	abstract double getArea();
	
	/**
	 * Gets the perimeter of the shape
	 * @return the perimeter as a double
	 */
	abstract double getPerimeter();
	
	/**
	 * Draws the shape
	 * @param g the Graphics used to draw the shape
	 */
	abstract void draw(Graphics g);
}
