import java.awt.Color;

/**
 * 
 * @author Trevor Hosek
 * @version 1.0
 * 3/6/20
 * CSCI-C212
 * 
 * Class for creating and drawing Rectangles.
 *
 */

public class Rectangle extends Quadrilateral
{
	private int width;
	private int height;
	
	public Rectangle(Color fillColor, Color borderColor, int x, int y, int width, int height)
	{
		super(fillColor, borderColor, x, y, width, height);
		this.width = width;
		this.height = height;
	}

	public Rectangle(Color fillColor, int x, int y, int width, int height)
	{
		super(fillColor, x, y, width, height);
		this.width = width;
		this.height = height;
	}

	public Rectangle(int x, int y, int width, int height)
	{
		super(x, y, width, height);
		this.width = width;
		this.height = height;
	}

	/**
	 * @return the width
	 */
	public int getWidth()
	{
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width)
	{
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight()
	{
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height)
	{
		this.height = height;
	}

}
