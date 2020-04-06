import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * 
 * @author Trevor Hosek
 * @version 1.0
 * CSCI-C212
 * 
 * Driver class that listens to keypresses by the used and creates a random shape when 'h' is pressed. When circles and squares collide, they will do various things.
 *
 */
public class ShapeDriver extends JPanel implements ActionListener, KeyListener {

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
    
    // Speed Constants
    private final int SPEED = 5;
    private final int MOVE_DELAY = 60;
    
    // Random object
    private Random random;
    
    // Enumeration for the various possible shapes
    private enum PossibleShape
    {
    	CIRCLE, HEXAGON, OVAL, PENTAGON, POLYGON, QUADRILATERAL, RECTANGLE, SQUARE, TRIANGLE
    };
    
    // Containers for the various shapes
    private ArrayList<PossibleShape> selection;
    
    private ArrayList<Shape> shapes;
    
    private ArrayList<Shape> forDeletion;
    private ArrayList<Shape> forAddition;
	
    private Timer timer;
    public ShapeDriver() {
    	super(); 
    	// Initializing variables
        random = new Random();
        shapes = new ArrayList<>();
        forDeletion = new ArrayList<>();
        forAddition = new ArrayList<>();
        this.selection = new ArrayList<>();
        for(PossibleShape shape : PossibleShape.values())
        {
        	selection.add(shape);
        }
        
        // Randomizing backgrounds
        this.setBackground(new Color(random.nextFloat(), random.nextFloat(), random.nextFloat()));
        
	    // the second argument to the Timer Constructor takes an ActionListener
	    // the this key word informs the JVM to look inside this class for
	    // the actionPerformed method that must be overridden when
	    // ActionListener is implemented
	    // Every tick of the clock will now run the actionPerformed method
	    timer = new Timer(1000/60, this);
	    timer.start();
	    
	    
	    // Initial shapes spawned to demonstrate collision mechanics
	    Square testSquare = new Square(30, 300, 10);
	    Square testSquare2 = new Square(550, 300, 50);
	    testSquare.setDx(3);
	    testSquare2.setDx(-4);
	    
	    Circle testCircle = new Circle(30, 400, 14);
	    Circle testCircle2 = new Circle(550, 400, 50);
	    testCircle.setDx(3);
	    testCircle2.setDx(-4);
	    
	    shapes.add(testSquare);
	    shapes.add(testSquare2);
	    shapes.add(testCircle);
	    shapes.add(testCircle2);
    }

