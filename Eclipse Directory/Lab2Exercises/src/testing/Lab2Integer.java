/**
 * @author Trevor Hosek
 * @version 1
 * Class CSCI C212
 * 1/24/20
 * 
 * A class that prints a variety of characters and their corresponding ascii values
 */


/*
 * Pseudocode
 * get a list of every required character
 * for each character in the list
 * 		typecast the character as an int
 * 		print the original character and the integer representation
 */

package testing;

public class Lab2Integer {

	public static void main(String[] args) 
	{
		char[] charArray = {
				'A',
				'B',
				'C',
				'Z',
				'X',
				'a',
				'b',
				'c',
				'y',
				'u',
				'0',
				'9',
				'2',
				'$',
				'*',
				'>',
				'-',
				'|',
				'\\',
				' ',
				'	'
		};
		
		for(char character : charArray)
		{
			System.out.println(character + " = " + charToInt(character));
		}

	}
	
	public static int charToInt(char character)
	{
		return (int) character;
	}

}
