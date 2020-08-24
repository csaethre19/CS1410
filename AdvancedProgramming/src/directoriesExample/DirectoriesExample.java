package directoriesExample;

import java.io.File;
import java.io.FilenameFilter;

public class DirectoriesExample {

	public static void main(String[] args) {
		
		//FilenameFilter is functional interface (meaning only one method to implement)
		//the method to implement is called accept
		//this example uses a lambda to implement this
		//FilenameFilter is the interface, filter is the name of the variable 
		//we are passing two arguments to overriden method accept
		//and the code block contains just a simple return statement 
		//any files containing a period will be returned.
		FilenameFilter filter1 = new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				return false;
			}
			
		};
		FilenameFilter filter = (file, fileName) -> {
			return fileName.contains(".");
		};
		
		//array containing the name of every item in current directory
		//we are passing our filter object as an argument to the list method 
		//filter will return true/false if the file has a period in it
		//if true it goes into the string array "contents"
		String[] contents = new File(".").list(filter);
		for (String file : contents) {
			System.out.println(file);
		}
		new File("myDirectory").mkdir();
	}

}
