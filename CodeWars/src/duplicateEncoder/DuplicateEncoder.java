package duplicateEncoder;

public class DuplicateEncoder {

	public static void main(String[] args) {
		System.out.println(encode("Prespecialized"));
	}

	/**
	 * if char appears once --> "(" if char appears more than once --> ")" example:
	 * "din"-->"((("
	 * 
	 * @param word
	 * @return
	 */
	static String encode(String word) {
		word = word.toLowerCase();
		String result = "";
		
		for (int i = 0; i < word.length(); i++) {
			int count = 0;
			char temp = word.charAt(i);
			for (int j = word.length() - 1; j >= 0; j--) {
				if (word.charAt(j) == temp) {
					count++;
				}
			}
			if (count > 1) {
				result += ")";
			}
			else {
				result += "(";
			}
		}
		
		word = result;
		return word;
	}
}
