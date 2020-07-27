package recipeApp.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
	
	public RecipeAppModel() {
		File serFile = new File("C:\\Users\\Public\\recipe.ser");
		if (serFile.exists()) {
			recipes = deserialize("recipe.ser");
		}
		else {
			try {
				if (serFile.createNewFile()) {
					System.out.println("file created successfully");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
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
		serialize(recipes, "recipe.ser");
	}
	
	/**
	 * Modifies fields of recipe specified by index passed.
	 * 
	 * @param name name of recipe
	 * @param ing ingredients
	 * @param dir directions
	 * @param index index of recipe
	 */
	public void editRecipe(String name, String ing, String dir, int index) {
		recipes.get(index).setRecipeName(name);
		recipes.get(index).setRecipeIngredients(ing);
		recipes.get(index).setRecipeDirections(dir);
		serialize(recipes, "recipe.ser");
	}
	
	/**
	 * Removes recipe by index from list of recipes.
	 * 
	 * @param index index of recipe to be removed
	 */
	public void removeRecipe(int index) {
		recipes.remove(index);
		serialize(recipes, "recipe.ser");
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
	
	private static void serialize(List<Recipe> recipes, String filename) {
		try (ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Public\\" + filename))) {
			obj.writeObject(recipes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	private static List<Recipe> deserialize(String filename) {
		List<Recipe> deserialized = null;
		try (ObjectInputStream obj = new ObjectInputStream(new FileInputStream("C:\\Users\\Public\\" + filename))) {
			deserialized = (List<Recipe>) obj.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return deserialized;
	}
	
}
