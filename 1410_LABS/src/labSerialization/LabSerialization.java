package labSerialization;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * LabSerialization demonstrates how to serialize and deserialize a custom
 * object that references other objects on the heap. Author(s): Starter Code +
 * ........... // fill in your name
 */
public class LabSerialization {
	public static void main(String[] args) {
		ListVsSetDemo demo = new ListVsSetDemo(new ColoredSquare(4, Color.RED), 
				new ColoredSquare(6, Color.BLUE),
				new ColoredSquare(4, Color.RED), 
				new ColoredSquare(8, Color.YELLOW));

		serialize(demo, "Demo.ser");
		System.out.println("Object has been serialized.\n");
		ListVsSetDemo newDemo = deserialize("Demo.ser");
		displayListAndSet(newDemo);
		
	};

	/**
	 * Displays the elements of the list and the set.
	 */
	private static void displayListAndSet(ListVsSetDemo demo) {
		System.out.println("List:");
		System.out.println(demo.getListElements());
		System.out.println("Set:");
		System.out.println(demo.getSetElements());
	}

	private static void serialize(ListVsSetDemo demo, String filename) {
		try (ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(filename))) {
			obj.writeObject(demo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static ListVsSetDemo deserialize(String filename) {
		ListVsSetDemo deserialized = null;
		try ( ObjectInputStream obj = new ObjectInputStream(new FileInputStream(filename))) {
			deserialized = (ListVsSetDemo) obj.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} 
		return deserialized;
	}
}
