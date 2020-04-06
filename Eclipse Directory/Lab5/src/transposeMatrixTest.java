import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class transposeMatrixTest
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
		
		boolean[][] transposedArray = 
			{
					{true, true, false, true},
					{false, true, false, false},
					{false, false, false, true}
			};
		
		Matrix testMatrix = new Matrix(testArray);
		Matrix transposed = testMatrix.transposeMatrix();
		Matrix expected = new Matrix(transposedArray);
		assertEquals(transposed.isEqual(expected), true);
	}

}
