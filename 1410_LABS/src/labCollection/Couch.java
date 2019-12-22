package labCollection;
import java.awt.Color;

/**
 * Describes a couch based on the color and material of the couch. 
 * 
 * @author Charlotte Saethre
 *
 */
public class Couch {
	private Color color;
	private Material material;
	
	/**
	 * Initializes fields <code>color</code> and <code>material</code>.
	 * @param color couch color
	 * @param material material of couch
	 */
	public Couch(Color color, Material material) {
		this.color = color;
		this.material = material;
	}

	/**
	 * Returns the color of couch. 
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Returns the type of material of couch. 
	 * @return the material
	 */
	public Material getMaterial() {
		return material;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((material == null) ? 0 : material.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Couch other = (Couch) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (material != other.material)
			return false;
		return true;
	}

	/* Returns the string in the following format:
	 * Couch: {colorString} {material}
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Couch: #%02x%02x%02x %s", color.getRed(), 
				color.getGreen(), color.getBlue(), material);
	}
	
	
}
