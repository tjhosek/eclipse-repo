import static org.junit.jupiter.api.Assertions.*;
import java.awt.color.*;
import org.junit.jupiter.api.Test;

class checkValidShuffleTest {

	@Test
	void test() {
		boolean validShuffle = Lab4Exercises.checkValidShuffle("foo", "bar", "fboaor");
		boolean invalidCharacterShuffle = Lab4Exercises.checkValidShuffle("foo", "bar", "NotVal");
		boolean invalidLengthShuffle = Lab4Exercises.checkValidShuffle("foo", "bar", "foobarbar");
		
		assertEquals(true, validShuffle);
		assertEquals(false, invalidCharacterShuffle);
		assertEquals(false, invalidLengthShuffle);
	}

}
