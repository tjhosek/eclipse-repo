import javax.swing.JFrame;

/**
 * 
 * @author Trevor Hosek
 * @version 1.0
 * CSCI-C212
 * 2/21/20
 *
 */

/*
 * The exercises for lab 6
 */

public class Lab6Exercises
{
	final static int NUMBER_OF_SQUARES = 8;
	final static int GENERATIONS = 20;
	final static int PRINT_FREQUENCY = 5;
	
	public static void main(String[] args)
	{
		printCheckBoard(100);
		printCheckBoard(50);
		
		// Grid representing a static game of life pattern
		boolean[][] stillGrid = {
				{false, false, false, false, false, false},
				{false, false, true, true, false, false},
				{false, true, false, false, true, false},
				{false, false, true, false, true, false},
				{false, false, false, true, false, false},
				{false, false, false, false, false, false}
		};
		
		// Grid representing an oscillating game of life pattern
		boolean[][] oscillatorGrid = {
				{false, false, false, false, false, false},
				{false, true, true, false, false, false},
				{false, true, false, false, false, false},
				{false, false, false, false, true, false},
				{false, false, false, true, true, false},
				{false, false, false, false, false, false}
		};
		
		GameofLife stillGame = new GameofLife(stillGrid);
		
		System.out.println("Still Game of Life");
		
		System.out.println(stillGame);
		stillGame.grow(GENERATIONS, PRINT_FREQUENCY);
		
		GameofLife oscillatorGame = new GameofLife(oscillatorGrid);
		
		System.out.println("Oscillating game of life");
		
		System.out.println(oscillatorGame);
		oscillatorGame.grow(GENERATIONS, PRINT_FREQUENCY);	//Oscillates at a frequency of 2
	}
	
	public static void printCheckBoard(int size)
	{
		/*
		 * Prints a new Checkboard with each square being of the given size
		 */
		JFrame frame = new JFrame();
		//For some reason setting the screen to size * NUMBER_OFSQUARES didn't show all the squares, so I had to make it slightly larger
		int dimension = (int) Math.round(size * (NUMBER_OF_SQUARES + 1)); 
		frame.setSize(dimension, dimension);
		frame.setTitle("Checkerboard");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BoxComponent board = new BoxComponent(size, NUMBER_OF_SQUARES);
		frame.add(board);

		frame.setVisible(true);
	}
}
