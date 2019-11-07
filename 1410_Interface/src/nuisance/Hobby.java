package nuisance;
/**
 * Lists different hobbies a person might have. 
 * 
 * @author Charlotte Saethre
 */
public enum Hobby {
	MUSIC, SPORTS, GAMES;
	
	@Override
	public String toString() {
		return name().toLowerCase();
	}
}
