package hashmapExample;

import java.util.LinkedHashMap;
import java.util.Map;
/**
 * LinkedHashMap different than regular HashMap in that they keep track of 
 * the order of the entries. 
 * They are flexible in that you have the choice in accessing elements 
 * by when they were added or by when they were modified. 
 * 
 * @author charl
 *
 */
public class LinkedHashMapExample {

	public static void main(String[] args) {
		//first arg: initial capacity of map - 4 --> linkedhashmap with 4 entries created
		//second arg: load factor of map (specifies how full the map can be before increasing)
		//0.75f is default value --> when map is 75% full it will increase in size
		//third arg: specifies ordering mode (if false or not specified it will use insertion order)
		//returns elements in the order they were inserted into the map
		//if true it will use access order --> whatever is accessed most recently will be printed first
		LinkedHashMap<String, Integer> phonebook = new LinkedHashMap<String, Integer>(4, 0.75f, true);
		phonebook.put("Kevin", 12345);
		phonebook.put("Brenda", 123123);
		phonebook.put("Jill", 3654);
		System.out.println("Kevin's phone number: " + phonebook.get("Kevin"));
		
		System.out.println("\nList of contacts in phonebook: ");
		//foreach loop that iterates over all entries of map and prints key and value
		for (Map.Entry<String, Integer> entry : phonebook.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}

}
