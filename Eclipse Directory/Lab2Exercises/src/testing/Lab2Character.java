/**
 * @author Trevor Hosek
 * @version 1
 * Class CSCI C212
 * 1/24/20
 * 
 * A class that acquires and integer as an input from the user and then gives the ascii representation of that integer
 */

package testing;

import java.util.Scanner;

public class Lab2Character {

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please input an integer to be turned into an ASCII character: ");
		int asciiValue = scanner.nextInt();
		System.out.println(asciiValue + " = " + intToChar(asciiValue));

	}
	
	public static char intToChar(int number)
	{
		return (char) number;
	}

}
