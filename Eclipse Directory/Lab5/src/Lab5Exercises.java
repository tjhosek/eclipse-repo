/**
 * @author Trevor Hosek
 * @version 1.0
 * 2/14/2020
 * C212
 * 
 * Exercises for Lab 5
 */

import java.util.ArrayList;
import java.util.Random;

public class Lab5Exercises
{
	public static void main(String[] args)
	{
		//Testing Longest Run
		longestRun();
		
		//Testing Bulgarian Solitaire
		bulgarianSolitaire();
		
		//Testing Matrix functions. Commented out because of test suite
//		boolean[][] testArray = 
//			{
//					{true,false,false},
//					{true,true,false},
//					{false,false,false},
//					{true,false,true}
//			};
//		
//		Matrix testMatrix = new Matrix(testArray);
//		System.out.println(testMatrix);
//		System.out.println(testMatrix.transposeMatrix());
//		
//		Matrix squareMatrix = new Matrix(new boolean[10][10]);
//		Matrix notSquareMatrix = new Matrix(new boolean[5][10]);
//		
//		System.out.println(squareMatrix.isSquareMatrix());
//		System.out.println(notSquareMatrix.isSquareMatrix());
//		
//		System.out.println(testMatrix.rotateClockwise());
//		System.out.println(testMatrix.rotateCounterClockwise());
//		
//		System.out.println(testMatrix.percentageTrue());
//		
//		Matrix testMatrix2 = new Matrix(testArray);
//		System.out.println(testMatrix.isEqual(testMatrix2));
	}
	
	public static void longestRun()
	{
		/**
		 * Generate a stream of 20 random numbers, and print a string with the largest run of the same number in parenthesis
		 */
		final int COUNT = 20;
		final int DIE_SIDES = 6;
		
		Random numGen = new Random();
		int num = 0;					// The current num for the loop
		int[] numList = new int[COUNT];	// The list of nums
		int previousNum = 0;			// The previous num
		int runIndex = 0;				// The index of the current run of same numbers
		int runLength = 0;				// The length of the current run of the same numbers
		int highestRunLength = 0;		// The length of the highest run of same numbers
		int highestRunIndex = 0;		// The index of the highest run of the same numbers
		
		//Generating the numbers
		for(int i = 0; i < COUNT; i++)
		{
			previousNum = num;
			num = numGen.nextInt(DIE_SIDES-1) + 1;
			numList[i] = num;
			
			if(previousNum == num)
			{
				// If the current run is still going on
				runLength = runLength + 1;
				if(runLength > highestRunLength)
				{
					// If the current run is longer than the longest recorded run
					highestRunLength = runLength;
					if(runIndex != highestRunIndex) { highestRunIndex = runIndex; }
				}
			}
			else
			{
				// If the current run has stopped
				runIndex = i;
				runLength = 0;
			}
		}
		
		//Printing the numbers
		for(int i = 0; i < COUNT; i++)
		{
			if(i == highestRunIndex)
			{
				System.out.print("(");
			}
			System.out.print(numList[i]);
			if(i == highestRunIndex + highestRunLength)
			{
				System.out.print(")");
			}
			System.out.print(" ");
		}
	}
	
	public static void bulgarianSolitaire()
	{
		/**
		 * Starts with a random number of piles gotten from 45 cards
		 * Repeatedly takes 1 card from each pile and uses it to create a new pile
		 * The program repeates this until the piles equal 1,2,3,4,5,6,7,8,9
		 */
		final int DECK_SIZE = 45;
		Random pileGen = new Random();
		ArrayList<Integer> piles = new ArrayList<>();
		int[] goal = {1,2,3,4,5,6,7,8,9};
		ArrayList<Integer> goalList = new ArrayList<>();
		ArrayList<Integer> remove = new ArrayList<>();		//Collection that is used to remove all 0 values from the arrayList
		remove.add(0);
		int newPile = 0;
		for(int pile : goal)
		{
			goalList.add(pile);
		}
		int currentDeck = DECK_SIZE;
		int pileSize = 0;
		//Generating initial piles
		while(currentDeck > 0)
		{
			pileSize = pileGen.nextInt(currentDeck) + 1;
			piles.add(pileSize);
			currentDeck = currentDeck - pileSize;
		}
		System.out.println(piles);
		//Sorting piles
		while(!piles.equals(goalList))
		{
			newPile = 0;
			for(int i = 0; i < piles.size(); i++)
			{
				if(piles.get(i) > 0)
				{
					piles.set(i, piles.get(i) - 1);
					newPile++;
				}
			}
			piles.removeAll(remove);
			piles.add(newPile);
			System.out.println(piles);
		}
	}
	
	
}
