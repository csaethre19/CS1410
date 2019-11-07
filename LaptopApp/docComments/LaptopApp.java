package docComments;

import java.util.Scanner;
/**
 * 
 * Represents an application that allows user to;
 * display list of laptops, 
 * look up and delete a laptop,
 * and display how many laptops are in list.
 * 
 * @author Charlotte Saethre and Kim H
 *
 */
public class LaptopApp {
	public static LaptopList list = new LaptopList();
	static Scanner sc = new Scanner(System.in);

	/**
	 * 
	 * Displays user menu.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		displayMenu();
	}

	private static void displayMenu() {
		int selection = 999;
		
		while (selection != 6) {
			System.out.println("\n1. Show all laptops"
					+ "\n2. Add a laptop\n3. Find a laptop"
					+ "\n4. Delete a laptop"
					+ "\n5. How many laptops"
					+ "\n6. Exit"
					+ "\nEnter your selection: ");
			selection = sc.nextInt();
			
			System.out.println();
			
				switch (selection) {
				case 1: 
					displayLaptops();
					break;
				case 2:
					System.out.println("Manufacturer: ");
					String make = sc.next();
					System.out.println("Series: ");
					String series = sc.next();
					System.out.println("Model Number: ");
					String model = sc.next();
					addLaptop(make, series, model);
					break;
				case 3:
					System.out.println("Id: ");
					int id = sc.nextInt();
					findLaptop(id);
					break;
				case 4:
					System.out.println("Id: ");
					id = sc.nextInt();
					deleteLaptop(id);
					break;
				case 5:
					laptopCount();
					break;
				case 6:
					System.out.println("Goodbye");
					break;
				default:
					System.out.println("Please enter 1-6");
				}		
		}
			
	}

	private static void displayLaptops() {
		for (Laptop el : list.laptop) {
			System.out.println(el);
		}
	}
	
	private static void addLaptop(String manufacturer, String series, String model) {
		Laptop userAdd = new Laptop(manufacturer, series, model);
		list.laptop.add(userAdd);
	}

	private static void findLaptop(int id) {
		boolean found = false;
		int foundLaptop = 0;
		for (Laptop el : list.laptop) {
			if (el.getID_NUMBER() == id) {
				found = true;
				foundLaptop = list.laptop.indexOf(el);
				break;
			}
		}
		if (found) {
			System.out.println(list.laptop.get(foundLaptop));

		} else {
			System.out.println("The id " + id + " could not be found");
		}
	}

	private static void deleteLaptop(int id) {
		boolean found = false;
		int foundLaptop = 0;
		for (Laptop el : list.laptop) {
			if (el.getID_NUMBER() == id) {
				found = true;
				foundLaptop = list.laptop.indexOf(el);
				break;
			}
		}
		if (found) {
			System.out.println(list.laptop.get(foundLaptop).getManufacturer()
					+ " " + list.laptop.get(foundLaptop).getSeries()
					+ " " + list.laptop.get(foundLaptop).getModelNumber()
					+ " has been deleted");
			list.laptop.remove(foundLaptop);

		} else {
			System.out.println("The id " + id + " could not be found");
		}
	}

	private static void laptopCount() {
		System.out.println("Number of laptops: " + list.laptop.size());
	}
}