    // Method that must be implemented since the class implements ActionListener
    public void actionPerformed(ActionEvent e) {
	    // move each Shape
    	for(Shape shape : shapes)
    	{
    		if(shape.getPause() <= 0)
    		{
    			shape.moveLocation(shape.getDx(), shape.getDy());
    		}
    		else
    		{
    			shape.tick();
    		}
    		// check if Shape is Circle or Square
    	    // if it is a Circle or Square, check if it collides with Shape of same type
    		
    		if(shape instanceof Square)
    		{
    			for(Shape collider : shapes)
    			{
    				if(checkIntersection(shape, collider) && collider instanceof Square)
    				{
    					manageCollision(shape, collider);
    				}
    			}
    		}
    		else if(shape instanceof Circle)
    		{
    			for(Shape collider : shapes)
    			{
    				if(checkIntersection(shape, collider) && collider instanceof Circle)
    				{
    					manageCollision(shape, collider);
    				}
    			}
    		}
    		
    		//Check if shape is within bounds
    		if(shape.getX() < 0 || shape.getX() > FRAME_WIDTH || shape.getY() < 0 || shape.getY() > FRAME_HEIGHT)
    		{
    			forDeletion.add(shape);
    		}
    	}
 
	    // if the Shape collides with a Shape of same color,
	    // create a new Shape with twice the area of the larger Shape and direction of smaller Shape
	    // if the Shapes have the same area, then the area should still be doubled
	    // and select direction of one of the Shapes for the new Shape

	    // call repaint
    	
    	// Deleting queued shapes
    	for(Shape deletion : forDeletion)
    	{
    		shapes.remove(deletion);
    	}
    	
    	// Adding queued shapes
    	for(Shape addition : forAddition)
    	{
    		shapes.add(addition);
    	}
    	
    	// Clearing addition and deletion containers
    	forDeletion.clear();
    	forAddition.clear();
	    this.repaint();
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
    public void keyPressed(KeyEvent e){
	    /*
	    This method will be invoked whenever a key is pressed.
	    For this method, you will need to determine if the H key is pressed, and
	    if it is, create a new random Shape and add it to your data structure that holds
	    all the Shapes.
	    */
    	if(e.getKeyCode() == KeyEvent.VK_H)
    	{
    		createRandomShape();
    	}
    }

    /**
     * Creates a random shape moving in a random direction with randomized attributes
     */
    private void createRandomShape()
    {
    	// Selecting which shape
    	PossibleShape selectedShape = selection.get(random.nextInt(selection.size()));
    	
    	// Generating randomized variables
		Shape newShape;
		int randX = random.nextInt(FRAME_WIDTH);
		int randY = random.nextInt(FRAME_HEIGHT);
		int randDX;
		int randDY;
		do
		{
			randDX = random.nextInt(SPEED * 2) - SPEED;
			randDY = random.nextInt(SPEED * 2) - SPEED;
		} while(randDX == 0 && randDY == 0);
		int randHeight = random.nextInt(SIZE_UPPER_BOUND - SIZE_LOWER_BOUND) + SIZE_LOWER_BOUND;
		int randWidth = random.nextInt(SIZE_UPPER_BOUND - SIZE_LOWER_BOUND) + SIZE_LOWER_BOUND;
		int randNumPoints = random.nextInt(POLYGON_UPPER_BOUND - POLYGON_LOWER_BOUND) + POLYGON_LOWER_BOUND;
		Color fill = new Color(random.nextFloat(), random.nextFloat(), random.nextFloat());
		Color background = new Color(random.nextFloat(), random.nextFloat(), random.nextFloat());
		
		// Creating shape based off of random enumeration selection
		switch(selectedShape)
		{
		case CIRCLE:
			newShape = new Circle(fill, background, randX, randY, randHeight);
			break;
		case HEXAGON:
			newShape = new Hexagon(fill, background, getRandomPointArray(HEXAGON_SIDES, randX, randY));
			break;
		case OVAL:
			newShape = new Oval(fill, background, randX, randY, randHeight, randWidth);
			break;
		case PENTAGON:
			newShape = new Pentagon(fill, background, getRandomPointArray(PENTAGON_SIDES, randX, randY));
			break;
		case POLYGON:
			newShape = new Polygon(fill, background, getRandomPointArray(randNumPoints, randX, randY));
			break;
		case QUADRILATERAL:
			newShape = new Quadrilateral(fill, background, getRandomPointArray(QUADRILATERAL_SIDES, randX, randY));
			break;
		case RECTANGLE:
			newShape = new Rectangle(fill, background, randX, randY, randWidth, randHeight);
			break;
		case SQUARE:
			newShape = new Square(fill, background, randX, randY, randWidth);
			break;
		case TRIANGLE:
			newShape = new Triangle(fill, background, getRandomPointArray(TRIANGLE_SIDES, randX, randY));
			break;
		default:
			newShape = new Square(0, 0, 1);
			break;
		}
		
		// Setting random velocity of the shape
		newShape.setDx(randDX);
		newShape.setDy(randDY);
		newShape.setPause(MOVE_DELAY);
		shapes.add(newShape);
		
		// Logging shape creation
		System.out.printf("%1$s created at %2$s, %3$s with velocity %4$s, %5$s", selectedShape.name(), Integer.toString(randX), Integer.toString(randY), Integer.toString(randDX), Integer.toString(randDY));
		System.out.println();
    }
    
    /**
     * Returns a random array of points to be used in the creation of certain types of shapes, namely Quadrilateral, Triangle, Polygon and all of its subclasses.
     * @param size The number of points to generate.
     * @param x The x coordinate where the points should be scattered around.
     * @param y The y coordinate where the points should be scattered around.
     * @return a randomized array of points.
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
     * Checks if two shapes are intersecting with eachother
     * @param a shape to check for intersection
     * @param b other shape to check for intersection
     * @return true if the shapes are intersecting with eachother, false otherwise
     */
    private boolean checkIntersection(Shape a, Shape b)
    {
    	if(a == b)
    	{
    		// The shape is itself, so it cannot overlap with itself
    		return false;
    	}
    	if(a instanceof Circle && b instanceof Circle)
    	{
    		int aRadius = ((Circle) a).getWidth() / 2;
    		int bRadius = ((Circle) b).getWidth() / 2;
    		Point aCenter = new Point(a.getX() + aRadius, a.getY() + aRadius);
    		Point bCenter = new Point(b.getX() + bRadius, b.getY() + bRadius);
    		int distance = (int) aCenter.distance(bCenter);
    		if(distance <= aRadius + bRadius)
    		{
    			// If the distance between the shapes is less than or equal to the combined radius of both shapes, they are intersecting
    			return true;
    		}
    	}
    	if(a instanceof Square && b instanceof Square)
    	{
    		Point[] aPoints = ((Square) a).getPoints();
    		Point[] bPoints = ((Square) b).getPoints();
    		Point l1 = aPoints[0];	// Top Left point of square a
    		Point r1 = aPoints[2];	// Bottom Right point of square a
    		Point l2 = bPoints[0];	// Top Left point of square b
    		Point r2 = bPoints[2];	// Bottom Right point of square b
    		
    		// Squares are not intersecting if their x values are not overlapping
    		if(l1.x > r2.x || l2.x > r1.x)
    		{
    			return false;
    		}
    		// Squares are not intersecting if their y values are not overlapping
    		if(l1.y > r2.y || l2.y > r1.y)
    		{
    			return false;
    		}
    		// Both x and y values overlap, the squares must be intersecting eachother
    		return true;
    	}
    	return false;
    }
    
    /**
     * Takes in two shapes. If the shapes are of different colors, the shape with the smaller area is deleted. If the shapes are of the same color, both shapes are deleted, and a new shape with twice the area of the smaller shape and the direction of the larger shape is created
     * @param a shape to manage collision for
     * @param b other shape to manage collision for
     */
    private void manageCollision(Shape a, Shape b)
    {
    	Shape smaller;
    	Shape larger;
    	// Seeing which shape is smaller and which is larger
    	if(a.getArea() > b.getArea())
    	{
    		larger = a;
    		smaller = b;
    	}
    	else
    	{
    		larger = b;
    		smaller = a;
    	}
    	
    	// When the shapes have the same color, they combine
    	if(smaller.getFillColor().equals(larger.getFillColor()))
    	{
    		if(a instanceof Square && b instanceof Square)
    		{
    			Square newShape = new Square(smaller.getFillColor(), smaller.getBorderColor(), smaller.getX(), smaller.getY(), (int) (((Square)smaller).getWidth() * Math.sqrt(2.0)));
    			newShape.setDx(larger.getDx());
    			newShape.setDy(larger.getDy());
    			forAddition.add(newShape);
    		}
    		else if(a instanceof Circle && b instanceof Circle)
    		{
    			Circle newShape = new Circle(smaller.getFillColor(), smaller.getBorderColor(), smaller.getX(), smaller.getY(), (int) (((Circle) smaller).getWidth() * Math.sqrt(2.0)));
    			newShape.setDx(larger.getDx());
    			newShape.setDy(larger.getDy());
    			forAddition.add(newShape);
    		}
    		// Deleting old shapes
    		forDeletion.add(smaller);
    		forDeletion.add(larger);
    	}
    	else
    	{
    		// Delete smaller shape
    		forDeletion.add(smaller);
    	}
    }
    
    //No implementation is needed for this lab assignment.
    @Override
    public void keyReleased(KeyEvent e) {}


    //No implementation is needed for this lab assignment.
    @Override
    public void keyTyped(KeyEvent e) {}
} 
