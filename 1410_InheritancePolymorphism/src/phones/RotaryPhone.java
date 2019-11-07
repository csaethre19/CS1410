package phones;
/**
 * Describes a land-line phone that uses a rotary to dial phone numbers to make a call. 
 * 
 * @author Charlotte Saethre
 *
 */
public class RotaryPhone extends DeskPhone {

	/**
	 * Initializes the fields; <code>model</code>, <code>dimension</code>, and 
	 * <code>voltage</code> of superclass DeskPhone.
	 * 
	 * @param model model of phone
	 * @param dimension dimension of phone
	 * @param voltage phone voltage
	 */
	public RotaryPhone(String model, Dimension dimension, Voltage voltage) {
		super(model, dimension, voltage);
	}

	/**
	 * Returns string in the following format to indicate call being made:
	 * Rotating the dial to call {number}
	 */
	@Override
	public String call(long number) {
		return "Rotating the dial to call " + number;
	}
}
