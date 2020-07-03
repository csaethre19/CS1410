package jadenCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Jaden Smith, the son of Will Smith, is the star of films such as The Karate
 * Kid (2010) and After Earth (2013). Jaden is also known for some of his
 * philosophy that he delivers via Twitter. When writing on Twitter, he is known
 * for almost always capitalizing every word. For simplicity, you'll have to
 * capitalize each word, check out how contractions are expected to be in the
 * example below. Your task is to convert strings to how they would be written
 * by Jaden Smith. The strings are actual quotes from Jaden Smith, but they are
 * not capitalized in the same way he originally typed them.
 * 
 * Example: Not Jaden-Cased: "How can mirrors be real if our eyes aren't real"
 * Jaden-Cased: "How Can Mirrors Be Real If Our Eyes Aren't Real"
 * 
 * @author charl
 *
 */
public class JadenCase {

	public static void main(String[] args) {
		System.out.println(toJadenCaseTwo("How can mirrors be real if our eyes aren't real"));
		System.out.println(toJadenCase("Most Trees Are Blue"));
		System.out.println(toJadenCaseThree("How can mirrors be real if our eyes aren't real"));

	}

	/**
	 * Modifies phrase so that each word is uppercase while the rest are lower case.
	 * 
	 * @param phrase phrase to be modified
	 * @return modified phrase
	 */
	public static String toJadenCase(String phrase) {
		String result = "";
		String finalResult = "";
		if ((phrase == null) || (phrase == "")) {
			finalResult = null;
		} else {
			String[] newPhrase = phrase.split(" ");
			for (String s : newPhrase) {
				for (int i = 0; i < s.length(); i++) {
					if (i == 0) {
						result += Character.toUpperCase(s.charAt(i));
					} else {
						result += s.charAt(i);
					}
				}
				result += " ";
			}
			finalResult = result.trim();
		}

		return finalResult;
	}

	public static String toJadenCaseTwo(String phrase) {
		if (phrase == null || phrase.equals(""))
			return null;

		char[] jadenArray = phrase.toCharArray();
		for (int i = 0; i < jadenArray.length; i++) {
			if (i == 0 || jadenArray[i - 1] == ' ') {
				jadenArray[i] = Character.toUpperCase(jadenArray[i]);
			}
		}

		return new String(jadenArray);
	}

	public static String toJadenCaseThree(String phrase) {
		if (phrase == null || phrase.isEmpty()) {
			return null;
		}

		List<String> result = new ArrayList<>();
		for (String s : phrase.split(" ")) {
			result.add(s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase());
		}

		return String.join(" ", result);
	}
}
