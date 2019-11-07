package recursion;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RecursionTest {

	@Test
	void sumOfDigits_PassingSingleDigitNumber1_Returns1() {
		int expected = 1;
		int actual = Recursion.sumOfDigits(1);
		assertEquals(expected, actual);
	}

	@Test
	void sumOfDigits_PassingDoubleDigitNumber10_Returns1() {
		int expected = 1;
		int actual = Recursion.sumOfDigits(10);
		assertEquals(expected, actual);
	}

	@Test
	void sumOfDigits_PassingTrippleDigitNumber111_Returns3() {
		int expected = 3;
		int actual = Recursion.sumOfDigits(111);
		assertEquals(expected, actual);
	}

	@Test
	void sumOfDigits_PassingFourDigitNumber4444_Returns16() {
		int expected = 16;
		int actual = Recursion.sumOfDigits(4444);
		assertEquals(expected, actual);
	}

	@Test
	void sumOfDigits_PassingZero_Returns0() {
		int expected = 0;
		int actual = Recursion.sumOfDigits(0);
		assertEquals(expected, actual);
	}

	@Test
	void sumOfDigits_Passing010101_Returns3() {
		int expected = 3;
		int actual = Recursion.sumOfDigits(10110);
		assertEquals(expected, actual);
	}

	@Test
	void sumOfDigits_Passing767_Returns20() {
		int expected = 20;
		int actual = Recursion.sumOfDigits(767);
		assertEquals(expected, actual);
	}

	@Test
	void sumOfDigits_Passing9876_Returns30() {
		int expected = 30;
		int actual = Recursion.sumOfDigits(9876);
		assertEquals(expected, actual);
	}

	@Test
	void countSmiles_PassingOneSmile_Returns1() {
		char[] smile = new char[] { ':', ')' };
		int expected = 1;
		int actual = Recursion.countSmiles(smile);
		assertEquals(expected, actual);
	}

	@Test
	void countSmiles_Passing2SmilesInSentence_Returns2() {
		char[] smile = new char[] { ':', ')', ' ', 'L', 'i', 'f', 'e', ' ', 'i', 's', ' ', 'g', 'o', 'o', 'd', ':',
				')' };
		int expected = 2;
		int actual = Recursion.countSmiles(smile);
		assertEquals(expected, actual);
	}

	@Test
	void countSmiles_Passing3Smiles_Returns3() {
		char[] smile = new char[] { ':', ':', ')', ':', ')', ':', ')' };
		int expected = 3;
		int actual = Recursion.countSmiles(smile);
		assertEquals(expected, actual);
	}

	@Test
	void countSmiles_Passing4Smiles_Returns4() {
		char[] smile = new char[] { ':', ')', ':', ')', ':', ')', ':', ')' };
		int expected = 4;
		int actual = Recursion.countSmiles(smile);
		assertEquals(expected, actual);
	}

	@Test
	void countSmiles_PassingZeroSmiles_Returns0() {
		char[] smile = new char[] { ')', ')', ')' };
		int expected = 0;
		int actual = Recursion.countSmiles(smile);
		assertEquals(expected, actual);
	}

	@Test
	void countSmiles_Passing1SmileInSentence_Returns1() {
		char[] smile = new char[] { 'c', 'h', 'a', 'r', ':', ')', 'i', 's', ' ', 'm', 'y', ' ', 'n', 'a', 'm', 'e' };
		int expected = 1;
		int actual = Recursion.countSmiles(smile);
		assertEquals(expected, actual);
	}

	@Test
	void countSmiles_Passing5Smiles_Returns5() {
		char[] smile = new char[] { ':', ')', ':', ')', ':', ')', ':', ')', ':', ')' };
		int expected = 5;
		int actual = Recursion.countSmiles(smile);
		assertEquals(expected, actual);
	}

	@Test
	void countSmiles_Passing10Smiles_Returns10() {
		char[] smile = new char[] { ':', ')', ':', ')', ':', ')', ':', ')', ':', ')', ':', ')', ':', ')', ':', ')', ':',
				')', ':', ')' };
		int expected = 10;
		int actual = Recursion.countSmiles(smile);
		assertEquals(expected, actual);
	}

	@Test
	void toUpper_PassingSingleCharString_ReturnsUpperCaseCharWithSpace() {
		String expected = "C ";
		String actual = Recursion.toUpper("c");
		assertEquals(expected, actual);
	}

	@Test
	void toUpper_PassingStrHiThere_ReturnsWordsAllUpperCaseSeperatedBySpace() {
		String expected = "H I   T H E R E ";
		String actual = Recursion.toUpper("hi there");
		assertEquals(expected, actual);
	}

	@Test
	void toUpper_PassingStrSeeTheGood_ReturnsWordsAllUpperCaseSeperatedBySpace() {
		String expected = "S E E   T H E   G O O D ";
		String actual = Recursion.toUpper("see the good");
		assertEquals(expected, actual);
	}

	@Test
	void toUpper_PassingStrOwnLessLiveMore_ReturnsWordsAllUpperCaseSeperatedBySpace() {
		String expected = "O W N   L E S S   L I V E   M O R E ";
		String actual = Recursion.toUpper("own less live more");
		assertEquals(expected, actual);
	}

	@Test
	void toUpper_PassingStrOwnLessLiveMoreFree_ReturnsWordsAllUpperCaseSeperatedBySpace() {
		String expected = "O W N   L E S S   L I V E   M O R E   F R E E ";
		String actual = Recursion.toUpper("own less live more free");
		assertEquals(expected, actual);
	}

	@Test
	void toUpper_Passing1Through6SpelledOut_ReturnsWordsAllUpperCaseSeperatedBySpace() {
		String expected = "O N E   T W O   T H R E E   F O U R   F I V E  " + " S I X ";
		String actual = Recursion.toUpper("one two three four five six");
		assertEquals(expected, actual);
	}

	@Test
	void toUpper_PassingABCDEFG_ReturnsLettersUpperCaseWith3SpacesSeperating() {
		String expected = "A   B   C   D   E   F   G ";
		String actual = Recursion.toUpper("a b c d e f g");
		assertEquals(expected, actual);
	}

	@Test
	void toUpper_PassingEmptySpace_Returns2EmptySpaces() {
		String expected = "  ";
		String actual = Recursion.toUpper(" ");
		assertEquals(expected, actual);
	}
}
