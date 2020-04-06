import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MultiplyTest
{

	@Test
	void test()
	{
		StandardComplex standard = new StandardComplex(2, 3);
		StandardComplex standard2 = new StandardComplex(6, 7);
		PolarComplex polar = new PolarComplex(4, 5);
		PolarComplex polar2 = new PolarComplex(8, 9);
		
		StandardComplex expectedStandard = new StandardComplex(-9, 33);
		PolarComplex expectedPolar = new PolarComplex(-13, 77);
		assertEquals(expectedStandard, standard.multiply(standard2));
		assertEquals(expectedPolar, polar.multiply(polar2));
	}

}
