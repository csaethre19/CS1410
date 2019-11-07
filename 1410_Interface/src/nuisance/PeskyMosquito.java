package nuisance;
/**
 * Describes a mosquito that is pesky and therefore very annoying. 
 * 
 * @author Charlotte Saethre
 */
public class PeskyMosquito extends Mosquito {

	/**
	 * Intializes fields of superclass Mosquito. 
	 * 
	 * @param species species of mosquito
	 */
	public PeskyMosquito(String species) {
		super(species);
	}

	/**
	 * Returns a string that indicates a mosquito described as "pesky".
	 * 
	 */
	public String bite() {
		return "sucking blood";
	}
}
