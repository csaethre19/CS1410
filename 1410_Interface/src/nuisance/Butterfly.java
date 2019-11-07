package nuisance;

import java.util.ArrayList;
import java.util.List;

/**
 * Describes a type of insect that is called a butterfly. 
 * 
 * @author Charlotte Saethre
 */
public class Butterfly extends Insect {

	private List<String> colors = new ArrayList<String>();

	/**
	 * Initializes the fields of superclass Insect and field <code>colors</code>.
	 * 
	 * @param species species of butterfly
	 */
	public Butterfly(String species, List<String> colors) {
		super(species);
		this.colors = colors;
	}
	
	/**
	 * Returns list of colors. 
	 * 
	 * @return the colors
	 */
	public List<String> getColors() {
		return this.colors;
	}

	/**
	 * Returns the string in the following format:
	 * {insect} {list of colors}
	 */
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + ": " + colors;
	}


	
	
}
