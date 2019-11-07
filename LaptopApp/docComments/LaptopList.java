package docComments;

import java.util.ArrayList;
/**
 * Represents a list of Laptop objects.
 * 
 * @author Charlotte Saethre and Kim H
 *
 */
public class LaptopList {
	
	public ArrayList<Laptop> laptop = new ArrayList<Laptop>();
	
	/**
	 * Adds hard code options for Laptop objects to list.
	 * 
	 */
	public LaptopList() {
		laptop.add(new Laptop("Acer", "Aspire", "E15"));
		laptop.add(new Laptop("Dell", "Latitude", "E6530"));
		laptop.add(new Laptop("Mac", "Air", "A1466"));
		laptop.add(new Laptop("Lenovo", "IdeaPad", "S940"));
	}
	
}
