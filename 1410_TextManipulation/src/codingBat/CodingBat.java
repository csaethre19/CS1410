package codingBat;
/**
 * Given a string and a non-empty word string, 
 * creates a string made of each char just before and just after every appearance of the word in the string. 
 * Ignores cases where there is no char before or after the word, 
 * and a char may be included twice if it is between two words.
 * 
 * @author Charlotte Saethre
 *
 */
public class CodingBat {

	/**
	 * Creates a string made of char before and after every appearance of word in string.
	 * 
	 * @param str		string used to create new string
	 * @param word		non-empty word string we look for in the first string
	 * @return			string made of char before/after word in str
	 */
	public static String wordEnds(String str, String word) {
		StringBuilder sb = new StringBuilder();
		int strLen = str.length();
		int wordLen = word.length();
		int difference = strLen - wordLen;
		
		for(int i = 0; i < difference + 1; i++) {
			String temp = str.substring(i, i + wordLen);
			if(i > 0 && temp.equals(word)) {
				sb.append(str.substring(i - 1, i));
			}
			if(i < difference && temp.equals(word)) {
				sb.append(str.substring(i + wordLen, i + wordLen + 1));
			}
		}
		
		return sb.toString();
	}
}
