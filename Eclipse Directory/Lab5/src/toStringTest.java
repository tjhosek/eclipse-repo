import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class toStringTest
{

	@Test
	void test()
	{
		boolean[][] testArray = 
			{
					{true,false,false},
					{true,true,false},
					{false,false,false},
					{true,false,true}
			};
		
		Matrix testMatrix = new Matrix(testArray);
		String stringRepresentation = testMatrix.toString();
		String expectedString = 
				"[1, 0, 0\n" +
				" 1, 1, 0\n" +
				" 0, 0, 0\n" +
				" 1, 0, 1]";
		assertEquals(stringRepresentation, expectedString);
	}

}
