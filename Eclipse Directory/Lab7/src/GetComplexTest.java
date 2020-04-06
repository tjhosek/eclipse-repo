import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/*
 * This test does not resolve due to rounding errors.
 */

class GetComplexTest
{

	@Test
	void test()
	{
		StandardComplex standard = new StandardComplex(2, 3);
		PolarComplex polar = new PolarComplex(4, 5);
		PolarComplex polarOfStandard = standard.getPolarComplex();
		StandardComplex standard2 = polarOfStandard.getStandardComplex();
		StandardComplex standardOfPolar = polar.getStandardComplex();
		PolarComplex polar2 = standardOfPolar.getPolarComplex();
		assertEquals(standard, standard2);
		assertEquals(polar, polar2);
	}

}
