package panagram;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PanagramCheckerTest {

	@Test
	void check_passingEmptyString_returnFalse() {
		assertEquals(false, new PanagramChecker().check(""));
	}

	@Test
	void check_passingPanagramString_returnTrue() {
		assertEquals(true, new PanagramChecker().check("The quick brown fox jumps over the lazy dog."));
	}
	
	@Test
	void check_passingNonPanagramString_returnFalse() {
		assertEquals(false, new PanagramChecker().check("You shall not pass!"));
	}
	
}
