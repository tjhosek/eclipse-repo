import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DivideTest
{

	@Test
	void test()
	{
		StandardComplex standard = new StandardComplex(2, 3);
		StandardComplex standard2 = new StandardComplex(6, 7);
		PolarComplex polar = new PolarComplex(4, 5);
		PolarComplex polar2 = new PolarComplex(8, 9);
		
		StandardComplex expectedStandard = new StandardComplex(33.0/85.0, 4.0/85.0);
		PolarComplex expectedPolar = new PolarComplex(77.0/145.0, 4.0/145.0);
		assertEquals(expectedStandard, standard.divide(standard2));
		assertEquals(expectedPolar, polar.divide(polar2));
	}

}
