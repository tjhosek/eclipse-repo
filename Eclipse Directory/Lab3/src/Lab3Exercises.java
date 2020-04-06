import java.util.Scanner;

/**
 * 
 * @author Trevor Hosek
 * @version 1.0
 * Class: C212
 * Lab: 3
 *
 */

public class Lab3Exercises {
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please type an integer: ");
		int toPuzzler = scanner.nextInt();
		System.out.println(my1089Puzzle(toPuzzler));
		
		System.out.print("Please input a phone number: ");
		String phoneNumber = scanner.next();
		System.out.println(formatPhoneNumber(phoneNumber,true));
		System.out.println(formatPhoneNumber(phoneNumber,false));
		
		System.out.println(numbersList());
		
		System.out.println(grade('A'));
		
		//Testing my answers to the questions
		newtons();
		bond();
		buzz();
		
		scanner.close();
		
	}
	
	public static int my1089Puzzle(int myInput)
	{
		/**
		 * Takes an integer input from the user and does the following:
		 *  1. Discards all but the last three digits
		 *  2. Reverse the digits
		 *  3. Subtract the original number from the reversed, discarding the minus sign
		 *  4. Reverse the difference
		 *  5. Add the reversed difference to the difference
		 *  6. Return the sum
		 *  The method assumes that smaller numbers will have preceding zeroes
		 */
		String inputString = String.format("%03d", myInput);
		String lastThreeDigits = inputString.substring(0,3);									// Get last 3 Digits
		int lastThreeDigitsInt = Integer.parseInt(lastThreeDigits);
//		System.out.println(lastThreeDigits);
		int reversed = Integer.parseInt(reverse(lastThreeDigits));								// Reverse the last three digits
//		System.out.println(reversed);
		int difference = Math.abs(reversed - lastThreeDigitsInt);								// Taking the difference of the reversed and the original
//		System.out.println(difference);	
		int reversedDifference = Integer.parseInt(reverse(String.format("%03d", difference)));	// Reversing the difference
//		System.out.println(reversedDifference);
		int sumOfDifferences = difference + reversedDifference;									// Taking the sum of the differences
//		System.out.println(sumOfDifferences);
		return sumOfDifferences;
	}
	
	private static String reverse(String forward)
	{
		/**
		 * Reverses the given string
		 */
		String reversed = "";
		for(int i = forward.length() - 1; i >= 0; i--)
		{
			reversed = reversed + forward.charAt(i);
		}
		return reversed;
	}
	
	public static String formatPhoneNumber(String myNumber, boolean option)
	{
		/**
		 * Formats a phone number based on whether the user wants parenthesis or not
		 * 
		 * 
		 */
		/*
		 * Pseudocode:
		 * Break the phone number into three different strings
		 * If option is true, return the string in the following format, "(***) ***-****" where * is the locations of the strings established in step 1
		 * Else return the string in the following format, "***-***-****"
		 */
		String firstPart = myNumber.substring(0,3);
		String secondPart = myNumber.substring(3,6);
		String thirdPart = myNumber.substring(6);
		if(option)
		{
			return String.format("(%1$s) %2$s-%3$s", firstPart, secondPart, thirdPart);
		}
		else 
		{
			return String.format("%1$s-%2$s-%3$s", firstPart, secondPart, thirdPart);
		}
	}
	
	public static String numbersList()
	{
		/**
		 * Returns a list of integers seperated by commas based on user input
		 */
		
		// Initializing vars
		Scanner intScanner = new Scanner(System.in);
		String numList = "";
		int currentInt;
		boolean duplicate = false;
		
		System.out.print("Please input a number between 5 and 19. Input a string to complete the list.");
		while(intScanner.hasNextInt())
		{
			//Prompting user input
			System.out.print("Please input a number between 5 and 19: ");
			currentInt = intScanner.nextInt();
			//Checking input is within bounds
			if(currentInt < 5 || currentInt > 19)
			{
				System.out.println("Please only input numbers between 5 and 19.");
			}
			else
			{
				//Checking if input is a duplicate value
				duplicate = false;
				for (String i : numList.split(","))
				{
					if(Integer.toString(currentInt).equals(i)) 
					{
						duplicate = true;
					}
				}
				if(!duplicate)
				{
					//Adding input to string if input is not a duplicate
					numList = numList + "," + currentInt;
				}
			}
			System.out.println();
		}
		
		intScanner.close();
		//Ensuring the resulting string is atleast 2 values long
		if(numList.length() > 1) 
		{
			return numList.substring(1);
		}
		else
		{
			return "";
		}
	}
	
	public static String grade(char letterGrade)
	{
		/**
		 * Returns a string that contains the range of number grades that a letter grade could represent
		 */
		
		//Initializing variables
		int maxGrade = 100;
		int aCutoff = 93;
		int bCutoff = 83;
		int cCutoff = 73;
		int dCutoff = 63;
		int fCutoff = 0;
		String rangeFormat = "Your grade is between %1$d and %2$d";
		
		//Checking each letter grade
		if(letterGrade == 'A' || letterGrade == 'a')
		{
			return String.format(rangeFormat, aCutoff, maxGrade);
		}
		if(letterGrade == 'B' || letterGrade == 'b')
		{
			return String.format(rangeFormat, bCutoff, aCutoff);
		}
		if(letterGrade == 'C' || letterGrade == 'c')
		{
			return String.format(rangeFormat, cCutoff, bCutoff);
		}
		if(letterGrade == 'D' || letterGrade == 'd')
		{
			return String.format(rangeFormat, dCutoff, cCutoff);
		}
		if(letterGrade == 'F' || letterGrade == 'f')
		{
			return String.format(rangeFormat, fCutoff, dCutoff);
		}
		//Char wasn't a valid letter grade
		return "Please input a valid letter grade";
	}
	
	public static String intToHex(int n)
	{
		/**
		 * Converts a positive integer into its hexadecimal representation
		 */
		//Initializing variables
		final int F_VALUE = 15;
		final int E_VALUE = 14;
		final int D_VALUE = 13;
		final int C_VALUE = 12;
		final int B_VALUE = 11;
		final int A_VALUE = 10;
		final int MAX_HEX = 16;
		String hexValue = "";
		int quotient = n;
		int remainder;
		while(quotient > MAX_HEX)
		{
			remainder = quotient % MAX_HEX;
			if (remainder == F_VALUE)
			{
				hexValue = "F" + hexValue;
			}
			else if (remainder == E_VALUE)
			{
				hexValue = "E" + hexValue;
			}
			else if (remainder == D_VALUE)
			{
				hexValue = "D" + hexValue;
			}
			else if (remainder == C_VALUE)
			{
				hexValue = "C" + hexValue;
			}
			else if (remainder == B_VALUE)
			{
				hexValue = "B" + hexValue;
			}
			else if (remainder == A_VALUE)
			{
				hexValue = "A" + hexValue;
			}
			else
			{
				hexValue = remainder + hexValue;
			}
			quotient = quotient / MAX_HEX;
		}
		hexValue = quotient + hexValue;
		return "0x" + hexValue;
	}
	
	private static void newtons()
	{
		/**
		 * Testing if my approximation was correct for 3.i
		 */
		double t = 9.0;
		while (Math.abs(t - 9.0 / t) > .001)
		{
			t = (9.0 / t + t) / 2.0;
		}
		System.out.println(t);
	}
	
	private static void bond()
	{
		/**
		 * Testing if my approximation was correct for 3.ii
		 */
		System.out.printf("%03d",7);
	}
	
	private static void buzz()
	{
		/**
		 * Testing if my approximation was correct for 3.iii
		 */
		String s = "Bye Bye Bye";
		s = s.replace('y', 'e');
		System.out.println(s);
	}
	
	/*
	 * Questions and Answers
	 * 
	 * a. 
	 * 	i. boolean, false
	 * 	ii. int, 65
	 * 	iii. double, 15.1
	 * 	iv. String, 2424
	 * 
	 * b.
	 * 	i. 		my initial guess: 	3.000091554
	 * 			actual answer:		3.00009155413138
	 * 			I was technically incorrect but very close. This was due to my calculator having fewer significant digits than the java compiler
	 * 	ii.		my initial guess:	007
	 * 			actual answer:		007
	 * 	iii.	my initial guess:	Bee Bee Bee
	 * 			actual answer:		Bee Bee Bee
	 */
}
