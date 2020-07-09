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
	
	public RecipeAppModel() {
		
	}
	
	public List<Recipe> getRecipesList() {
		return this.recipes;
	}
	
	/**
	 * 
	 * @param recipeName
	 * @param recipeIngredients
	 * @param recipeDirections
	 */
	public void createRecipe(String recipeName, String recipeIngredients, String recipeDirections) {
		Recipe recipe = new Recipe(recipeName, recipeIngredients, recipeDirections);
		addRecipe(recipe);
	}
	
	/**
	 * 
	 * @param recipe
	 */
	public void addRecipe(Recipe recipe) {
		recipes.add(recipe);
	}
	
}
