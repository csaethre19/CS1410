package sumDigPower;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumDigPower {

	public static void main(String[] args) {
		System.out.println(sumDigPow(50, 3600));
		// sumDigPow(90, 150);
	}

	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static List<Long> sumDigPow(long a, long b) {
		List<Long> list = new ArrayList<>();
		int len = (int) (b - a);
		long[] longList = new long[len];
		int start = (int) a;
		for (int i = 0; i < longList.length; i++) {
			longList[i] = start++;
		}

		for (int i = 0; i < longList.length; i++) {
			String[] singleNumStr = Long.toString(a++).split("");
			int index = 0;
			int pow = 1;
			long result = 0;
			for (int j = 0; j < singleNumStr.length; j++) {
				result += Math.pow(Long.parseLong(singleNumStr[index++]), pow++);
			}
			if (result == longList[i]) {
				list.add(result);
			}
		}
		return list;
	}
}
