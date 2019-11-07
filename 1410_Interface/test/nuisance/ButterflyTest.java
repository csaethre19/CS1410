package nuisance;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ButterflyTest {

	private List<String> monarchColors = new ArrayList<String>();
	private Butterfly butter;
	@BeforeEach
	void setUp() throws Exception {
		monarchColors.add("Orange");
		monarchColors.add("Black");
		butter = new Butterfly("Monarch", monarchColors);
	}

	@Test
	void getColors_GettingButterflysColors_ReturnsListOfColors() {
		List<String> expected = new ArrayList<String>();
		expected.add("Orange");
		expected.add("Black");
		List<String> actual = butter.getColors();
		assertEquals(expected, actual);
	}

}
