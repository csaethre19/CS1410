package myRecipes;
import java.io.Serializable;
/**
 * Describes a recipe that includes a name, list of ingredients, and list of directions.
 * This will be used to create a recipe that the user inputs information for and will add to
 * a list of recipes in a <code>RecipeBook</code> object.
 * @author Charlotte Saethre
 *
 */
@SuppressWarnings("serial")
public class Recipe implements Serializable {
	private String name;
	private String ingredients;
	private String directions;
	
	/**
	 * Initializes fields <code>name</code>, <code>ingredients</code>, and <code>directions</code> to construct
	 * a <code>Recipe</code> object.
	 * @param name recipe name
	 * @param ingredients recipe ingredients
	 * @param directions recipe directions
	 */
	public Recipe(String name, String ingredients, String directions) {
		this.name = name;
		this.ingredients = ingredients;
		this.directions = directions;
	}
	
	/**
	 * Displays the recipe information input by user.
	 */
	public void showRecipe() {
		System.out.println("Recipe: " + this.name);
		System.out.println("Ingredients: \n" + this.ingredients);
		System.out.println("Directions: \n" + this.directions);
	}

	/**
	 * Returns the name of the requested recipe.
	 * @return recipe name
	 */
	public String getName() {
		return this.name;
	}
}
