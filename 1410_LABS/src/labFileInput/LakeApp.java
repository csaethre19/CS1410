package labFileInput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Reads in data records from the csv file and prints the lakes.
 * 
 * @author Charlotte Saethre
 *
 */
public class LakeApp {
	public static void main(String[] args) {
		List<Lake> lakes = new ArrayList<>();
		
		try (Scanner reader = new Scanner(LakeApp.class.getResourceAsStream("Lakes.csv"))) {
			while (reader.hasNext()) {
				Lake lake = Lake.getLake(reader.nextLine());
				if (lake != null) {
					lakes.add(lake);
				}
			}
		}
		
		for (Lake el : lakes) {
			System.out.println(el);
		}
		
	}
}
