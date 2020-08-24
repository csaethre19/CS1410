package methodReferencesExample;

public class Square {

	private int sideLength;
	
	public Square(int sideLength) {
		this.sideLength = sideLength;
	}
	
	public int calculateArea() {
		return sideLength*sideLength;
	}
}
