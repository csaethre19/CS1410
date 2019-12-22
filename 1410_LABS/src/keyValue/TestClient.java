package keyValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * Tests the functionality of the class KeyValuePair that implements Comparable.
 * @author Charlotte Saethre
 *
 */
public class TestClient {

	public static void main(String[] args) {
		System.out.println("Phase 1");
		System.out.println("---------");
		KeyValuePair<String, Integer> p1 = new KeyValuePair<>("SLC", 189899);
		KeyValuePair<String, Integer> p2 = new KeyValuePair<>("NY", 8244910);
		System.out.println("p1: " + p1);
		System.out.println("p2: " + p2);
		System.out.println("p1.equals(p2): " + p1.equals(p2));
		
		System.out.println();
		
		KeyValuePair<String, Integer> p3 = p2;
		System.out.println("p3: " + p3);
		System.out.println("p2.equals(p3): " + p2.equals(p3) + "\n");
		
		System.out.println();
		
		System.out.println("Phase 2");
		System.out.println("---------");
		KeyValuePair<String, Integer> p4 = new KeyValuePair<>("LA", 3819702);
		KeyValuePair<String, Integer> p5 = new KeyValuePair<>("SF", 812826);
		List<KeyValuePair<String, Integer>> cities = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5));
		System.out.println("Original List:");
		cities.forEach(el -> System.out.println(el));
		System.out.println();
		Collections.sort(cities);
		System.out.println("Sorted List:");
		cities.forEach(el -> System.out.println(el));
		
		System.out.println();
		System.out.println();
		
		System.out.println("Phase 3");
		System.out.println("---------");
		System.out.println("Cities with margin 5:");
		printWithMargin(cities, 5);
		
		System.out.println();
		
		KeyValuePair<Integer, String> p6 = new KeyValuePair<>(30, "Geece");
		KeyValuePair<Integer, String> p7 = new KeyValuePair<>(33, "France");
		KeyValuePair<Integer, String> p8 = new KeyValuePair<>(43, "Austria");
		
		Set<KeyValuePair<Integer, String>> countryCodes = new HashSet<>();
		countryCodes.add(p6);
		countryCodes.add(p7);
		countryCodes.add(p8);
		System.out.println("Country codes with margin 3:");
		printWithMargin(countryCodes, 3);
		
	}

	private static <T> void printWithMargin(Collection<T> collection, int indentation) {
		for (T el : collection) {
			for (int i = 0; i < indentation; i++) {
				System.out.print(" ");
			}
			System.out.println(el);
		}
	}
}
