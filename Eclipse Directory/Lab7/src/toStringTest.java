import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class toStringTest
{

	@Test
	void test()
	{
		StandardComplex standard = new StandardComplex(2, 3);
		PolarComplex polar = new PolarComplex(4, 5);
		String standardExpected = "(2.0, 3.0i)";
		String standardActual = standard.toString();
		String polarExpected = "(4.0, 5.0)";
		String polarActual = polar.toString();
		assertEquals(standardExpected, standardActual);
		assertEquals(polarExpected, polarActual);
	}

}
