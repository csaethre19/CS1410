package recursion;

import java.util.Arrays;

/**
 * 
 * Defines three methods that use recursion to determine; the sum of a given
 * digit, count a pair of colon with close parentheses (as a smile) in a
 * character array, and create a new string based off an original string that
 * contains the upper case letters and an extra space.
 * 
 * @author Charlotte Saethre
 *
 */
public class Recursion {

	/**
	 * 
	 * Determines the sum of digits for a number.
	 * 
	 * @param n integer number
	 * @return sum of digits
	 */
	public static int sumOfDigits(int n) {
		if (n < 10) {
			return n;
		} else {
			return sumOfDigits(n / 10) + sumOfDigits(n % 10);
		}
	}

	/**
	 * 
	 * Counts smiles in an array of characters.
	 * 
	 * @param numbers array of characters
	 * @return number of smiles found
	 */
	public static int countSmiles(char[] numbers) {
		int arrayLen = numbers.length;
		if (arrayLen < 2) {
			return 0;
		}
		if (numbers[0] == ':' && numbers[1] == ')') {
			return 1 + countSmiles((Arrays.copyOfRange(numbers, 2, numbers.length)));
		} else {
			return countSmiles((Arrays.copyOfRange(numbers, 1, numbers.length)));
		}
	}

	/**
	 * 
	 * Takes in a string and creates a new string based off the original string that
	 * has an extra space and all characters changed to upper case.
	 * 
	 * @param str string that is used to create new string
	 * @return string based off original string with extra space and upper case
	 *         characters
	 */
	public static String toUpper(String str) {
		int strLen = str.length();
		if (strLen < 1) {
			return "";
		} else {
			return Character.toUpperCase(str.charAt(0)) + " " + toUpper(str.substring(1));
		}

	}
}
