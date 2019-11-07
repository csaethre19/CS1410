package phones;
/**
 * Describes a phone by its model and dimension.
 * 
 * @author Charlotte Saethre
 *
 */
public abstract class Phone {
	private String model;
	private Dimension dimension;

	/**
	 * Initializes the fields <code>model</code> and <code>dimension</code>.
	 * 
	 * @param model model of phone
	 * @param dimension dimension of phone
	 */
	protected Phone(String model, Dimension dimension) {
		super();
		this.model = model;
		this.dimension = dimension;
	}

	/**
	 * Returns a string that indicates call is being made. 
	 * 
	 * @param phone number
	 * @return	string indicating call being made
	 */
	public abstract String call(long number);
	
	/* Returns string in the following format:
	 * {model} {dimension}
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return model + " " + dimension + " ";
	}
}
