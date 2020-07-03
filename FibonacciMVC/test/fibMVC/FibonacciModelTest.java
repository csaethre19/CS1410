package fibMVC;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FibonacciModelTest {
	FibonacciModel model = new FibonacciModel();
	
	@Test
	void calculateFirstFibonacci() {
		int expected = 0;
		int actual = model.calculateNthFibonacci(1);
		assertEquals(expected, actual);
	}
	
	@Test
	void calculateSecondFibonacci() {
		int expected = 1;
		int actual = model.calculateNthFibonacci(2);
		assertEquals(expected, actual);
	}

	@Test
	void calculateTenthFibonacci() {
		int expected = 34;
		int actual = model.calculateNthFibonacci(10);
		assertEquals(expected, actual);
	}
	
	@Test
	void calculate20thFibonacci() {
		int expected = 4181;
		int actual = model.calculateNthFibonacci(20);
		assertEquals(expected, actual);
	}
	
}
