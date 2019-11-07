package phones;

import java.util.Random;

public class TestClient {

	public static void main(String[] args) {
		RotaryPhone rotary = new RotaryPhone("Model 500", 
				new Dimension(143, 208, 119), Voltage.V110);
		PushButtonPhone pushButton = new PushButtonPhone("Cortelco 2500",  
				new Dimension(178, 228, 127), Voltage.DUAL);
		SmartPhone pixel3 = new SmartPhone("Pixel3", 
				new Dimension(145.6, 68.2, 7.9), 128);
		SmartPhone iphone8 = new SmartPhone("iphone8", 
				new Dimension(138.4, 67.3, 7.3), 64);
		
		System.out.println("Various Phones: ");
		System.out.println(rotary.toString());
		System.out.println(pushButton.toString());
		System.out.println(pixel3.toString());
		System.out.println(iphone8.toString());
		
		System.out.println();
		
		rotary.plugIn();
		pushButton.plugIn();
		
		Random rand = new Random();
		int random = rand.nextInt(11) + 1;
		if (random <= 5) {
			rotary.unplug();
		}
		else {
			pushButton.unplug();
		}
		
		Phone[] phoneArray = {rotary, pushButton, pixel3, iphone8};
		
		System.out.println("Array Elements:");
		for (Phone phone : phoneArray) {
			System.out.println(phone.toString());
			System.out.println(phone.call(8019754111L));

			if(phone instanceof SmartPhone) {
				System.out.println(((SmartPhone) phone).browse());
				System.out.println(((SmartPhone) phone).takePicture());
				
			}
			System.out.println();
		}

	}

}
