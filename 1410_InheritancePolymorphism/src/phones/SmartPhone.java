package phones;
import java.util.Random;
/**
 * Describes a cellular phone that is also described as a smart phone. 
 * This type of phone allows you to take pictures, browse the web, and make calls.
 * 
 * @author Charlotte Saethre
 *
 */
public class SmartPhone extends Phone {
	private int storage;

	/**
	 * Initializes the fields <code>model</code> and <code>dimension</code> of
	 * superclass Phone and the field <code>storage</code>. 
	 * 
	 * @param model the model 
	 * @param dimension the dimension
	 * @param storage the storage
	 * @throws IllegalArgumentException if <code>storage</code> is zero or negative number
	 */
	public SmartPhone(String model, Dimension dimension, int storage) {
		super(model, dimension);
		if (storage <= 0) 
			throw new IllegalArgumentException("Storage needs to be assigned a positive value.");
		this.storage = storage;
	}
	
	/**
	 * Returns a string to indicate making a phone call.
	 * String in the following format:
	 * Calling {number} by selecting the number
	 * where number is argument value
	 * 
	 * @param number phone number
	 * @return		string indicating call
	 */
	@Override
	public String call(long number) {
		return "Calling " + number + " by selecting the number";
	}
	
	/**
	 * Returns a string that indicates browsing the web.
	 * 
	 * @return string that indicates web-browsing 
	 */
	public String browse() {
		return "Browsing the web";
	}
	
	/**
	 * Returns a string that indicates taking a picture. 
	 * 
	 * @return string that indicates picture-taking
	 */
	public String takePicture() {
		Random rand = new Random();
		String picture = "";
		if (rand.nextBoolean()) {
			picture = "Taking a horizontal picture";
		}
		else {
			picture = "Taking a vertical picture";
		}
		
		return picture;
	}

	/* Returns the string in the following format:
	 * {model} {dimension} {storage}GB
	 * 
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + storage + "GB";
	}
}
