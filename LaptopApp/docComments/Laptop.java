package docComments;
/**
 * 
 * Represents a Laptop with unique identifier 
 * and its features for manufacturer, series, and model number.
 * 
 * @author Charlotte Saethre and Kim H
 *
 */
public class Laptop {
	private String manufacturer;
	private String series;
	private String modelNumber;
	private static int count = 0;
	private final int ID_NUMBER;
	
	/**
	 * Initializes fields, counts the number of laptops added, and creates
	 * unique id number for each laptop.
	 * 
	 * @param manufacturer	laptop manufactuerer
	 * @param series		laptop series
	 * @param modelNumber	laptop model number
	 */
	public Laptop(String manufacturer, String series, String modelNumber) {
		this.manufacturer = manufacturer;
		this.series = series;
		this.modelNumber = modelNumber;
		this.ID_NUMBER = 1234567 + count++;
	}

	/**
	 * Returns the manufacturer of laptop
	 * 
	 * @return the manufacturer
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * Returns the series of laptop
	 * 
	 * @return the series
	 */
	public String getSeries() {
		return series;
	}

	/**
	 * Returns the model number of laptop
	 * 
	 * @return the modelNumber
	 */
	public String getModelNumber() {
		return modelNumber;
	}

	/**
	 * Returns unique id number
	 * 
	 * @return the iD_NUMBER
	 */
	public int getID_NUMBER() {
		return ID_NUMBER;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return manufacturer + " " + series + " " + modelNumber
				+ " " + "id:" + ID_NUMBER;
	}
	
	
}
