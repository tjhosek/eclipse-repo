/**
 * 
 * Prints 5 Poligonal Shapes
 * @author Trevor Hosek
 * @version 1.0
 * tjhosek
 * Created on 1/17/2020
 * Assignment Lab01
 * 
 * 
 */

/*
 * The System class has the following feilds:
 * static PrintStream err
 * static InputStream in
 * static PrintStream out
 */

public class Lab1 
{
	// Prints a variety of polygons.
	
	// Static Variables
	private static final int TRIANGLESIZE = 5;
	
	public static void main(String[] args) 
	{
		System.out.println("Triangle 1");
		printFirstTriangle();
		System.out.println("Triangle 2");
		printSecondTriangle();
		System.out.println("Triangle 3");
		printThirdTriangle();
		System.out.println("Triangle 4");
		printFourthTriangle();
		System.out.println("Triangle 5");
		printFifthTriangle();
	}
	
	public static void printFirstTriangle()
	{
		/**
		 * Prints the First Triangle
		 */
		for(int i = 0; i < TRIANGLESIZE; i++) 
		{
			for(int j = 0; j<TRIANGLESIZE - i; j++)
			{
				System.out.print(" ");
			}
			
			for(int k = i + 1; k > 0; k--)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void printSecondTriangle()
	{
		/** 
		 * Prints the second triangle
		 */
		for(int i = 0; i < TRIANGLESIZE; i++) 
		{
			for(int j = 0; j < TRIANGLESIZE - i; j++)
			{
				System.out.print(" ");
			}
			
			for(int k = i; k > 0; k--)
			{
				System.out.print("*");
			}
			
			System.out.print("*");
			
			for(int k = i; k > 0; k--)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void printThirdTriangle()
	{
		/**
		 * Prints the third triangle
		 */
		
		// Printing the top half of the diamond
		for(int i = 0; i < TRIANGLESIZE; i++)
		{
			for(int j = 0; j < TRIANGLESIZE - i; j++)
			{
				System.out.print(' ');
			}
			
			for(int j = 0; j < i*2; j++)
			{
				if(j == 0)
				{
					System.out.print('*');
				}
				else
				{
					System.out.print(' ');
				}
			}
			System.out.print('*');
			System.out.println();
		}
		
		// Printing the bottom half of the diamond
		for(int i = TRIANGLESIZE; i >= 0; i--)
		{
			for(int j = 0; j < TRIANGLESIZE - i; j++)
			{
				System.out.print(' ');
			}
			
			for(int j = 0; j < i*2; j++)
			{
				if(j == 0)
				{
					System.out.print('*');
				}
				else
				{
					System.out.print(' ');
				}
			}
			System.out.print('*');
			System.out.println();
		}
	}
	
	public static void printFourthTriangle()
	{
		/**
		 * Prints the fourth triangle
		 */
		
		// Printing the top half of the diamond
		for(int i = 0; i < TRIANGLESIZE; i++)
		{
			for(int j = 0; j < TRIANGLESIZE - i; j++)
			{
				System.out.print('*');
			}
			
			for(int j = 0; j < i*2; j++)
			{
				if(j == 0)
				{
					System.out.print('*');
				}
				else
				{
					System.out.print(' ');
				}
			}
			
			System.out.print('*');
			
			for(int j = 0; j < TRIANGLESIZE - i; j++)
			{
				System.out.print('*');
			}
			
			System.out.println();
		}
		
		// Printing the bottom half of the diamond
		for(int i = TRIANGLESIZE; i >= 0; i--)
		{
			for(int j = 0; j < TRIANGLESIZE - i; j++)
			{
				System.out.print('*');
			}
			
			for(int j = 0; j < i * 2; j++)
			{
				if(j == 0)
				{
					System.out.print('*');
				}
				else
				{
					System.out.print(' ');
				}
			}
			
			System.out.print('*');
			
			for(int j = 0; j < TRIANGLESIZE - i; j++)
			{
				System.out.print('*');
			}
			
			System.out.println();
		}
				
	}
	
	public static void printFifthTriangle()
	{
		/**
		 * Prints the Fifth Triangle
		 */
		
		for(int i = TRIANGLESIZE; i > 0; i--)
		{
			for(int j = 0; j < i; j++)
			{
				System.out.print('*');
			}
			
			System.out.println();
		}
		
	}

}
