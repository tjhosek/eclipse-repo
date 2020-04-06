//  Lab 2 
//  
//  Released:  1/20/20
//
//  @Author  Your Name and username
//  Last Edited:  
//
//
//  Directions:  Implement the following methods 
//               
//               
//////////////////////////////////////////////////////////////////////////////////

// Note:  Do not need to explicitly import classes from java.lang but wanted to make it explicit 
// Goal - understand using Static classes - i.e. the Math class was not designed to be Instantiated (make objects) 
// It is a class that provides functionality and will be used to complete one of the methods
import java.lang.Math;
import java.util.Scanner;

public class Lab2Exercises {
	// test client 
    public static void main(String[] args) {
    	Scanner testScanner = new Scanner(System.in);
    	System.out.print("Testing square functions, please define side length:");
    	double squareSideLength = testScanner.nextDouble();
    	System.out.println("Input:      " + squareSideLength);
    	System.out.println("Area:       " + areaOfSquare(squareSideLength));
    	System.out.println("Perimeter:  " + perimeterOfSquare(squareSideLength));
    	System.out.println("Cubic Area: " + volumeOfCube(squareSideLength));
    	System.out.println(printMeasurements((int) Math.round(squareSideLength)));
    	System.out.println();
    	
    	System.out.println("Testing lineFunction()");
    	System.out.print("Please input point 1's x value: ");
    	double x1 = testScanner.nextDouble();
    	System.out.print("Please input point 1's y value: ");
    	double y1 = testScanner.nextDouble();
    	System.out.print("Please input point 2's x value: ");
    	double x2 = testScanner.nextDouble();
    	System.out.print("Please input point 2's y value: ");
    	double y2 = testScanner.nextDouble();
    	System.out.println("Point 1: (" + x1 + "," + y1 + ")");
    	System.out.println("Point 2: (" + x2 + "," + y2 + ")");
    	System.out.println("y-intercept of line: " + lineFunction(x1,y1,x2,y2));
    	
    	System.out.println("Testing addCommas()");
    	System.out.print("Please input an interger greater than 1,000 and smaller than 1,000,000,000: ");
    	int commaNumber = testScanner.nextInt();
    	System.out.print("Number with commas: " + addCommas(commaNumber));
    	
    	testScanner.close();
    }
    
    // computes area of a square when given its side length
    public static int areaOfSquare(double sideLength) {
    	double area = sideLength * sideLength;
    	
    	return (int) Math.round(area);
    }

    // computes perimeter of a square when given its side length
    public static int perimeterOfSquare(double sideLength) {
    	double perimeter = sideLength * 4;
    	
    	return (int) Math.round(perimeter);
    }

    // computes volume of a cubic when given its side length
    public static double volumeOfCube(double sideLength) {
    	double cubicArea = Math.pow(sideLength, 3);
    	
    	return cubicArea;
    }
       
    // returns a String with three lines in the following format:
    // On Line1: "Length of one Side of Square is: *
    // On Line2: "Area: *, Perimeter: **, Volume: **** " where * refers to area, ** refers to 
    // perimeter of square and *** refers to volume of the cube respectively. 
    public static String printMeasurements(int value) {
    	String measurements = "Length of one Side of Square is: " + value +
    			"\nArea: " + areaOfSquare((double) value) + 
    			", Perimeter: " + perimeterOfSquare((double) value) +
    			", Volume: " + volumeOfCube((double) value);
    	
    	return measurements;
    
    }
    
	// given two points (x1,y1) and (x2,y2) return y intercept 	of the line
    public static int lineFunction(double x1, double y1, double x2, double y2) {
    	double deltaY = y1 - y2;
    	double deltaX = x1 - x2;
    	if(deltaX == 0) //Avoiding dividing by 0
    	{
    		return 0;
    	}
    	double yIntercept = deltaY / deltaX;
      
    	return (int) Math.round(yIntercept);
    }

    // reads a number between 1000 and 1 Billion and prints it with commas (,) separating 
    // every three digits. for example: 12317910 will be printed as $12,317,910
    // hint use modulus (%) to save part of the number, then concatenate back together as a String
    public static String addCommas(int num) {
    	// Ensuring num is within bounds
    	if(num < 1000)
	    {
    		return ""+num;
	    }
	    else if(num >= 1000000000)
	    {
	    	return "Error, number exceeds maximum for addComas()";
	    }
    	//Initializing return string. Redundant, but here for clarity
    	String commaNum = "";
    	//Retrieving sections of num to be seperated by commas
    	int thousand = num % 1000;
    	int million = (num % 1000000 - thousand)/1000;
    	int billion = (num % 1000000000 - million - thousand)/1000000;
    	//Formating the values to have the correct number of 0s
    	String thousandFormated = String.format("%03d", thousand);
    	String millionFormated = Integer.toString(million);
    	if(num >= 1000000)
    	{
    		millionFormated = String.format("%03d", million);
    	}
    	String billionFormated = Integer.toString(billion);
    	//Putting together the final string and returning it
    	commaNum = thousandFormated;
    	commaNum = millionFormated + "," + commaNum;
    	if(num >= 1000000)
    	{
    		commaNum = billionFormated + "," + commaNum;
    	}
    	commaNum = "$" + commaNum;
    	return commaNum;
    }
    
 
    
}

///////////////////////////////////
//                               //
// ANSER THE FOLLOWING QUESTIONS //
//                               //
///////////////////////////////////

/*
 * Questions 1-3 are on explicit and implicit casting of some numerical types  
 *
 * 1.  What happens if you multipy an int with a char? 
 * 		The char's ascii value is multiplied by the int as though it were an int
 * 
 * 2.  What happens if you multipy a double with a char? 
 * 		The char's ascii value is multiplied by the double as though it were an int
 * 
 * 3.  What happens if you square a char? 
 * 		The char's ascii value is squared and returned
 * 
 * 4.  What happens if a method has a paramater of type int, but you pass it a char?
 * 		The char's ascii value is passed instead
 * 
 * 5.  What happens if a mehtod has a paramater of type char, but you pass it an int? 
 * 		A syntax error occurs
 * 
 * 6.  What is the difference between two floating point primitive data types in the Java?
 * 		float is only a single precision floating point so it is less accurate than double, but it takes up less space.
 * 
 * 7.  Consider the following code snippet.
 *     int i = 10;
 *     n = ++(i++);
 *     System.out.println(++(i++) % 5);
 * 
 *     Without Compiling the Program:
 *     What {do you think} are the values of i and n if the code is executed?
 *     n = 11, i = 12
 *     What are the final value printed?
 *     3
 *     Now Compile and Run the Program to check your answers. If they are different, explain why 
 *     and provide updated code!
 *     The code snippet does not actually compile, and gives an error due to the ++ to the left of the i in both the second and third line. Replacing theses with "+ 1" gives the intended result
 *    	int i = 10;
 *		int n = (i++)+1;
 *		System.out.println((i++)+1 % 5);
 */
