package phones;
/**
 * Describes a land line phone called the desk phone. 
 * 
 * @author Charlotte Saethre
 *
 */
public abstract class DeskPhone extends Phone {
	public boolean connected;
	private Voltage voltage;
	
	/**
	 * Initializes fields <code>model</code> and <code>dimension</code> of superclass Phone
	 * and the field <code>voltage</code>.
	 * 
	 * @param model	the model
	 * @param dimension	the dimension
	 */
	protected DeskPhone(String model, Dimension dimension, Voltage voltage) {
		super(model, dimension);
		this.voltage = voltage;
	}
	
	/**
	 * Changes the field <code>connected</code> to true to indicate that it has power. 
	 * 
	 */
	public void plugIn() {
		connected = true;
	}
	
	/**
	 * Changes the field <code>connected</code> to false to indicate the power has been unplugged. 
	 */
	public void unplug() {
		connected = false;
	}
	
	/**
	 * Determines if phone is connected or disconnected. 
	 * 
	 * @param connected indication of phone being connected/disconnected
	 * @return	true or false
	 */
	public boolean isConnected(boolean connected) {
		return connected;
	}

	/* Returns the string in the following format:
	 * {model} {dimension} {voltage} {connectionInfo}
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + voltage + " " + ((connected) ? "connected" : "not connected");
	}

}
