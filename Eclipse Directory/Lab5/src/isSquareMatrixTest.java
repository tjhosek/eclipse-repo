import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class isSquareMatrixTest
{

	@Test
	void test()
	{
		Matrix squareMatrix = new Matrix(new boolean[10][10]);
		Matrix notSquareMatrix = new Matrix(new boolean[5][10]);
		assertEquals(squareMatrix.isSquareMatrix(), true);
		assertEquals(notSquareMatrix.isSquareMatrix(), false);
	}

}
