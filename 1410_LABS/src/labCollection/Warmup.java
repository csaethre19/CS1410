package labCollection;

import java.util.ArrayList;
import java.util.List;
/**
 * Demonstrates different functionality of class Collection. 
 * 
 * @author Charlotte Saethre
 *
 */
public class Warmup {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		int even = 2;
		for (int i = 0; i < 25; i++) {
			numbers.add(even);
			even += 2;
		}
		printNumberList(numbers);
		
		System.out.println();
		
		numbers.removeIf(x -> x % 3 == 0);
		System.out.println("Removing multiple of threes . . .");
		printNumberList(numbers);
	}

	private static void printNumberList(List<Integer> numbers) {
		System.out.print("numbers:");
		numbers.forEach(n -> System.out.print(n + " "));
	}

}
