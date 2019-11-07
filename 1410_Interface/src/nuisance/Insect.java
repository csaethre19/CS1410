package nuisance;
/**
 * Describes a species of insect. 
 * 
 * @author Charlotte Saethre
 */
public class Insect {
	private String species;
	
	/**
	 * Initializes field <code>species</code>
	 * @param species
	 */
	public Insect(String species) {
		this.species = species;
	}

	/**
	 * Returns the species. 
	 * 
	 * @return the species
	 */
	public String getSpecies() {
		return species;
	}

	/* Returns the string in the following format:
	 * {className}: {species}
	 * 
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + ": " + species;
	}
	
}
