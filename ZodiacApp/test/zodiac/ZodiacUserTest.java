package zodiac;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ZodiacUserTest {
	ZodiacUser z1;
	
	@Test
	void getSign_PassingDecemberAndDay31_ReturnsCapricorn() {
		z1 = new ZodiacUser("Mary", "December", 31);
		String actual = z1.getSign().toString();
		String expected = "CAPRICORN";
		assertEquals(expected, actual);
	}

	@Test
	void getSign_PassingFebruaryAnd4_ReturnsAquarius() {
		z1 = new ZodiacUser("Mary", "February", 4);
		String actual = z1.getSign().toString();
		String expected = "AQUARIUS";
		assertEquals(expected, actual);
	}
	
	@Test
	void getSign_PassingAugustAndDay31_ReturnsVirgo() {
		z1 = new ZodiacUser("Mary", "August", 31);
		String actual = z1.getSign().toString();
		String expected = "VIRGO";
		assertEquals(expected, actual);
	}
}
