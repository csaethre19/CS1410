package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Demonstrates the use of generic collections with the three methods,
 * <code>lettersAndNumbers</code> which returns a new list of type 
 * String from a list of characters,
 * <code>modify</code> which changes a list of type 
 * Integer and returns the number of unique elements in modified list, 
 * and <code>removeEveryNthElement</code> which takes a list of an unknown generic type and
 * removes every nth element. 
 * 
 * @author Charlotte Saethre
 *
 */
public class GenericCollections {
	/**
	 * Creates a new list based on the list passed based on a set of rules: 1. Any
	 * characters that are neither numbers or letters are ignored. 2. New list
	 * includes string representations of of each character that is a letter or a
	 * number but in reverse order. 3. Each lowercase letter is represented as:
	 * L({letter}) 4. Each uppercase letter is represented as: U({letter}) 5. Each
	 * number is represented as: N({number}) 6. An empty list returns an empty
	 * string. 7. If argument passed is null, return value will be null.
	 * 
	 * @param list list
	 * @return List of Strings
	 */
	public static List<String> lettersAndNumbers(List<Character> list) {
		if (list == null) {
			return null;
		}
		List<String> newList = new ArrayList<>();
		List<Character> tempCharList = list;
		tempCharList.removeIf(el -> specialCharChecker(el));

		if (tempCharList.isEmpty()) {
			newList.add("");
		}

		for (Character el : tempCharList) {
			if (Character.isLetter(el)) {

				if (Character.isUpperCase(el)) {
					newList.add("U(" + Character.toLowerCase(el) + ")");
				} else {
					newList.add("L(" + el + ")");
				}
			}

			if (Character.isDigit(el)) {
				newList.add("N(" + el + ")");
			}
		}
		Collections.reverse(newList);

		return newList;
	}

	/**
	 * Modifies list by implementing changes based on a set of rules: 1. If list is
	 * null, NullPointerException will be thrown. 2. Deletes all multiples of 3. 3.
	 * Adds the first 5 multiples of 4, 5, and 6. 4. Sort list in ascending order.
	 * 
	 * @param list list
	 * @throws NullPointerException if list is null
	 * @return number of unique elements in modified list
	 */
	public static int modify(List<Integer> list) {
		if (list.equals(null))
			throw new NullPointerException("list must not be null.");

		list.removeIf(n -> n % 3 == 0);

		addFirstFiveMultiplesOf4And5And6(list);

		Collections.sort(list);
		Set<Integer> noDuplicates = new HashSet<>();
		list.forEach(n -> noDuplicates.add(n));
		return noDuplicates.size();
	}

	private static void addFirstFiveMultiplesOf4And5And6(List<Integer> list) {
		int multipleOfFour = 4;
		int multipleOfFive = 5;
		int multipleOfSix = 6;

		for (int i = 0; i < 5; i++) {
			list.add(multipleOfFour);
			list.add(multipleOfFive);
			list.add(multipleOfSix);
			multipleOfFour += 4;
			multipleOfFive += 5;
			multipleOfSix += 6;
		}
	}

	/**
	 * Modifies list by removing every nth number.
	 * 
	 * @param list list
	 * @param n nth number to be removed
	 * @throws IllegalArgumentException if n is zero or negative
	 * @throws NullPointerException     if list is null
	 */
	public static void removeEveryNthElement(List<?> list, int n) {
		if (n <= 0)
			throw new IllegalArgumentException("number must not be negative or zero.");
		if (list.equals(null))
			throw new NullPointerException("list must not be null.");

		for (int i = list.size()/n*n - 1; i >= 0; i-= n) {
			list.remove(i);
		}
				
	}
	
	private static boolean specialCharChecker(char c) {
		String specialChar = "~`!@#$%^&*()-_";
		boolean isSpecialChar = false;
		for (int i = 0; i < specialChar.length(); i++) {
			if (specialChar.charAt(i) == c) {
				isSpecialChar = true;
			}
		}
		return isSpecialChar;
	}
}
