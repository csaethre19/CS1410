package minCoins;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MinCoinsModelTest {
	private MinCoinsModel testModel = new MinCoinsModel();
	
	//test for an amount under $20 --> coins to be given back
	@Test
	void makeChange_PassingAmountOwedUnder20Dollars_ReturnsCorrectMinCoins() {
		fail("Not yet implemented");
	}
	
	//test for a negative amount --> exception
	@Test
	void makeChange_PassingNegativeAmount_ThrowsArithmeticException() {
		fail("Not yet implemented");
	}
	
	//test for amountOwed = tender
	@Test
	void makeChange_PassingEqualAmounts_ReturnsZeroCoins() {
		fail("Not yet implemented");
	}
	
}
