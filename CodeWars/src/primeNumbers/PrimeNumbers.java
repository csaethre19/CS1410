package primeNumbers;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers {

	public static void main(String[] args) {
		System.out.println(primeFactors(38160416));
		//System.out.println(primeFactors(1763));
		//System.out.println(primeFactors(7775460));
	}

	public static String primeFactors(int n) {
		// 1. input for n 
		// 2. square n is our max number to look at
		// 3. make a list called primeList
		// 4. Iterate through from 2 to max
		// 5. if n mod i == 0 --> add i to list
		// 6. set n to n/i
		String result = "";
		List<Integer> primeList = new ArrayList<>();
		for (int i = 2; i <= n; i++) {
			while (n % i == 0) {
				primeList.add(i);
				n = n/i;
			}
		}
		
		if (primeList.isEmpty()) {
			result += "(" + n + ")";
		}
		else {
			int count = 0;
			for (int i = 0; i < primeList.size(); i += count) {
				int temp = primeList.get(i);
				count = 0;
				for (int j = i; j < primeList.size(); j++) {
					if (temp == primeList.get(j)) {
						count++;
					}
				}
				if (count > 1) {
				result += "(" + temp + "**" + count + ")";
				}
				else {
					result += "(" + temp + ")";
				}
			}
		}
		return result;
	}
}
