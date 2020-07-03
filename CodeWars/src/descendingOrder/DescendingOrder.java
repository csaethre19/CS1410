package descendingOrder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DescendingOrder {

	public static void main(String[] args) {
		System.out.println(sortDesc(21445));
		System.out.println(sortDesc(15));

	}

	/**
	 * 
	 * @param num
	 * @return
	 */
	public static int sortDesc(final int num) {
		Integer n = num;
		String numStr = n.toString();
		String numResult = "";
		List<String> numbers = new ArrayList<>();
		for (int i = 0; i <= numStr.length() + 1; i++) {
			if (i < numStr.length()) {
				String tempNum = numStr.substring(i, i + 1);
				numbers.add(tempNum);
			}
		}
		Collections.sort(numbers);
		Collections.reverse(numbers);

		for (String s : numbers) {
			numResult += s;
		}
		return Integer.parseInt(numResult);
	}
}
