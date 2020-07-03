package findOdd;

public class FindOdd {

	public static void main(String[] args) {
		System.out.println("Odd integer from array: " + findIt(new int[] { 1, 1, 2, -2, 5, 2, 4, 4, -1, -2, 5 }));
		System.out.println(findIt(new int[] { 10 }));
		System.out.println("Odd integer from array using second method: " 
				+ findItTwo(new int[] { 1, 1, 2, -2, 5, 2, 4, 4, -1, -2, 5 }));

	}

	/**
	 * Finds and returns the value that appears an odd number of times in the array.
	 * @param a array of numbers
	 * @return number that appears an odd number of times 
	 */
	public static int findIt(int[] a) {
		int odd = 0;
		for (int i = 0; i < a.length; i++) {
			int count = 0;
			int temp = a[i];
			for (int j = a.length - 1; j >= 0; j--) {
				if (a[j] == temp) {
					count++;
				}
			}
			if (count % 2 == 1) {
				odd = temp;
			}
		}
		return odd;
	}

	/** 
	 * omg what even is this..need to find out what that operator does...
	 * ^= --> bitwise exclusive OR and assignment operator.
	 * @param A
	 * @return
	 */
	public static int findItTwo(int[] A) {
		int odd = 0;

		for (int i : A) {
			odd ^= i;
		}

		return odd;
	}
}
