import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class intToHexTest {

	@Test
	void test() {
		String hexValue = Lab3Exercises.intToHex(142);
		assertEquals("0x8E",hexValue);
	}

}
