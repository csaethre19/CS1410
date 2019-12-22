package labCollection;
/**
 * Provides different material types that a couch can have. 
 * @author Charlotte Saethre
 *
 */
public enum Material {
	FABRIC, LEATHER, VINYL;
	
	@Override
	public String toString() {
		return name().toLowerCase();
	}
}
