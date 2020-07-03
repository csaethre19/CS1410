package panagram;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A pangram is a sentence that contains every single letter of the alphabet at
 * least once. For example, the sentence "The quick brown fox jumps over the
 * lazy dog" is a pangram, because it uses the letters A-Z at least once (case
 * is irrelevant).
 * 
 * @author charl
 *
 */
public class PanagramChecker {

	/**
	 * Determines if a given string ia  panagram or not. 
	 * @param sentence
	 * @return
	 */
	public boolean check(String sentence) {
		char[] letters = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
				'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 
				'u', 'v', 'w', 'x', 'y', 'z'};
		List<Character> alphabet = new ArrayList<>();
		for (int i = 0; i < letters.length; i++) {
			alphabet.add(letters[i]);
		}
		List<Character> temp = new ArrayList<>();
		for (int i = 0; i < sentence.length(); i++) {
			if (Character.isLetter(sentence.charAt(i))) {
				temp.add(Character.toLowerCase(sentence.charAt(i)));
			}
		}
		Set<Character> noDuplicates = new HashSet<>(temp);
		return noDuplicates.containsAll(alphabet);
	}
}
