import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class gradeTest {

	@Test
	void test() {
		String bRange = Lab3Exercises.grade('B');
		assertEquals("Your grade is between 83 and 93", bRange);
	}

}
