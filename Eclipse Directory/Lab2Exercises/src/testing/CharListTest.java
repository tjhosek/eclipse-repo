package testing;

import static org.junit.Assert.*;

import org.junit.Test;

public class CharListTest {

	@Test
	public void test() {
		int output = Lab2Integer.charToInt('q');
		assertEquals(113, output);
	}

}
