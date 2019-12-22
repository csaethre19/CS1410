package collections;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class GenericCollectionsTest {
	private List<Character> charList;
	private List<Integer> numberList;

	@Test
	void lettersAndNumbers_PassNullList_ReturnsNull() {
		charList = null;
		List<String> expected = null;
		List<String> actual = GenericCollections.lettersAndNumbers(charList);
		assertEquals(expected, actual);
	}
	
	@Test
	void lettersAndNumbers_PassEmptyList_ReturnsEmptyString() {
		List<Character> emptyList = new ArrayList<>();
		List<String> expected = new ArrayList<>(Arrays.asList(""));
		List<String> actual = GenericCollections.lettersAndNumbers(emptyList);
		assertEquals(expected, actual);		
	}
	
	@Test
	void lettersAndNumbers_PassListOfNonLetterNonNumberCharacters_ReturnsEmptyString() {
		charList = new ArrayList<>(Arrays.asList('@', '#', '!', '*', '$', '%'));
		List<String> expected = new ArrayList<>(Arrays.asList(""));
		List<String> actual = GenericCollections.lettersAndNumbers(charList);
		assertEquals(expected, actual);
	}
	
	@Test
	void lettersAndNumbers_PassListOfOnlyLetters_ReturnsListWithModifiedLetters() {
		charList = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'));
		List<String> expected = new ArrayList<>(Arrays.asList("L(f)", "L(e)", "L(d)",
				"L(c)", "L(b)", "L(a)"));
		List<String> actual = GenericCollections.lettersAndNumbers(charList);
		assertEquals(expected, actual);
	}
	
	@Test
	void lettersAndNumbers_PassListOfOnlyNumbers_ReturnsListWithModifiedNumbers() {
		charList = new ArrayList<>(Arrays.asList('1', '2', '3', '4', '5'));
		List<String> expected = new ArrayList<>(Arrays.asList("N(5)", "N(4)", "N(3)",
				"N(2)", "N(1)"));
		List<String> actual = GenericCollections.lettersAndNumbers(charList);
		assertEquals(expected, actual);
	}
	
	@Test
	void lettersAndNumbers_PassListWithCombinationOfNumbersAndLowerCaseLetters_ReturnsListWithModifiedNumbersAndLetters() {
		charList = new ArrayList<>(Arrays.asList('a', '1', 'c', '2', 'e', '3'));
		List<String> expected = new ArrayList<>(Arrays.asList("N(3)", "L(e)", "N(2)",
				"L(c)", "N(1)", "L(a)"));
		List<String> actual = GenericCollections.lettersAndNumbers(charList);
		assertEquals(expected, actual);
	}
	
	@Test
	void lettersAndNumbers_PassListWithCombinationOfAllOptions_ReturnsListWithModifiedNumbersAndLetters() {
		charList = new ArrayList<>(Arrays.asList('a', '@', '1', 'B', 'c', '!'));
		List<String> expected = new ArrayList<>(Arrays.asList("L(c)", "U(b)", "N(1)",
				"L(a)"));
		List<String> actual = GenericCollections.lettersAndNumbers(charList);
		assertEquals(expected, actual);
	}
	
	@Test
	void lettersAndNumbers_PassListWithCombinationOfNumbersAndUpperCaseLetters_ReturnsListWithModifiedNumbersAndLetters() {
		charList = new ArrayList<>(Arrays.asList('1', 'A', 'Z', '5', '0', 'W'));
		List<String> expected = new ArrayList<>(Arrays.asList("U(w)", "N(0)", "N(5)",
				"U(z)", "U(a)", "N(1)"));
		List<String> actual = GenericCollections.lettersAndNumbers(charList);
		assertEquals(expected, actual);
	}

	@Test
	void modify_PassNullList_ThrowsNullPointerException() {
		numberList = null;
		assertThrows(NullPointerException.class, () -> {GenericCollections.modify(numberList);});
	}
	
	@Test
	void modify_PassEmptyList_Returns13() {
		numberList = new ArrayList<>();
		int expected = 13;
		int actual = GenericCollections.modify(numberList);
		assertEquals(expected, actual);
	}
	
	@Test
	void modify_PassListWithOnlyMultiplesOf3_Returns13() {
		numberList = new ArrayList<>(Arrays.asList(-3, 3, 6, 9, 12));
		int expected = 13;
		int actual = GenericCollections.modify(numberList);
		assertEquals(expected, actual);
	}
	
	@Test
	void modify_ListWithCombinationOfMultiplesOf3AndNonMultiplesOf3_Return15() {
		numberList = new ArrayList<>(Arrays.asList(3, 2, 6, 12, 8));
		int expected = 14;
		int actual = GenericCollections.modify(numberList);
		assertEquals(expected, actual);
	}

	@Test
	void modify_ListWithNoMultiplesOf3_Returns17() {
		numberList = new ArrayList<>(Arrays.asList(2, 5, 7, 10));
		int expected = 15;
		int actual = GenericCollections.modify(numberList);
		assertEquals(expected, actual);
	}
	
	@Test
	void modify_ListWithOnlyMultiplesOf3_SortedInAscendingOrder() {
		numberList = new ArrayList<>(Arrays.asList(-3, 3, 6, 9, 12));
		GenericCollections.modify(numberList);
		List<Integer> expected = new ArrayList<>(Arrays.asList(4, 5, 6, 8, 10, 12, 
				12, 15, 16, 18, 20, 20, 24, 25, 30));
		List<Integer> actual = numberList;
		assertEquals(expected, actual);
	}
	
	@Test
	void modify_ListWithOneMultipleOf3_Returns20() {
		numberList = new ArrayList<>(Arrays.asList(-3, 2, 77, 8, 11, 15, 22, 23));
		int expected = 18;
		int actual = GenericCollections.modify(numberList);
		assertEquals(expected, actual);
	}
	
	@Test
	void modify_ListWithNoMultiplesOf3_SortedInAscendingOrder() {
		numberList = new ArrayList<>(Arrays.asList(2, 5, 7, 10));
		GenericCollections.modify(numberList);
		List<Integer> expected = new ArrayList<>(Arrays.asList(2, 4, 5, 5, 6, 7, 8, 10, 10, 12, 
				12, 15, 16, 18, 20, 20, 24, 25, 30));
		List<Integer> actual = numberList;
		assertEquals(expected, actual);
	}
	
	@Test
	void removeEveryNthElement_PassingZero_ThrowsIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> 
			{GenericCollections.removeEveryNthElement(charList, 0);});
	}
	
	@Test
	void removeEveryNthElement_PassingNegativeNumber_ThrowsIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> 
			{GenericCollections.removeEveryNthElement(numberList, -5);});
	}
	
	@Test
	void removeEveryNthElement_PassingNull_ThrowsNullPointerException() {
		numberList = null;
		assertThrows(NullPointerException.class, () -> {GenericCollections.modify(numberList);});
	}

	@Test
	void removeEveryNthElement_PassingEmptyList_EmptyListUnchanged() {
		charList = new ArrayList<>(Arrays.asList(' '));
		GenericCollections.removeEveryNthElement(charList, 5);
		List<Character> expected = new ArrayList<>(Arrays.asList(' '));
		List<Character> actual = charList;
		assertEquals(expected, actual);		
	}
	
	@Test
	void removeEveryNthElement_PassingListOfWholeNumbersAndNumber5_RemovesEveryFifthElement() {
		numberList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		GenericCollections.removeEveryNthElement(numberList, 5);
		List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 6, 7, 8, 9));
		List<Integer> actual = numberList;
		assertEquals(expected, actual);
	}
	
	@Test
	void removeEveryNthElement_PassingListOfStringsAndNumber2_RemovesEverySecondElement() {
		List<String> stringList = new ArrayList<>(Arrays.asList("XX", "YY", "ZZ",
				"AA", "BB", "CC"));
		GenericCollections.removeEveryNthElement(stringList, 2);
		List<String> expected = new ArrayList<>(Arrays.asList("XX", "ZZ", "BB"));
		List<String> actual = stringList;
		assertEquals(expected, actual);
	}
	
	@Test
	void removeEveryNthElement_PassingListOfCharactersAndNumber3_RemovesEvery3rdElement() {
		charList = new ArrayList<>(Arrays.asList('C', 'H', 'A', 'R', 
				'L', 'O', 'T', 'T', 'E'));
		GenericCollections.removeEveryNthElement(charList, 3);
		List<Character> expected = new ArrayList<>(Arrays.asList('C', 'H', 'R', 'L', 
				'T', 'T'));
		List<Character> actual = charList;
		assertEquals(expected, actual);	
	}
	
	@Test
	void removeEveryNthElement_PassingListOfDoublesAndNumber4_RemovesEveryFourthElement() {
		List<Double> doubleList = new ArrayList<>(Arrays.asList(1.1, 1.2, 1.3, 1.4, 1.5,
				1.6, 1.7, 1.8, 1.9, 2.0));
		GenericCollections.removeEveryNthElement(doubleList, 4);
		List<Double> expected = new ArrayList<>(Arrays.asList(1.1, 1.2, 1.3, 1.5, 1.6, 1.7, 1.9, 2.0));
		List<Double> actual = doubleList;
		assertEquals(expected, actual);
	}
	
	@Test
	void removeEveryNthElement_PassingListOfWholeNumbersAndNumber3_RemovesEveryThirdElement() {
		List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 1, 3, 3, 5, 5, 7, 7, 9, 9, 11, 11));
		GenericCollections.removeEveryNthElement(numbers, 3);
		List<Integer> expected = new ArrayList<>(Arrays.asList(1, 1, 3, 5, 7, 7, 9, 11));
		List<Integer> actual = numbers;
		assertEquals(expected, actual);
	}
}
