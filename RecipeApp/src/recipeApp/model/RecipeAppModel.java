package recipeApp.model;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author charl
 *
 */
public class RecipeAppModel {
	private List<Recipe> recipes = new ArrayList<>();
	private Recipe testRecipe;
	
	public RecipeAppModel() {
		testRecipe = new Recipe("Homemade Bread", "Flour, Water, Yeast, Oil", "Combine dry ingredients, "
				+ "Add warm water and oil. Mix to combine. Kneed for 10 minutes. Rest for 15. "
				+ "Bake in oven at 400 degrees. Let cool");
		recipes.add(testRecipe);
		for (Recipe r : recipes) {
			System.out.println(r.getRecipeName());
		}
	}
	
	public List<Recipe> getRecipesList() {
		return this.recipes;
	}
	
	public Recipe getRecipe(int index) {
		return recipes.get(index);
	}
	/**
	 * Creates recipe object and adds it to the list of recipes.
	 * 
	 * @param recipeName name 
	 * @param recipeIngredients ingredients
	 * @param recipeDirections directions
	 */
	public void createRecipe(String recipeName, String recipeIngredients, String recipeDirections) {
		Recipe recipe = new Recipe(recipeName, recipeIngredients, recipeDirections);
		recipes.add(recipe);
	}
	
}
