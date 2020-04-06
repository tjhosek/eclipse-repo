import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class isEqualTest
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
		
		boolean[][] testArrayFalse =
			{
					{true,false,false},
					{true,true,false},
					{false,false,false},
					{true,false,true},
					{true,false,true}
			};
		
		boolean[][] testArrayFalse2 = 
			{
					{true,true,false},
					{true,true,false},
					{false,false,false},
					{true,false,true}
			};
		
		Matrix testMatrix = new Matrix(testArray);
		Matrix testMatrix2 = new Matrix(testArray);
		Matrix testMatrixFalse = new Matrix(testArrayFalse);
		Matrix testMatrixFalse2 = new Matrix(testArrayFalse2);
		
		assertEquals(true, testMatrix.isEqual(testMatrix2));
		assertEquals(false, testMatrix.isEqual(testMatrixFalse));
		assertEquals(false, testMatrix.isEqual(testMatrixFalse2));
	}

}
