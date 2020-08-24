package tryWithResourcesExample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
/**
 * Using try with resources over regular try catch block will ensure that 
 * all resources are closed.
 * If you can use try with resources, do so..
 * 
 * @author charl
 *
 */
public class TryWithResourcesExample {

	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader(new StringReader("Hello World"));
				StringWriter writer = new StringWriter();) {
			
			writer.write(reader.readLine());
			System.out.println(writer.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
