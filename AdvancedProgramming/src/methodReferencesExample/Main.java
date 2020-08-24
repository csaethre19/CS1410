package methodReferencesExample;

public class Main {

	public static void main(String[] args) {
		Square s = new Square(4);
		
		//using lambda like before
		Shapes shapes = (square) -> {
			return square.calculateArea();
		};
		
		//using method reference over lambda
		//Call on class that was being passed as arg
		//use two colons and then just the name of the method you are calling
		Shapes shapes2 = Square::calculateArea;
		
		//get same results
		System.out.println("Area: " + shapes.getArea(s));
		System.out.println("Area: " + shapes2.getArea(s));

	}

}
