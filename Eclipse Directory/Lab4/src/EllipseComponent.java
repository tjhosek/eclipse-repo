import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;

/**
 * 
 * @author Trevor Hosek
 * @version 1.0
 * C212
 *
 */

/*
 * Extension class on JComponent that draws the Audi logo
 */

public class EllipseComponent extends JComponent
{
	final int OUTER_RING_RADIUS = 50;	// Radius of the outer ring of each circle
	final int INNER_RING_RADIUS = 40;	// Radius of the inner ring of each circle
	final int RING_Y = 0;				// Y value of every ring
	final int RING_1_X = 0;				// X value of the first ring
	final int RING_SPACING = 30;		// Spacing between each ring. In this case, higher value means closer together.
	public void paintComponent(Graphics g)
	{
		/**
		 * Draws the Audi logo with various colors
		 */
		Graphics2D g2D = (Graphics2D) g;
		
		//Defining inferred ring values
		int ring2X = OUTER_RING_RADIUS * 2 - RING_SPACING + RING_1_X;
		int ring3X = OUTER_RING_RADIUS * 2 - RING_SPACING + ring2X;
		int ring4X = OUTER_RING_RADIUS * 2 - RING_SPACING + ring3X;
		//Defining the areas for each ring
		Area ring1 = ring(RING_1_X, RING_Y, INNER_RING_RADIUS, OUTER_RING_RADIUS);
		Area ring2 = ring(ring2X, RING_Y, INNER_RING_RADIUS, OUTER_RING_RADIUS);
		Area ring3 = ring(ring3X, RING_Y, INNER_RING_RADIUS, OUTER_RING_RADIUS);
		Area ring4 = ring(ring4X, RING_Y, INNER_RING_RADIUS, OUTER_RING_RADIUS);
		//Drawing and filling each ring
		g2D.setColor(Color.MAGENTA);
		g2D.draw(ring1);
		g2D.fill(ring1);
		g2D.setColor(Color.RED);
		g2D.draw(ring2);
		g2D.fill(ring2);
		g2D.setColor(Color.CYAN);
		g2D.draw(ring3);
		g2D.fill(ring3);
		g2D.setColor(Color.PINK);
		g2D.draw(ring4);
		g2D.fill(ring4);
	}
	
	private static Area ring(int x, int y, int innerRadius, int outerRadius)
	{
		/**
		 * Creates an area which represents a ring. This is used to prevent the white space from the ellipses from blocking out parts of the rings that should be shown
		 * Inputs: 	int x, int y - Coordinates for the upper left corner of the ring
		 * 			int innerRadius - the radius of the inside of the ring
		 * 			int outerRadius - the radius of the outside of the ring		 
		 * */
		
		//Establishing the proper coordinates of the inner circle
		int innerX = x + outerRadius - innerRadius;
		int innerY = y + outerRadius - innerRadius;
		//Creating the two circles and turning them into Areas
		Ellipse2D innerCircle = new Ellipse2D.Double(innerX,innerY,innerRadius*2,innerRadius*2);
		Ellipse2D outerCircle = new Ellipse2D.Double(x,y,outerRadius*2,outerRadius*2);
		Area ring = new Area(outerCircle);
		Area innerRing = new Area(innerCircle);
		//Subtracting the inner circle from the outer circle
		ring.subtract(innerRing);
		return ring;
	}
}
