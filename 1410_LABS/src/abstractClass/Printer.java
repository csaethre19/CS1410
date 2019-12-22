package abstractClass;
/**
 * Describes a printer that has a model and serial number.
 * 
 * @author Charlotte Saethre
 *
 */
public abstract class Printer {
	private String model;
	private static int count;
	private int serialNumber;

	/**
	 * Increments count, initializes the field <code>model</code> and creates unique
	 * serial number.
	 * 
	 * @param model printer model
	 */
	protected Printer(String model) {
		count++;
		this.model = model;
		serialNumber = 12345 + count;
	}

	/**
	 * Returns the model of printer.
	 * 
	 * @return printer model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * Indicates when printer is printing and reduces value of toner or cartridge.
	 */
	public abstract void print();

	/**
	 * Returns a string of the following format: 
	 * {className}: {model} #{serialNumber}
	 */
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + ":" + " " + model + " #" + serialNumber;
	}

}
