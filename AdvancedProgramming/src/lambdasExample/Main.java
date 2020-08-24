package lambdasExample;
/**
 * When instantiating a functional interface eclipse will automatically generate 
 * an override of the abstract method right there. 
 * This is considered an annonymous inner class. 
 * After implementing the abstract method you can use your isntance to call on that method.
 * 
 * @author charl
 *
 */
public class Main {

	public static void main(String[] args) {
		//Annonymous inner class
		GreetingsMessage gm = new GreetingsMessage() {
			
			@Override
			public void greet(String name) {
				System.out.println("Hello " + name);
			}
		};
		
		gm.greet("Charlotte");
		
		//Second way using a lambda
		//this is the same as above but using the lambda (using less code)
		GreetingsMessage gm2 = (String name) -> {
			System.out.println("Hello " + name);
		};
		gm2.greet("Charlotte");
		
		MessagePrinter mp = () -> {
			System.out.println("This is a message");
		};
		mp.printMessage();
	}

}
