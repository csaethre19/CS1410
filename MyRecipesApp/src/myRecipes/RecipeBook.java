package myRecipes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Holds list of <code>Recipe</code> objects that are created by input of the
 * user. Ability to save state of objects through serialization and
 * deserialization so recipes added, deleted, or edited will be saved the next
 * time user runs application. Ability to view, delete, and add new recipes by
 * way of user prompt.
 * 
 * @author Charlotte Saethre
 *
 */
public class RecipeBook {
	private List<Recipe> recipes = new ArrayList<>();
	private static final Scanner input = new Scanner(System.in);

	public RecipeBook() {
		recipes = deserialize("recipes.ser");
	}

	/**
	 * Displays user prompt to let the user choose what action they want to execute.
	 * Options include: Looking up a recipe, adding a new recipe, and deleting a
	 * current recipe.
	 */
	public void manageRecipes() {
		if (this.recipes.isEmpty()) {
			System.out.println("Looks like your recipe book is empty. Let's add one!");
			addRecipe();
		}
		String response = "";
		do {
			System.out.println(
					"Please select an option:\n1: Look up recipe\n2: Add recipe\n3: Delete recipe\nenter \"q\" to quit\n");
			response = userInput();
			if (response.equals("1"))
				lookUpRecipe();
			else if (response.equals("2"))
				addRecipe();
			else if (response.equals("3"))
				deleteRecipe();
			else if (response.equals("q"))
				break;
			else
				System.out.println("\nPlease enter a valid response\n");
		} while (!response.equals("q"));

	}

	// View all recipes
	private void lookUpRecipe() {
		if (recipes.isEmpty()) {
			System.out.println("You do not have any recipes at this time.\nAdd a recipe to get started.\n");
		} else {
			showRecipeNames();
			int recipeSelected = 999;
			do {
				try {
					System.out.println("Select a recipe to show more information: (choose the corresponding number)");
					recipeSelected = userNumInput();
					if (recipeSelected >= 1 && recipeSelected <= recipes.size()) {
						recipes.get(recipeSelected - 1).showRecipe();
					} else {
						showRecipeNames();
						recipeSelected = 999;
					}
				} catch (InputMismatchException e) {
					System.out.println("Please enter a number");
					input.nextLine();
				}
			} while (recipeSelected == 999);
		}
	}

	private void showRecipeNames() {
		int index = 1;
		System.out.println("Recipes");
		System.out.println("-------");
		for (Recipe r : recipes) {
			System.out.println(index + ": " + r.getName());
			index++;
		}
	}

	private void addRecipe() {
		String name = recipeNamePrompt();
		String ingredients = recipeIngredientsPrompt();
		String directions = recipeDirectionsPrompt();
		Recipe recipe = new Recipe(name, ingredients, directions);
		recipes.add(recipe);
		System.out.println("\nYour recipe has been added.\n");
		serialize(recipes, "recipes.ser");
	}

	// Prompt for recipe name
	private String recipeNamePrompt() {
		String recipeName = "";
		System.out.println("Recipe Name: ");
		recipeName = userInput();
		return recipeName;
	}

	// Prompt for list of ingredients
	private String recipeIngredientsPrompt() {
		int numberOfIngredients = 0;
		System.out.println("How many ingredients does this recipe have?");
		do {
			try {
				numberOfIngredients = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Please enter a number");
				input.nextLine();
			}
		} while (numberOfIngredients == 0);
		String ingredientsList = "";
		String ingredient = "";
		int i = 0;
		while (i <= numberOfIngredients) {
			if (i != 0) {
				System.out.print(i + ": ");
			}
			ingredient = userInput();
			if (!ingredient.equals("")) {
				ingredientsList += i + ": " + ingredient + "\n";
			}
			i++;
		}
		return ingredientsList;
	}

	// Prompt for list of directions
	private String recipeDirectionsPrompt() {
		System.out.println("How many directions does this recipe have?");
		int numberOfDirections = 0;
		do {
			try {
				numberOfDirections = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Please enter a number");
				input.nextLine();
			}
		} while (numberOfDirections == 0);
		String directionsList = "";
		String direction = "";
		int i = 0;
		while (i <= numberOfDirections) {
			if (i != 0) {
				System.out.print(i + ": ");
			}
			direction = userInput();
			if (!direction.equals("")) {
				directionsList += i + ": " + direction + "\n";
			}
			i++;
		}
		return directionsList;
	}

	private void deleteRecipe() {
		System.out.println("Which recipe would you like to remove? (choose the corresponding number)");
		showRecipeNames();
		int index = 0;
		do {
			try {
				index = userNumInput();
			} catch (InputMismatchException e) {
				System.out.println("Please enter a number");
				input.nextLine();
			}
		} while (index == 0);
		System.out.println("\n" + recipes.get(index - 1).getName() + " has been deleted.\n");
		recipes.remove(index - 1);
		serialize(recipes, "recipes.ser");
	}

	private static void serialize(List<Recipe> recipes, String filename) {
		try (ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream("C:\\" + filename))) {
			obj.writeObject(recipes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	private static List<Recipe> deserialize(String filename) {
		List<Recipe> deserialized = null;
		try (ObjectInputStream obj = new ObjectInputStream(new FileInputStream("C:\\" + filename))) {
			deserialized = (List<Recipe>) obj.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return deserialized;
	}

	private String userInput() {
		String response = input.nextLine();
		return response;
	}

	private int userNumInput() {
		int response = input.nextInt();
		input.nextLine();
		return response;
	}
}
