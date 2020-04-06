import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author Trevor Hosek, Arinah Karim
 * @version 1.0
 * 
 * an example of why it is important to create allot of smaller classes as opposed to one big class.
 *
 */

/*
 * The way that the classes are implemented here is very crowded and inefficient. It makes it difficult to navigate and difficult to use for both clients and developers alike.
 * It also makes it much harder to debug. The advantage is that it decreases dependency on other classes, but this is ultimately difficult to justify, as the cons outweigh the pros in this case.
 * 
 * The way they are implemented in the second version is much more modular and easier to manage. it creates a more understandable system and allows for better development of individual features.
 * In addition, because the classes aren't necessarily directly tied to eachother, the increase in dependency is minimal.
 */

public class ClockSystem
{
	private static int stopwatchCounter = 0;
	private static int stopwatchTime = 0;
	private static ArrayList<Integer> alarmCounters = new ArrayList<>();
	private static int timerCounter = 0;
	
	public static void main(String[] args)
	{
		/**
		 * Test functions here
		 */
	}
	
	public static int setAlarm(int length)
	{
		/**
		 * Adds a new alarm and returns it's index
		 */
		alarmCounters.add(length);
		return alarmCounters.size() - 1;
	}
	
	public static void deleteAlarm(int index)
	{
		/**
		 * Removes alarm at the given index
		 */
		alarmCounters.remove(index);
	}
	
	public static void activateAlarm(int index)
	{
		/**
		 * Activates an alarm and prints a message when it's time is reached
		 */
		
		/*
		 * While time is less than the index,
		 * 	increase index, wait one second
		 */
		
		System.out.println("Alarm Done!");
	}
	
	public static void setStopwatchTime(int value)
	{
		stopwatchTime = value;
	}
	
	public static void startStopwatch()
	{
		/*
		 * While counter is less than stopwatchTime
		 * 	increase stopwatchTime
		 * 	check if paused/stopped
		 */
	}
	
	public static void stopStopwatch()
	{
		/*
		 * Stop the stopwatch mid execution
		 */
	}
	
	public static void resetStopwatch()
	{
		/*
		 * Sets the counter for the stopwatch back to 0
		 */
	}
	
	public static void startTimer(int length)
	{
		/*
		 * While the timercounter is less than length
		 * 	increase the timercounter by 1
		 * 	wait 1 second.
		 */
	}
}
