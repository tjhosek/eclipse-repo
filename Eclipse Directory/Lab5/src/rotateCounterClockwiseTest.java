import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class rotateCounterClockwiseTest
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
		
		boolean[][] rotatedArray = 
			{
					{false, false, false, true},
					{false, true, false, false},
					{true, true, false, true}
			};
		
		Matrix testMatrix = new Matrix(testArray);
		Matrix rotatedMatrix = testMatrix.rotateCounterClockwise();
		Matrix expectedMatrix = new Matrix(rotatedArray);
		
		assertEquals(rotatedMatrix.isEqual(expectedMatrix), true);
	}

}
