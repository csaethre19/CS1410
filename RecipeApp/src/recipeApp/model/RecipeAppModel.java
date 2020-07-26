package recipeApp.model;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author charl
 *
 */
public class RecipeAppModel {
	private static List<Recipe> recipes = new ArrayList<>();
	
	public RecipeAppModel() {

	}
	
	public List<Recipe> getRecipesList() {
		return RecipeAppModel.recipes;
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
	
	public void removeRecipe(int index) {
		recipes.remove(index);
	}
	
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
