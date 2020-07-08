package gcdCalculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GCDCalculatorModelTest {
	GCDCalculatorModel modelTest = new GCDCalculatorModel();
	@Test
	void calculateGcd_Passing5and25() {
		int expected = 5;
		int actual = modelTest.calculateGcd(5, 25);
		assertEquals(expected, actual);
	}
	
	@Test
	void calculateGcd_Passing8and16() {
		int expected = 8;
		int actual = modelTest.calculateGcd(8, 16);
		assertEquals(expected, actual);
	}
	
	@Test
	void calculateGcd_Passing8and44() {
		int expected = 4;
		int actual = modelTest.calculateGcd(8, 44);
		assertEquals(expected, actual);
	}
	
	@Test
	void calculateGcd_Passing8and344() {
		int expected = 8;
		int actual = modelTest.calculateGcd(8, 344);
		assertEquals(expected, actual);
	}

}
