package docComments;
/**
 * Represents a specific Car with make, model, and miles per gallon.
 * 
 * @author Charlotte Saethre
 *
 */
public class Car {
	
	private String make;
	private String model;
	private int mpg;
	
	/**
	 * Initializes fields
	 * 
	 * @param make
	 * @param model
	 * @param mpg
	 */
	public Car(String make, String model, int mpg) {
		this.make = make;
		this.model = model;
		this.mpg = mpg;
	}

	/**
	 * Returns make of car
	 * 
	 * @return	make of car
	 */
	public String getMake() {
		return make;
	}

	/**
	 * Returns model of car
	 * 
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * Returns	miles per gallon
	 * 
	 * @return	mpg
	 */
	public int getMpg() {
		return mpg;
	}
	
	

}
