package ioURL;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
/**
 * Uses BufferedReader, BufferedWriter, and InputStream to read and write from a URL.
 * @author Charlotte Saethre
 *
 */
public class DemoURLAccess {
	private static int PAGE_LENGTH = 35;

	public static void main(String args[]) {
		String urlString = "https://www.gutenberg.org/files/46768/46768-0.txt";
		try {
			URL url = new URL(urlString);
			try (InputStream stream = url.openStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
				BufferedWriter writer = new BufferedWriter(new FileWriter("Demo.txt"));
				Scanner sc = new Scanner(System.in)) {
				String line;
				String userInput = "";
				int page = 0;
				while (((line = reader.readLine()) != null)) {
					System.out.println(reader.readLine());
					page++;
					writer.write(line + "\n");
					if (page == PAGE_LENGTH) {
						System.out.println("\n- - - Press Enter to continue - - -");
						userInput = sc.nextLine();
						page = 0;
					}
				}
			}
		} catch (MalformedURLException e) {
			System.out.println("We encountered a problem regarding the following URL:\n" + urlString
					+ "\nEither no legal protocol could be found or the string could not be parsed.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(
					"Attempting to open a stream from the following URL:\n" + urlString + "\ncaused a problem.");
			e.printStackTrace();
		}

	}
}
