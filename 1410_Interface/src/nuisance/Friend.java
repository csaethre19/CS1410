package nuisance;
/**
 * Describes a type of person that is considered a friend. 
 * 
 * @author Charlotte Saethre
 *
 */
public class Friend extends Person {
	private Hobby hobby; 
	
	/**
	 * Initializes the fields of superclass Person.
	 * 
	 * @param name name
	 * @param age age
	 * 
	 */
	public Friend(String name, int age, Hobby hobby) {
		super(name, age);
		this.hobby = hobby;
		
	}

	/**
	 * Returns string that indicates a friend is chilling. 
	 * 
	 * @return
	 */
	public String chill() {
		return getName() + " is chilling";
	}
	
	/**
	 * Determines how many friends there area and returns a string
	 * that lists the names of the friends and the hobby they play.
	 * 
	 * @param friends array of friends
	 * @return string of friends that tells us the hobby they play
	 */
	public String play(Friend[] friends) {
		String play = " ";
		
		if (friends.length == 0) {
			play = "playing " + this.hobby;
		}
		else if (friends.length == 1) {
			play = "playing " + this.hobby + " with " + friends[0].getName();
		}
		else if (friends.length == 2) {
			play = "playing " + this.hobby + " with " + friends[0].getName() 
					+ " and " + friends[1].getName();
		}
		else {
			play = "playing " + this.hobby + " with ";
			for (int i = 0; i < friends.length; i++) {
				if (i < friends.length - 1) {
				play += friends[i].getName() + ", ";
				}
				else {
					play += "and " + friends[i].getName();
				}
			}
		}
		return play;
	}

	/**
	 * Returns the string in the following format:
	 * {name}({age}) {hobby} 
	 */
	@Override
	public String toString() {
		return super.toString() + " " + this.hobby;
	}

}
