package phones;
/**
 * Describes height, width, and depth for dimension of a phone. 
 * 
 * @author Charlotte Saethre
 *
 */
public class Dimension {
	private double height; 
	private double width;
	private double depth;
	
	/**
	 * Determines if there is a valid input for <code>height</code>, <code>width</code>, 
	 * and <code>depth</code>.
	 * These fields cannot be zero or negative. 
	 * 
	 * @param height the height
	 * @param width	the width
	 * @param depth	the depth
	 * 
	 * @throws IllegalArgumentException if <code>height</code>, <code>width</code> or 
	 * <code>depth</code> are zero or negative
	 */
	public Dimension(double height, double width, double depth) {
		if (height <= 0 || width <= 0 || depth <= 0) 
			throw new IllegalArgumentException("The height, width, and depth of a dimension needs to be positive.");
		
		this.height = height;
		this.width = width;
		this.depth = depth;
	}

	/**
	 * Returns the height of phone.
	 * 
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * Returns the width of phone.
	 * 
	 * @return the width
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * Returns the depth of phone.
	 * 
	 * @return the depth
	 */
	public double getDepth() {
		return depth;
	}

	/* Returns string in the following format:
	 * ({height} x {width} x {depth})
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "(" + height + " x " + width + " x " + depth + ")";
	}
	
}
