package utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSV {

	/**
	 * Reads data from a CSV file and returns as a list.
	 */
	public static List<String[]> read(String file) {
		List<String[]> list = new ArrayList<>();
		String dataRow = "";
		try (Scanner read = new Scanner(CSV.class.getResourceAsStream(file))) {
			while (read.hasNext()) {
				dataRow = read.nextLine();
				String[] dataRecord = dataRow.split(",");
				list.add(dataRecord);
			}
		}
		return list;
	}
}
