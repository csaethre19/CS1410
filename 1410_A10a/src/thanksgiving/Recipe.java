package thanksgiving;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Describes a recipe based on its name, text file that contains directions and
 * ingredients, and name of image that should be displayed that corresponds to the
 * recipe. Once a Recipe is created it reads from its specific file to get its ingredients,
 * notes (if applicable), and directions. 
 * 
 * @author Charlotte Saethre & Kim Harvey
 *
 */
public class Recipe {

	private String name;
	private String recipeFile;
	private String ingredients;
	private String directions;
	private String notes;
	private String recipeImage;

	/**
	 * Initializes fields <code>recipeFile</code>, and <code>recipeImage</code>.
	 * Reads from the file to initialize the fields <code>name</code>
	 * <code>ingredients</code>, <code>directions</node> and <code>notes</code>.
	 * 
	 * @param recipeFile file path of recipe
	 */
	public Recipe(String recipeFile, String recipeImage) {
		this.recipeFile = recipeFile;
		this.recipeImage = recipeImage;
		readRecipeFile(recipeFile);
	}

	/**
	 * Returns user notes. 
	 * 
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * Returns recipe name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns file path of recipe.
	 * 
	 * @return file path of recipe
	 */
	public String getFile() {
		return recipeFile;
	}

	/**
	 * Returns list of ingredients. 
	 * 
	 * @return list of ingredients
	 */
	public String getIngredients() {
		return ingredients;
	}

	/**
	 * Returns list of directions. 
	 * 
	 * @return list of directions
	 */
	public String getDirections() {
		return directions;
	}

	/**
	 * Returns the string that represents image file of recipe.
	 * 
	 * @return name of recipe image file
	 */
	public String getRecipeImage() {
		return recipeImage;
	}
	
	/**
	 * Reads text file and initializes the fields <code>name</code>, <code>ingredients</code>,
	 * <code>directions</code>, and <code>notes</code>.
	 * 
	 * @param file text file
	 */
	public void readRecipeFile(String file) {
		try (Scanner reader = new Scanner(new File("Recipes\\" + file))) {
			while (reader.hasNextLine()) {
				switch (reader.nextLine()) {
				case "<Recipe>":
					name = reader.nextLine();
					break;
				case "<Ingredients>":
					ingredients = reader.nextLine();
					break;
				case "<Directions>":
					directions = reader.nextLine();
					break;
				case "<Notes>":
					notes = reader.nextLine();
				}
				
			}
		} catch (NullPointerException | FileNotFoundException e) {
			System.err.println("Error: no data");
		}
		
	}

	/**
	 * Writes note indicated by user to text file of recipe being displayed.
	 * 
	 * @param file file name
	 * @param notes user input
	 */
	public void writeNote(String file, String notes) {
		this.notes = notes;
		try (PrintWriter output = new PrintWriter("Recipes\\" + file)) {
			output.println("<Recipe>");
			output.println(name);
			output.println("<Ingredients>");
			output.println(ingredients);
			output.println("<Directions>");
			output.println(directions);
			output.println("<Notes>");
			output.println("<html><br>" + notes + "</html>");
		} catch (FileNotFoundException e) {
			System.err.println("Error: File not Found");
		}

	}

}
