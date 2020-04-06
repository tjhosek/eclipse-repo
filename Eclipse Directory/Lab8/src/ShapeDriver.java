/**
 * 
 * @author Trevor Hosek
 * @version 1.0
 * 3/6/20
 * CSCI-C212
 * 
 * Creates a bunch of random shapes over the course of 20 seconds. No shape is created more than 10 times.
 *
 */
 
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Driver program for random shape generator app
 * NOTE: You are encouraged to experiment and try out various approaches
 * The comments given here are just guidelines to get you started 
 * Possibly, this problem can be finished in many ways.
 */
public class ShapeDriver extends JPanel implements ActionListener {

    // Panel constants
    public final int FRAME_WIDTH = 600;
    public final int FRAME_HEIGHT = 600;
    
    // Shape Bounds
    private final int SIZE_LOWER_BOUND = 5;
    private final int SIZE_UPPER_BOUND = 50;
    
    // Size Constants
    private final int HEXAGON_SIDES = 6;
    private final int PENTAGON_SIDES = 5;
    private final int QUADRILATERAL_SIDES = 4;
    private final int TRIANGLE_SIDES = 3;
    private final int POLYGON_UPPER_BOUND = 10;
    private final int POLYGON_LOWER_BOUND = 3;

    private Random random;
    
    private enum PossibleShape
    {
    	CIRCLE, HEXAGON, OVAL, PENTAGON, POLYGON, QUADRILATERAL, RECTANGLE, SQUARE, TRIANGLE
    };
    
    private ArrayList<PossibleShape> selection;
    
    private ArrayList<Shape> shapes;
    
    private int[] counts;
	
	// Need some data structure here to store all Shapes to be drawn
	// in the paintComponent
	
	// You can also keep other instance variables here as you deem fit
	
    public ShapeDriver() {
        super(); 
        random = new Random();
        shapes = new ArrayList<>();
        this.setBackground(new Color(random.nextFloat(), random.nextFloat(), random.nextFloat()));
        this.selection = new ArrayList<>();
        for(PossibleShape shape : PossibleShape.values())
        {
        	selection.add(shape);
        }
        /* TO-DO: 
         *  - set up this JPanel
         *  - initialize any other fields you've declared
         *  - You could also setBackground here
         */
    }

    @Override
    public void paintComponent(Graphics g) {
        // calling super class paintComponent method
        // background will not be colored otherwise
        super.paintComponent(g);

        /*
		  Invoke the .draw() of the different Shapes here. It should take
		  the Graphics g object as a parameter. Iterate over your data structure
		  holding all the various Shape objects and call their draw() method.
		*/    
        for(Shape shape : shapes)
        {
        	shape.draw(g);
        }
    }
    
