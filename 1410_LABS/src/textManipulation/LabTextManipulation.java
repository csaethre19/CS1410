package textManipulation;

import java.util.ArrayList;
import java.util.Scanner;

public class LabTextManipulation {

	public static void main(String[] args) {

		ArrayList<String> parks = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);

		String selection = " ";
		while (!selection.equalsIgnoreCase("done")) {
			System.out.println("Please enter your favorite National Park or DONE to stop: ");

			selection = sc.nextLine();
			if (!selection.equalsIgnoreCase("done")) {
				parks.add(selection);
			}
		}
		sc.close();

		String nationalParks = "Favorite National Parks: ";
		StringBuilder sb = new StringBuilder();

		boolean first = true;
		for (String el : parks) {
			if (first) {
				sb.append(nationalParks + updateSpelling(el));
				first = false;
			} else {
				sb.append(" | " + updateSpelling(el));
			}
		}

		System.out.println(sb);
	}// End of Main

	private static String updateSpelling(String text) {

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < text.length(); i++) {
			if (i == 0) {
				sb.append(Character.toUpperCase(text.charAt(i)));
			} else if (i > 0 && text.charAt(i) == ' ') {
				sb.append(text.charAt(i));
				sb.append(Character.toUpperCase(text.charAt(++i)));
			} else {
				sb.append(Character.toLowerCase(text.charAt(i)));
			}
		}

		return sb.toString();
	}// End of update method

}// End of Class
