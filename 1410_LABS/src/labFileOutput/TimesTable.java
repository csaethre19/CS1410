package labFileOutput;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TimesTable {

	public static void main(String[] args) {
		try (PrintWriter output = new PrintWriter("timesTable.txt")) {
			outputTables(output);
		} catch (FileNotFoundException e1) {
			System.err.println("Error: File not Found");
		}
	}

	private static void outputTables(PrintWriter output) {

		for (int p = 1; p <= 10; p += 2) {
			for (int i = 1; i <= 10; i++) {
				int s = p;
				for (int j = 1; j <= 2; j++) {
					output.format("%2d %s %2d %s %-2d \t\t", i, " * ", s, " = ", i * s);
					s++;
				}
				output.println();
			}
			output.println();
			

		}
	}

}
