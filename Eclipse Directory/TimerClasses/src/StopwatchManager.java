
public class StopwatchManager
{
	private static int timer = 0;
	private static int lapTime = 0;
	
	public static void setLapTime(int newLapTime)
	{
		lapTime = newLapTime;
	}
	
	public static void startTimer()
	{
		/*
		 * While timer is less than Laptime
		 * 	check for stop/resets
		 * 	wait a second
		 * 	increment timer
		 * When the timer is over print that it has ended
		 */
	}
	
	public static void pauseTimer()
	{
		/*
		 * Checks if user pauses the timer
		 */
	}
	
	public static void resetTimer()
	{
		/*
		 * Stops any current timers and sets timer to 0
		 */
	}
}