	@Override
	public void actionPerformed(ActionEvent e){
		/*
		  This method gets invoked automatically whenever Timer runs out.
		  Purpose of this method should be to do all the randomization
		  such as picking random colors, (x,y) coords, sizes and also
		  deciding which type of shape to draw. Call this.repaint() at
		  the end, so that paintComponent() is invoked.
		  
		  Remember, a specific type of shape (Square, Oval etc) can be repeated
		  only 10 times max.
		*/
		
		// Getting Random Shape
		PossibleShape selectedShape = selection.get(random.nextInt(selection.size()));
		Shape newShape;
		int randX = random.nextInt(FRAME_WIDTH);
		int randY = random.nextInt(FRAME_HEIGHT);
		int randHeight = random.nextInt(SIZE_UPPER_BOUND - SIZE_LOWER_BOUND) + SIZE_LOWER_BOUND;
		int randWidth = random.nextInt(SIZE_UPPER_BOUND - SIZE_LOWER_BOUND) + SIZE_LOWER_BOUND;
		int randNumPoints = random.nextInt(POLYGON_UPPER_BOUND - POLYGON_LOWER_BOUND) + POLYGON_LOWER_BOUND;
		Color fill = new Color(random.nextFloat(), random.nextFloat(), random.nextFloat());
		Color background = new Color(random.nextFloat(), random.nextFloat(), random.nextFloat());
		updateCounts();
		switch(selectedShape)
		{
		case CIRCLE:
			newShape = new Circle(fill, background, randX, randY, randHeight);
			if(counts[0] == 9)
			{
				selection.remove(PossibleShape.CIRCLE);
			}
			break;
		case HEXAGON:
			newShape = new Hexagon(fill, background, getRandomPointArray(HEXAGON_SIDES, randX, randY));
			if(counts[1] == 9)
			{
				selection.remove(PossibleShape.HEXAGON);
			}
			break;
		case OVAL:
			newShape = new Oval(fill, background, randX, randY, randHeight, randWidth);
			if(counts[2] == 9)
			{
				selection.remove(PossibleShape.OVAL);
			}
			break;
		case PENTAGON:
			newShape = new Pentagon(fill, background, getRandomPointArray(PENTAGON_SIDES, randX, randY));
			if(counts[3] == 9)
			{
				selection.remove(PossibleShape.PENTAGON);
			}
			break;
		case POLYGON:
			newShape = new Polygon(fill, background, getRandomPointArray(randNumPoints, randX, randY));
			if(counts[4] == 9)
			{
				selection.remove(PossibleShape.POLYGON);
			}
			break;
		case QUADRILATERAL:
			newShape = new Quadrilateral(fill, background, getRandomPointArray(QUADRILATERAL_SIDES, randX, randY));
			if(counts[5] == 9)
			{
				selection.remove(PossibleShape.QUADRILATERAL);
			}
			break;
		case RECTANGLE:
			newShape = new Rectangle(fill, background, randX, randY, randWidth, randHeight);
			if(counts[6] == 9)
			{
				selection.remove(PossibleShape.RECTANGLE);
			}
			break;
		case SQUARE:
			newShape = new Square(fill, background, randX, randY, randWidth);
			if(counts[7] == 9)
			{
				selection.remove(PossibleShape.SQUARE);
			}
			break;
		case TRIANGLE:
			newShape = new Triangle(fill, background, getRandomPointArray(TRIANGLE_SIDES, randX, randY));
			if(counts[8] == 9)
			{
				selection.remove(PossibleShape.TRIANGLE);
			}
			break;
		default:
			newShape = new Square(0, 0, 1);
			break;
		}
//		newShape = new Square(fill, background, randX, randY, 20);
		shapes.add(newShape);
		
		this.repaint();
	}
	
	/**
	 * Creates a random array of size points centered around x and y.
	 * @param size The number of points
	 * @param x The x value the points scatter around
	 * @param y The y value the points scatter around
	 * @return A randomized array of points
	 */
	private Point[] getRandomPointArray(int size, int x, int y)
	{
		Point[] points = new Point[size];
		int pointX;
		int pointY;
		
		for(int i = 0; i < points.length; i++)
		{
			pointX = x + random.nextInt(SIZE_UPPER_BOUND * 2) - SIZE_UPPER_BOUND;
			pointY = y + random.nextInt(SIZE_UPPER_BOUND * 2) - SIZE_UPPER_BOUND;
			points[i] = new Point(pointX, pointY);
		}
		
		return points;
	}
	
	/**
	 * Updates the count variable each step so that no shape is printed more than 10 times.
	 */
	private void updateCounts()
	{
		int[] newCounts = new int[9];
		for(Shape shape : shapes)
		{
			if(shape instanceof Circle)
			{
				counts[0] += 1;
			}
			else if(shape instanceof Hexagon)
			{
				counts[1] += 1;
			}
			else if(shape instanceof Oval)
			{
				counts[2] += 1;
			}
			else if(shape instanceof Pentagon)
			{
				counts[3] += 1;
			}
			else if(shape instanceof Polygon)
			{
				counts[4] += 1;
			}
			else if(shape instanceof Quadrilateral)
			{
				counts[5] += 1;
			}
			else if(shape instanceof Rectangle)
			{
				counts[6] += 1;
			}
			else if(shape instanceof Square)
			{
				counts[7] += 1;
			}
			else if(shape instanceof Triangle)
			{
				counts[8] += 1;
			}
		}
		counts = newCounts;
	}
	
    // test client
    public static void main(String[] args) 
    {
    	
    }
}