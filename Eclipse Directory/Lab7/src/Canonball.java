import java.awt.Point;
import java.util.ArrayList;

/**
 * 
 * @author Trevor Hosek
 * @version 1.0
 * 2/28/2020
 * CSCI-C212
 * 
 * A canonball that follows a specific trajectory
 *
 */

public class Canonball
{
	private final double GRAVITY = 9.81;	// The value used for gravity
	private double xPosition;				// x position of the canonball
	private double yPosition;				// y position of the canonball
	private double xVelocity;				// x velocity of the canonball
	private double yVelocity;				// y velocity of the canonball
	
	/**
	 * Creates a canonball at x position, with its yPosition and velocity variables being all set to 0
	 * 
	 * @param xPosition the starting x position of the canonball
	 */
	public Canonball(double xPosition)
	{
		this.xPosition = xPosition;
		this.yPosition = 0;
		this.xVelocity = 0;
		this.yVelocity = 0;
	}
	
	/**
	 * Moves the canonball to the next position after an interval of deltaSec and updates the yVelocity to account for gravity.
	 * 
	 * @param deltaSec the time in which the canonball moves.
	 */
	public void move(double deltaSec)
	{
		this.xPosition = this.xPosition + this.xVelocity * deltaSec;
		this.yPosition = this.yPosition + this.yVelocity * deltaSec - (GRAVITY * Math.pow(deltaSec, 2.0) / 2.0);
		this.yVelocity = this.yVelocity - GRAVITY * deltaSec;
	}
	
	/**
	 * Returns the current position of the canonball as a Point object.
	 * 
	 * @return the position of the canonball as a Point object.
	 */
	public Point getLocation()
	{
		Point position = new Point((int) Math.round(this.xPosition), (int) Math.round(this.yPosition));
		return position;
	}
	
	/**
	 * Returns a series of points representing the path of the canonball.
	 * 
	 * @param alpha the initial launch angle of the canonball.
	 * @param v the initial velocity of the canonball.
	 * @param deltaSec the interval at which the positions of the canonball will be represented.
	 * @return An ArrayList of points that represents the path of the canonball.
	 */
	public ArrayList<Point> shoot(double alpha, double v, double deltaSec)
	{
		this.xVelocity = v * Math.cos(alpha);
		this.yVelocity = v * Math.sin(alpha);
		ArrayList<Point> positions = new ArrayList<>();
		positions.add(getLocation());
		do
		{
			move(deltaSec);
			positions.add(getLocation());
		} while(this.yPosition > 0);
		return positions;
	}
}
