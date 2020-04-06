import java.awt.Rectangle;

public class Square extends Rectangle
{

	public Square(int x, int y, int side)
	{
		super(x,y,side,side);
	}

	public double getArea()
	{
		return this.getHeight() * this.getWidth();
				
	}
}
