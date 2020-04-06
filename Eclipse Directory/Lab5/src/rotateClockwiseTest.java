import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class rotateClockwiseTest
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
					{true, false, true, true},
					{false, false, true, false},
					{true, false, false, false}
			};
		
		Matrix testMatrix = new Matrix(testArray);
		Matrix rotatedMatrix = testMatrix.rotateClockwise();
		Matrix expectedMatrix = new Matrix(rotatedArray);
		
		assertEquals(rotatedMatrix.isEqual(expectedMatrix), true);
	}

}
