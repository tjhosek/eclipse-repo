import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.JComponent;
/**
 * 
 * @author Trevor Hosek
 * @version 1.0
 * 2/28/2020
 * CSCI-212
 * 
 * Extension of JComponent that draws an ArrayList<Point> as a series of points on a graph
 *
 */
public class TrajectoryComponent extends JComponent
{
	private static final long serialVersionUID = 1L;
	private ArrayList<Point> trajectory;
	private int height;
	private final Color COLOR = Color.black;
	private final int DIAMETER = 6;
	
	public TrajectoryComponent(ArrayList<Point> trajectory, int height)
	{
		this.trajectory = trajectory;
		this.height = height;
	}
	
	public void paint(Graphics g)
	{
		Graphics2D g2D = (Graphics2D) g;
		g2D.setColor(COLOR);
		Ellipse2D circle;
		for(Point point : trajectory)
		{
			circle = new Ellipse2D.Double(point.getX(), this.height - point.getY(), DIAMETER, DIAMETER);
			g2D.draw(circle);
			g2D.fill(circle);
		}
	}
}
