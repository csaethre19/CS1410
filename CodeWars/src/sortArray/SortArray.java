package sortArray;

import java.util.Arrays;

public class SortArray {

	public static void main(String[] args) {
		int[] array = { 5, 3, 2, 8, 1, 4 };
		int[] array2 = { 2, 5, 3, 8, 1, 4 };
		int[] emptyArray = {};
		System.out.println("original: " + Arrays.toString(array));
		System.out.println("odds sorted: " + Arrays.toString(sortArray(array)));
		System.out.println("odds sorted: " + Arrays.toString(sortArray(emptyArray)));
		System.out.println("original 2: " + Arrays.toString(array2));
		System.out.println("odds sorted: " + Arrays.toString(sortArray2(array2)));

	}

	/**
	 * sorts odd numbers only in ascending order. Even numbers in the list remain in
	 * the same position.
	 * 
	 * @param array array of numbers
	 * @return array of numbers
	 */
	public static int[] sortArray(int[] array) {
		if (array.length == 0) {
			return array;
		} else {
			int maxVal = 0, maxIndex = 0, minVal = 0, minIndex = 0;
			for (int i = 0; i < array.length; i++) {
				if (!(array[i] % 2 == 0)) {
					if (array[i] < maxVal) {
						if (array[i] < minVal) {
							minVal = array[i];
							array[i] = array[maxIndex];
							array[maxIndex] = array[minIndex];
							array[minIndex] = minVal;
							minIndex = i;
						} else {
							minVal = array[i];
							array[i] = array[maxIndex];
							array[maxIndex] = minVal;
							minIndex = maxIndex;
							maxIndex = i;
						}
					}
				}
			}
		}
		return array;
	}

	/** 
	 * this one passed tests...
	 * @param array
	 * @return
	 */
	public static int[] sortArray2(int[] array) {
		if (array.length == 0) {
			return array;
		} else {
			int oddCount = 0;
			for (int i = 0; i < array.length; i++) {
				if (!(array[i] % 2 == 0)) {
					oddCount++;
				}
			}
			int[] odds = new int[oddCount];
			int j = 0;
			for (int i = 0; i < array.length; i++) {
				if (!(array[i] % 2 == 0)) {
					odds[j] = array[i];
					j++;
				}
			}
			Arrays.sort(odds);
			j = 0;
			for (int i = 0; i < array.length; i++) {
				if (!(array[i] % 2 == 0)) {
					array[i] = odds[j];
					j++;
				}
			}
		}
		return array;
	}
}
