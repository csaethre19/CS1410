package fileExample;

import java.io.File;
import java.io.IOException;

public class FileCreationExample {

	public static void main(String[] args) {
		
		File myFile = new File("C:\\Users\\charl\\Desktop\\myFile.txt");
		try {
			boolean fileCreated = myFile.createNewFile();
			System.out.println(fileCreated);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
