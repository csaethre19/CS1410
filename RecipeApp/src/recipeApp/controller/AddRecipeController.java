package recipeApp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import recipeApp.model.Recipe;
import recipeApp.model.RecipeAppModel;
import recipeApp.view.AddRecipeView;
import recipeApp.view.RecipeAppView;
/**
 * Communicates with <code>AddRecipeView</code> and <code>RecipeAppModel</code> 
 * to create new recipes via user inputs.
 * 
 * @author Charlotte Saethre
 *
 */
public class AddRecipeController {

	private AddRecipeView view;
	private RecipeAppModel model;
	private RecipeAppView mainView;
	
	public AddRecipeController(AddRecipeView view, RecipeAppModel model, RecipeAppView mainView) {
		this.view = view;
		this.model = model;
		this.mainView = mainView;
		view.addSubmitBtnListener(new AddRecipeListener());
		view.addClearBtnListener(new ClearListener());
	}
	
	class AddRecipeListener implements ActionListener {

		/**
		 * Passes user inputs to <code>RecipeAppModel</code> to create new recipe.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			String recipeName = view.getRecipeName();
			String recipeIngredients = view.getRecipeIngredients();
			String recipeDirections = view.getRecipeDirections();
			model.createRecipe(recipeName, recipeIngredients, recipeDirections);
			view.setLblRecipeName("");
			view.setIngredients("");
			view.setDirections("");
			List<Recipe> recipes = model.getRecipesList();
			mainView.getRecipeDropdown().removeAllItems();
			mainView.setRecipeDropdown(recipes);
			mainView.displayAlertMessage("Your recipe has been added");
		}
		
	}
	
	class ClearListener implements ActionListener {
		
		/**
		 * Clears out add recipe form.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			view.setLblRecipeName("");
			view.setIngredients("");
			view.setDirections("");
			
		}
	}

}
