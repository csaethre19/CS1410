package isogram;

public class Isogram {

	public static void main(String[] args) {
		System.out.println(isIsogram("moOse"));
	}

	public static boolean isIsogram(String str) {
		str = str.toLowerCase();
		for (int i = 0; i < str.length(); i++) {
			char temp = str.charAt(i);

			String sub = str.substring(i + 1);
			for (int j = 0; j < sub.length(); j++) {
				if (sub.charAt(j) == temp) {
					return false;
				}
			}
		}
		return true;
	}
}
