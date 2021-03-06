import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;

/**
 * 
 * @author Trevor Hosek
 * @version 1.0
 * 2/28/2020
 * CSCI-C212
 * 
 * Prompts the user for input about the canonball's path and displays the trajectory of it.
 * The canonball must stay between 500 to 500 to be properly drawn
 *
 */

public class CanonballDriver
{
	static final private int FRAME_X = 500;	// X dimension of the frame
	static final private int FRAME_Y = 500;	// Y dimension of the frame
	static final private int BUFFER = 5;	// Buffer from the bottom of the frame, so that the points on y=0 can be seen
	
	public static void main(String[] args)
	{
		// Initializing scanner and frame
		Scanner sc = new Scanner(System.in);
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Fire!");
		
		// Accounting for the window border of the frame, so that nothing is obscured from the frame
		frame.pack();
		int realHeight = FRAME_Y - (frame.getInsets().top + frame.getInsets().bottom + BUFFER);
		frame.setSize(FRAME_X, FRAME_Y);
		
		// Prompting user for variables
		System.out.println("What x position would you like the canonball to start at?");
		double initialX = sc.nextDouble();
		System.out.println("What initial angle would you like the canonball to launch at?");
		double initialAlpha = sc.nextDouble();
		System.out.println("What initial velocity would you like the canonball to start at?");
		double initialVelocity = sc.nextDouble();
		System.out.println("What time interval would you like the values of the canonball to be observed?");
		double timeInterval = sc.nextDouble();
		sc.close();
		
		// Creating the canonball and getting the trajectory
		Canonball canonball = new Canonball(initialX);
		ArrayList<Point> trajectory = canonball.shoot(initialAlpha, initialVelocity, timeInterval);
		
		// Creating the drawn version of the trajectory and displaying it
		TrajectoryComponent drawnTrajectory = new TrajectoryComponent(trajectory, realHeight);
		frame.add(drawnTrajectory);
		frame.setVisible(true);
	}

}
