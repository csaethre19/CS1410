package kata;

public class Kata {

	public static void main(String[] args) {
		// System.out.println(findShort("I Don't Know"));
		System.out.println(solution("samurai", "ai"));
	}

	/**
	 * 
	 * @param s
	 * @return
	 */
	public static int findShort(String s) {
		String[] seperate = s.split(" ");

		int minCount = 999;
		for (int i = 0; i < seperate.length; i++) {
			int count = 0;
			for (int j = 0; j < seperate[i].length(); j++) {
				count++;
			}
			if (count < minCount) {
				minCount = count;
			}
		}

		return minCount;
	}

	/**
	 * Returns true if the first argument passed ends with the second argument.
	 * 
	 * @param str
	 * @param ending
	 * @return
	 */
	public static boolean solution(String str, String ending) {
		boolean result = false;
		if (str.length() >= ending.length()) {
			String temp = str.substring(str.length() - ending.length());
			result = temp.equals(ending);
		}
		return result;
	}
}
