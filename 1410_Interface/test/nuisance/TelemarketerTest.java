package nuisance;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TelemarketerTest {
	private Telemarketer tele1;
	@BeforeEach
	void setUp() throws Exception {
		tele1 = new Telemarketer("Fred", 30);
	}

	@Test
	void giveSalesPitch_CreateTelemarketerFredAndGiveSalesPitch_ReturnsStringIndicatingSalesPitch() {
		String expected = "Fred pressures others to buy stuff";
		String actual = tele1.giveSalesPitch();
		assertEquals(expected, actual);
	}

}
