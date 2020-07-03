package convertBinaryArrayToInt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertBinaryArrayToInt {
	public static void main (String[] args) {
		 List<Integer> numbers = new ArrayList<>(Arrays.asList(0, 0, 1, 0));
		 System.out.println(convertBinaryArrayToInt(numbers));
	}
	public static int convertBinaryArrayToInt(List<Integer> binary) {
		int result = 0;
		String bin = "";
		for (Integer n : binary) {
			bin += n + "";
		}
		result = Integer.parseInt(bin, 2);
		return result;
	}
}
