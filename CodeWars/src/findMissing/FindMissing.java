package findMissing;

import java.util.ArrayList;
import java.util.List;

public class FindMissing {

	public static void main(String[] args) {
		int[] first = new int[] {4, 12, 9, 5, 6};
		int[] second = new int[] {4, 9, 12, 6};
		//--> return 5
		
		System.out.println("Missing element using first method: " + findMissing(first,second));
		System.out.println("Missing element using second method: " + findMissingTwo(first,second));

		System.out.println("Reversing the string: Holland\n" + reverse("Holland"));
	}

	/**
	 * Compares two lists of numbers to determine what element is missing
	 * from the second list. It is assumed that all elements are unique and that 
	 * the second list will be missing exactly one element from the first list. 
	 * 
	 * @param first first array of numbers
	 * @param second second array of numbers
	 * @return the missing element
	 */
	public static int findMissing(int[] first, int[] second) {
		int sumOfFirst = 0;
		for (int i  = 0; i < first.length; i++) {
			sumOfFirst += first[i];
		}
		
		int sumOfSecond = 0;
		for (int i  = 0; i < second.length; i++) {
			sumOfSecond += second[i];
		}

		return sumOfFirst - sumOfSecond;
	}
	
	/**
	 * Functionality is same as above, but takes a different approach.
	 * 
	 * @param first first array of numbers
	 * @param second second array of numbers
	 * @return the missing element
	 */
	public static int findMissingTwo(int[] first, int[] second) {
		int result = 0;
		List<Integer> numbers = new ArrayList<>();
		List<Integer> secondNumbers = new ArrayList<>();

		for (int i : first) {
			numbers.add(i);
		}
		for (int i : second) {
			secondNumbers.add(i);
		}
		numbers.removeAll(secondNumbers);
		for (int i : numbers) {
			result = i;
		}
		return result;
	}
	
	/**
	 * Reverses a given string. 
	 * 
	 * @param str string to be reversed
	 * @return the string reversed
	 */
	public static String reverse(String str) {
		String result = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			result += str.charAt(i);
		}
		return result;
	}
}
