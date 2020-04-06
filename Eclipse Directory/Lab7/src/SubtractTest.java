import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SubtractTest
{

	@Test
	void test()
	{
		StandardComplex standard = new StandardComplex(2, 3);
		StandardComplex standard2 = new StandardComplex(6, 7);
		PolarComplex polar = new PolarComplex(4, 5);
		PolarComplex polar2 = new PolarComplex(8, 9);
		
		StandardComplex expectedStandard = new StandardComplex(-4, -4);
		PolarComplex expectedPolar = new PolarComplex(-4, -4);
		assertEquals(expectedStandard, standard.subtract(standard2));
		assertEquals(expectedPolar, polar.subtract(polar2));
	}

}
