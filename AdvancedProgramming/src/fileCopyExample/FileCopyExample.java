package fileCopyExample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.*;

public class FileCopyExample {

	public static void main(String[] args) {
		Path source = Paths.get("C:\\Users\\charl\\Desktop\\myFiles\\myFile.txt");
		Path dest = Paths.get("C:\\Users\\charl\\Desktop\\myFiles\\new.txt");
		try {
			Files.copy(source, dest, REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
