import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AddTest
{

	@Test
	void test()
	{
		StandardComplex standard = new StandardComplex(2, 3);
		StandardComplex standard2 = new StandardComplex(6, 7);
		PolarComplex polar = new PolarComplex(4, 5);
		PolarComplex polar2 = new PolarComplex(8, 9);
		
		StandardComplex expectedStandard = new StandardComplex(8, 10);
		PolarComplex expectedPolar = new PolarComplex(12, 14);
		assertEquals(expectedStandard, standard.add(standard2));
		assertEquals(expectedPolar, polar.add(polar2));
	}

}
