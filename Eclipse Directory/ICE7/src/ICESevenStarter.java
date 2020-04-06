import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JPanel;
import javax.swing.JComponent;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.KeyEvent;
import java.awt.Dimension;
import javax.swing.KeyStroke;


public class ICESevenStarter extends JComponent{
	
	//For me, it is better to initiate some data when creating the fields
	//So that you will not encounter null exceptions later
	private final static String INPUT_FILE_PATH = "/input.txt";
	private final static String OUTPUT_FILE_PATH = "/output.txt";
	
	private String lastName = "";
	private String firstName = "";
	private String countryOfBirth = "";
	private String names = "";
	private String selection = "";
	private int xLoc = 0;
	private int yLoc = 0;
	
	
	// TODO?
	// you might need another fields at here
	
	public ICESevenStarter(int xLoc, int yLoc) throws IOException {
		// TODO
		// initiate x and y location as input x and y location
		// initiate other fields by reading the files
	   
	   // You can choose to store the new data to file directly in here
	   // Or you can create a function to do that
		String absolutePath = new File("").getAbsolutePath();
		File info = new File(absolutePath + INPUT_FILE_PATH);
		Scanner infoScanner = new Scanner(info);
		this.firstName = infoScanner.next();
		this.lastName = infoScanner.next();
		this.countryOfBirth = infoScanner.next();
		this.names = lastName + ", " + firstName;
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		infoScanner.close();
		
		FileWriter output = new FileWriter(absolutePath + OUTPUT_FILE_PATH);
		output.write(countryOfBirth + "\n");
		output.write(names);
		output.close();	
	}

    public void paintComponent(Graphics g) {
    	Graphics2D g2D = (Graphics2D) g;
    	g2D.drawChars(selection.toCharArray(), 0, selection.length(), xLoc, yLoc);
    }

	/**
	 * @return the countryOfBirth
	 */
	public String getCountryOfBirth()
	{
		return countryOfBirth;
	}

	/**
	 * @return the names
	 */
	public String getNames()
	{
		return names;
	}

	/**
	 * @return the selection
	 */
	public String getSelection()
	{
		return selection;
	}

	/**
	 * @param selection the selection to set
	 */
	public void setSelection(String selection)
	{
		this.selection = selection;
	}
  
    // TODO?
    // think about how to change your text in this class
    // if you choose to set Tester as KeyListener, then you should have set of setters for the fields to be called in Tester.java
    // If you choose to set this class as KeyListener, then you can directly setup the three functions for keyListener, and change the text to draw in here. 

}
