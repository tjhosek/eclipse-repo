import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
/**
 * 
 * @author Trevor Hosek
 * @version 1.0
 * CSCI-212
 * 2/21/20
 *
 */

/*
 * Draws a checkerboard grid of the given size
 */

public class BoxComponent extends JComponent
{
	private int size;
	private int dimension;
	
	final static int N_POINTS = 3;
	
	final static Color COLOR_1 = Color.BLACK;
	final static Color COLOR_2 = Color.WHITE;
	
	public BoxComponent(int size, int squares)
	{
		this.size = size;
		this.dimension = size * squares;
	}
	
	public void paintComponent(Graphics g)
	{
		/**
		 * Draws a checkerboard
		 */
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(COLOR_1);
		
		for(int y = 0; y < dimension; y += size)
		{
			for(int x = 0; x < dimension; x += size)
			{
				// Reinitializing the point arrays for the current triangle
				int[] triangle1XPoints = {x, x, x + size};
				int[] triangle1YPoints = {y, y + size, y + size};
				int[] triangle2XPoints = {x, x + size, x + size};
				int[] triangle2YPoints = {y, y, y + size};
				
				// Drawing and filling the triangles
				g2d.drawPolygon(triangle1XPoints, triangle1YPoints, N_POINTS);
				g2d.fillPolygon(triangle1XPoints, triangle1YPoints, N_POINTS);
				g2d.drawPolygon(triangle2XPoints, triangle2YPoints, N_POINTS);
				g2d.fillPolygon(triangle2XPoints, triangle2YPoints, N_POINTS);
				
				// Alternating the color
				if(g2d.getColor() == COLOR_1)
				{
					g2d.setColor(COLOR_2);
				}
				else
				{
					g2d.setColor(COLOR_1);
				}
			}
			
			// After each row the color should stay the same as the last cell
			if(g2d.getColor() == COLOR_1)
			{
				g2d.setColor(COLOR_2);
			}
			else
			{
				g2d.setColor(COLOR_1);
			}
		}
		
		
	}
}
