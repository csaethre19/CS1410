package labFileInput;

/**
 * A lake defined by its name, depth, and its support for boating.
 * 
 * @author Starter Code
 *
 */
public class Lake {
	private final String name;
	private final int depth;
	private final boolean hasMarina;

	/**
	 * Initializes a newly created Lake with the information provided by the user.
	 * 
	 * @param name      name of the lake.
	 * @param depth     depth of the lake in meters.
	 * @param hasMarina true if the lake has a marina.
	 */
	public Lake(String name, int depth, boolean hasMarina) {
		this.name = name;
		this.depth = depth;
		this.hasMarina = hasMarina;
	}

	public String getName() {
		return name;
	}

	public int getDepth() {
		return depth;
	}

	public boolean hasMarina() {
		return hasMarina;
	}

	@Override
	public String toString() {
		return name + " (" + depth + ") " + (hasMarina ? "*" : "");
	}

	/**
	 * Creates a Lake object based on the data record passed as an argument. The
	 * data record is expected to be of the following format: <br/>
	 * {name of the lake},{depth},{has marina}<br/>
	 * <p>
	 * If the argument <code>line</code> doesn't match the expected format and the
	 * instance of Lake cannot be created, then the string "Error: " followed by the
	 * line should be printed to the standard error stream (<code>System.err</code>)
	 * and the method should return null.
	 * 
	 * @param line a line from a csv file that includes data about a lake
	 * @return Lake object corresponding to the argument <code>line</code> or null
	 *         if <code>line</code> didn't match the expected format.
	 */
	public static Lake getLake(String line) {
		String[] data = line.split(",");

		try {
			boolean isMarina = Boolean.parseBoolean(data[2]);
			int depth = Integer.parseInt(data[1]);
			String name = data[0];
			return new Lake(name, depth, isMarina);
			
		}catch(NumberFormatException|ArrayIndexOutOfBoundsException e)
	{
		System.err.println("Error: " + line);
		return null;
	}

}}