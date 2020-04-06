import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IsEqualTest
{

	@Test
	void test()
	{
		StandardComplex standard = new StandardComplex(2, 3);
		PolarComplex polar = new PolarComplex(4, 5);
		StandardComplex standard2 = new StandardComplex(2, 3);
		PolarComplex polar2 = new PolarComplex(4, 5);
		PolarComplex standardPolar = standard.getPolarComplex();
		StandardComplex polarStandard = polar.getStandardComplex();
		PolarComplex standard2Polar = standard2.getPolarComplex();
		StandardComplex polar2Standard = polar2.getStandardComplex();
		assertEquals(true, standard.isEquals(standard2));
		assertEquals(true, standardPolar.isEquals(standard));
		assertEquals(true, standard2Polar.isEquals(standard));
		assertEquals(true, polar.isEquals(polar2));
		assertEquals(true, polarStandard.isEquals(polar));
		assertEquals(true, polar2Standard.isEquals(polar));
	}

}
