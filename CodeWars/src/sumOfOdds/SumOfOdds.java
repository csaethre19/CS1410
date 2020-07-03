package sumOfOdds;

public class SumOfOdds {

	public static void main(String[] args) {
		System.out.println(rowSumOddNumbers(42));
		// printOddTriangle(42);
	}

	public static int rowSumOddNumbers(int n) {
		int oddIndex = 1;
		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				if (i < n - 1) {
					oddIndex += 2;
				} else {
					result += oddIndex;
					oddIndex += 2;
				}
			}
		}
		return result;
	}

	/**
	 * This is VERY interesting!
	 * @param n
	 * @return
	 */
	private static int rowSumOddNumbersTwo(int n) {
		return (int)Math.pow(n, 3);
	}
	
	private static void printOddTriangle(int n) {
		int oddIndex = 1;
		for (int i = 1; i < n; i++) {
			System.out.print(" ");
			for (int j = 0; j < i; j++) {
				System.out.print(oddIndex + " ");
				oddIndex += 2;
			}
			System.out.println();
		}
	}
}
