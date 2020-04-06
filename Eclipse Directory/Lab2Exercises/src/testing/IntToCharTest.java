package testing;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntToCharTest {

	@Test
	public void test() {
		char output = Lab2Character.intToChar(95);
		assertEquals('_',output);
	}

}
