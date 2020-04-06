
import java.awt.Color;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.Timer;

/**
 * 
 * @author Trevor Hosek
 * @version 1.0
 * 3/6/20
 * CSCI-C212
 * 
 * Creates a window in which the ShapeDriver runs.
 *
 */

/*
 * Main application for random shape generator app
 * NOTE: You are encouraged to experiment and try out various approaches
 * The comments given here are just guidelines to get you started 
 * Possibly, this problem can be completed in many ways.
 */
public class ShapeWindow extends JFrame {

    JPanel shapeDriver;
    final static int DELAY = 100;
    final static int RUN_TIME = 20000;

    public ShapeWindow() {
        super();
        // TO-DO: set up the frame
		/*
		Create a ShapeDriver object here (which is a JPanel)
		and add it to ShapeWindow (which is a JFrame). Don't forget to setSize,
		setVisible and any other required attributes (you might want to add the ShapeDriver
		object to the ContentPane (using this.getContentPane()) instead of directly adding
		to ShapeWindow.
		
		You can initialize a Timer here (with appropriate milliseconds and your 
		ShapeDriver obj created above as params). Use the timer.start() method to start Timer.
		However, you would also want to do Thread.sleep(<Appropriate milliseconds here>) afterwards
		It should be within a try-catch block. You can leave the catch block empty or provide some sysout msg
		You can stop your timer object after the try-catch block
		
		*/
        ShapeDriver driver = new ShapeDriver();
        this.getContentPane().add(driver);
        this.setSize(driver.FRAME_WIDTH, driver.FRAME_HEIGHT);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setVisible(true);
        this.setVisible(true);
        Timer timer = new Timer(DELAY, driver);
        timer.start();
        try
        {
        	Thread.sleep(RUN_TIME);
        } 
        catch (InterruptedException e)
		{
			e.printStackTrace();
		}
        timer.stop();
    }

    public static void main(String[] args) {
        // Create a JFrame and invoke the constructor
        JFrame shapeWindow = new ShapeWindow();
    }
}
