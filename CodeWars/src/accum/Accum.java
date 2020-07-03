package accum;

public class Accum {
	public static void main (String[] args) {
		 System.out.println(accum("abcdE"));
	}
	/**
	 * 
	 * @param s
	 * @return
	 */
	public static String accum(String s) {
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			if (i > 0) {
				result += "-" + Character.toUpperCase(s.charAt(i));
				for (int j = 0; j < i; j++) {
					result += Character.toLowerCase(s.charAt(i));
				}
			} else {
				result += Character.toUpperCase(s.charAt(i));
			}
		}

		return result;
	}
}
