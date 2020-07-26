package recipeApp.model;

import java.util.ArrayList;
import java.util.List;
/**
 * Stores a list of recipes input by user and allows for recipe management functionality.
 * 
 * @author Charlotte Saethre
 *
 */
public class RecipeAppModel {
	private static List<Recipe> recipes = new ArrayList<>();
	
	/**
	 * Returns the list of recipes to view.
	 * 
	 * @return recipes
	 */
	public List<Recipe> getRecipesList() {
		return RecipeAppModel.recipes;
	}
	
	/**
	 * Returns the <code>Recipe</code> object from list of recipes.
	 * 
	 * @param index index of recipe user selects
	 * @return <code>Recipe</code>
	 */
	public Recipe getRecipe(int index) {
		return recipes.get(index);
	}
	
	/**
	 * Creates <code>Recipe</code> object and adds it to the list of recipes.
	 * 
	 * @param recipeName name 
	 * @param recipeIngredients ingredients
	 * @param recipeDirections directions
	 */
	public void createRecipe(String recipeName, String recipeIngredients, String recipeDirections) {
		Recipe recipe = new Recipe(recipeName, recipeIngredients, recipeDirections);
		recipes.add(recipe);
	}
	
	/**
	 * Removes recipe by index from list of recipes.
	 * 
	 * @param index index of recipe to be removed
	 */
	public void removeRecipe(int index) {
		recipes.remove(index);
	}
	
	/**
	 * Injects HTML into <code>text</code> string to allow for formatting.
	 * 
	 * @param text string of text to be formatted
	 * @return returns modified string of text
	 */
	public String addNewLine(String text) {
		String[] temp = text.split(" ");
		String result = "<html>";
		for (int i = 0; i < temp.length; i++) {
			if (i%5 == 0 && i != 0) {
				result += "<br>" + temp[i] + " ";
			}
			else {
				result += temp[i] + " ";
			}
		}
		result += "</html>";
		return result;
	}
	
}
