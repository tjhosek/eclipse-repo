import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class percentageTrueTest
{

	@Test
	void test()
	{
		boolean[][] testArray = 
			{
					{true, true, true},
					{false, false, false},
					{false, false, false}
			};
		
		Matrix testMatrix = new Matrix(testArray);
		String percentage = testMatrix.percentageTrue();
		String expected = "34%";
		
		assertEquals(expected, percentage);
	}

}
