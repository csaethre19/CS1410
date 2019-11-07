package nuisance;
/**
 * Describes a mosquito that can be annoying. 
 * 
 * @author Charlotte Saethre
 */
public class Mosquito extends Insect implements Nuisance {

	/**
	 * Initializes fields of superclass Insect. 
	 * 
	 * @param species species of insect
	 */
	public Mosquito(String species) {
		super(species);
	}

	/**
	 * Returns a string that indicates mosquito that is annoying.
	 */
	@Override
	public String annoy() {
		return "buzz buzz buzz";
	}
	
	/**
	 * Returns the string in the following format:
	 * {species} buzzing around
	 */
	public String buzz() {
		return this.getSpecies() + " buzzing around";
	}

}
