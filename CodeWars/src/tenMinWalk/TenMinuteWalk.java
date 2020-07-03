package tenMinWalk;

/**
 * You live in the city of Cartesia where all roads are laid out in a perfect
 * grid. You arrived ten minutes too early to an appointment, so you decided to
 * take the opportunity to go for a short walk. The city provides its citizens
 * with a Walk Generating App on their phones -- everytime you press the button
 * it sends you an array of one-letter strings representing directions to walk
 * (eg. ['n', 's', 'w', 'e']). You always walk only a single block in a
 * direction and you know it takes you one minute to traverse one city block, so
 * create a function that will return true if the walk the app gives you will
 * take you exactly ten minutes (you don't want to be early or late!) and will,
 * of course, return you to your starting point. Return false otherwise.
 * 
 * @author charl
 *
 */
public class TenMinuteWalk {

	public static void main(String[] args) {
		System.out.println(isValid(new char[] { 'n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 's' }));
		System.out.println(isValid(new char[] { 'n', 'n', 'n', 's', 'n', 's', 'n', 's', 'n', 's' }));
		System.out.println(isValid(new char[] { 'w' }));
		System.out.println(isValid(new char[] { 'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e' }));
		System.out.println(isValid(new char[] { 's', 'e', 's', 'e', 's', 'e', 's', 'e', 's', 'e' }));
	}

	/**
	 * Determines if the walk that the App suggests is exactly 10 minutes and puts
	 * you back at your starting position.
	 * 
	 * @param walk an array of directions
	 * @return true or false
	 */
	public static boolean isValid(char[] walk) {
		boolean tenMinWalk = false;
		int north = 0, east = 0, south = 0, west = 0;
		int time = walk.length;
		if (time == 10) {
			for (int i = 0; i < walk.length; i++) {
				switch (walk[i]) {
				case 'n':
					north += 1;
					break;
				case 'e':
					east += 2;
					break;
				case 's':
					south -= 1;
					break;
				case 'w':
					west -= 2;
				}

			}

			int endX = west + east;
			int endY = north + south;
			if (endX == 0 && endY == 0) {
				tenMinWalk = true;
			}
		}

		return tenMinWalk;
	}
}
