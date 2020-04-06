import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

class RomanToIntTest {

	@Test
	void test() {
		Scanner scanner = new Scanner(System.in);
		int integer = Lab4Exercises.romanToInt("MCMLXXVIII");
		assertEquals(integer, 1978);
		scanner.close();
	}

}
