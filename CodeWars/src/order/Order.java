package order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Order {

	public static void main(String[] args) {
		System.out.println(order("is2 Thi1s T4est 3a"));

	}

	/**
	 * Sorts words in a given string according to the single number contained 
	 * in each word. All words will have a single digit 1-9 to order by.
	 * @param words
	 * @return
	 */
	public static String order(String words) {
		if (words.isEmpty()) return "";
		String[] singleWords = words.split(" ");
		String[] orderedWords = new String[singleWords.length];
		String result = "";
		for(String s: singleWords) {
			for (int i = 0; i < s.length(); i++) {
				if (Character.isDigit(s.charAt(i))) {
					int index = Integer.parseInt(s.substring(i, i + 1));
					orderedWords[index - 1] = s;
				}
			}
		}
		for (int i = 0; i < orderedWords.length; i++) {
			if (i == orderedWords.length - 1) {
				result += orderedWords[i];
			}
			else {
				result += orderedWords[i] + " ";
			}
		}

		return result;
	}
}
