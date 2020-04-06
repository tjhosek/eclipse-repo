import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class formatPhoneNumberTest {

	@Test
	void test() {
		String parenthesisNumber = Lab3Exercises.formatPhoneNumber("1234567890", true);
		String noParenthesisNumber = Lab3Exercises.formatPhoneNumber("1234567890", false);
		assertEquals("(123) 456-7890", parenthesisNumber);
		assertEquals("123-456-7890", noParenthesisNumber);
	}

}
