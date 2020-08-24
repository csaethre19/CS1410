package functionalInterfaceExample;
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
	}

}
