package main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class RectangleComponent extends JComponent 
{
	
	final int SMALL_BOX_SIZE = 40;
	final int CIRCLE_SIZE = 60;
	final int BIG_BOX_SIZE = 80;
	final int CENTER_X = 150;
	final int CENTER_Y = 200;
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		Rectangle smallBox = new Rectangle(CENTER_X - SMALL_BOX_SIZE/2, CENTER_Y - SMALL_BOX_SIZE/2, SMALL_BOX_SIZE, SMALL_BOX_SIZE);
		Ellipse2D circle =  new Ellipse2D.Double(CENTER_X - CIRCLE_SIZE/2, CENTER_Y - CIRCLE_SIZE/2, CIRCLE_SIZE, CIRCLE_SIZE);
		Rectangle bigBox = new Rectangle(CENTER_X - BIG_BOX_SIZE/2, CENTER_Y - BIG_BOX_SIZE/2, BIG_BOX_SIZE, BIG_BOX_SIZE);
		g2.draw(smallBox);
		g2.draw(circle);
		g2.draw(bigBox);
	}

}
