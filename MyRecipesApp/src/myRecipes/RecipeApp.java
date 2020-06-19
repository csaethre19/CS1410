package myRecipes;
/**
 * Recipe application that allows user to create recipes and add them to a list for later viewing.
 * Capability to add, view, and delete recipes as needed by user.
 * @author Charlotte Saethre
 *
 */
public class RecipeApp {

	public static void main(String[] args) {
		RecipeBook myRecipes = new RecipeBook();
		myRecipes.manageRecipes();
	}

}
