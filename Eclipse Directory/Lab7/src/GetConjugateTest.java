import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GetConjugateTest
{

	@Test
	void test()
	{
		StandardComplex standard = new StandardComplex(2, 3);
		StandardComplex standardConjugate = new StandardComplex(2, -3);
		PolarComplex polar = new PolarComplex(4, 5);
		PolarComplex polarConjugate = new PolarComplex(4, 355);
		assertEquals(standardConjugate, standard.getConjugate());
		assertEquals(polarConjugate, polar.getConjugate());
	}

}
