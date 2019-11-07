package phones;
/**
 * Describes a land-line phone that has push buttons to dial phone numbers and make calls. 
 * 
 * @author Charlotte Saethre
 *
 */
public class PushButtonPhone extends DeskPhone {

	/**
	 * Initializes the fields <code>model</code>, <code>dimension</code>, and 
	 * <code>voltage</code> of superclass DeskPhone.
	 * 
	 * @param model model of phone
	 * @param dimension dimension of phone
	 * @param voltage phone voltage
	 */
	public PushButtonPhone(String model, Dimension dimension, Voltage voltage) {
		super(model, dimension, voltage);
	}

	/**
	 * Returns string in the following format to indicate call being made:
	 * Pushing buttons to call {number}
	 */
	@Override
	public String call(long number) {
		return "Pushing buttons to call " + number;
	}



}
