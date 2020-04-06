
public class SecondMax {

	public static void main(String[] args) 
	{
		int[] numbers = {1,2,3,4,11,85,32,43};
		System.out.println(secondMax(numbers));

	}
	
	public static int secondMax(int[] intArray)
	{
		int max = intArray[0];
		int secondMax = max;
		for (int i : intArray) 
		{
			if(i > max)
			{
				secondMax = max;
				max = i;
			}
		}
		return secondMax;
	}

}
