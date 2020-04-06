import java.util.ArrayList;

public class AlarmManager
{
	static ArrayList<Integer> alarms = new ArrayList<>();
	static int tick = 0;
	
	public static void addAlarm(int length)
	{
		alarms.add(length);
	}
	
	public static void startAlarm(int index)
	{
		/*
		 * While tick is less than the index's alarm
		 * 	increment tick by 1
		 * 	wait a second
		 * after this, reset tick, delete the alarm and print the alarm is done
		 */
	}
	
	public static void deleteAlarm(int index)
	{
		alarms.remove(index);
	}
}
