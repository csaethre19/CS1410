package hashmapExample;

import java.util.HashMap;
/**
 * Hashmap is a data structure that holds key value pairs.
 * @author charl
 *
 */
public class HashMapExample {

	public static void main(String[] args) {
		HashMap<String, Integer> phonebook = new HashMap<String, Integer>();
		//to add values to hashmap use put method
		phonebook.put("Kevin", 12345);
		phonebook.put("Brenda", 123123);
		phonebook.put("Jill", 3654);
		//hashmaps are unordered, stored by contents not by position
		//hashmaps do not allow duplicate keys!
		System.out.println(phonebook);
		if (phonebook.containsKey("Kevin")) {
			System.out.println("Removing ... ");
			phonebook.remove("Kevin");
		}
		System.out.println(phonebook);
		//to empty hashmap
		phonebook.clear();
		System.out.println(phonebook.isEmpty());
	}

}
