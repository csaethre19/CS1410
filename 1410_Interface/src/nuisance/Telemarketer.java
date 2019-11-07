package nuisance;
/**
 * Describes a type of person called a telemarketer that can be a nuisance. 
 * 
 * @author Charlotte Saethre
 *
 */
public class Telemarketer extends Person implements Nuisance {

	protected Telemarketer(String name, int age) {
		super(name, age);
	}

	/**
	 * Returns the string in the following format:
	 * {name} annoys by giving sales pitch
	 */
	@Override
	public String annoy() {
		return getName() + " annoys by giving sales pitch";
	}

	/**
	 * Returns the string in the following format:
	 * {name} pressures others to buy stuff
	 */
	public String giveSalesPitch() {
		return getName() + " pressures others to buy stuff";
	}
}
