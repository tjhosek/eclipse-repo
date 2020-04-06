import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * 
 * @author Trevor Hosek
 * @version 1.0
 * 3/6/20
 * CSCI-C212
 * 
 * Class for creating and drawing Ovals.
 *
 */

public class Oval extends Shape
{
	private int height;
	private int width;

	public Oval(Color fillColor, Color borderColor, int x, int y, int height, int width)
	{
		super(fillColor, borderColor, x, y);
		this.height = height;
		this.width = width;
	}

	public Oval(Color fillColor, int x, int y, int height, int width)
	{
		super(fillColor, x, y);
		this.height = height;
		this.width = width;
	}

	public Oval(int x, int y, int height, int width)
	{
		super(x, y);
		this.height = height;
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

	@Override
	double getArea()
	{
		return Math.PI * this.height * this.width;
	}

	@Override
	double getPerimeter()
	{
		double approximation = Math.PI * (3 * (this.width + this.height) - Math.sqrt((3 * this.width + this.height) * (this.width + this.height * 3)));
		return approximation;
	}

	@Override
	void draw(Graphics g)
	{
		Graphics2D g2D = (Graphics2D) g;
		g2D.setColor(getBorderColor());
		g2D.drawOval(getX(), getY(), width, height);
		g2D.setColor(getFillColor());
		g2D.fillOval(getX(), getY(), width, height);

	}

}
