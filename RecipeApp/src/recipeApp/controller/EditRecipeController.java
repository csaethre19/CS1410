package recipeApp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import recipeApp.model.Recipe;
import recipeApp.model.RecipeAppModel;
import recipeApp.view.EditRecipeView;
import recipeApp.view.RecipeAppView;
/**
 * Communicates with the <code>EditRecipeView</code> and the <code>RecipeAppModel</code>
 * to update the user selected recipe from combo-box.
 * 
 * @author Charlotte Saethre
 *
 */
public class EditRecipeController {
	private EditRecipeView view;
	private RecipeAppModel model;
	private RecipeAppView mainView;

	public EditRecipeController(EditRecipeView view, RecipeAppModel model, RecipeAppView mainView) {
		this.view = view;
		this.model = model;
		this.mainView = mainView;
		view.addUpdateListener(new UpdateRecipeListener());
		view.addClearListener(new ClearListener());
	}

	class UpdateRecipeListener implements ActionListener {

		/**
		 * Passes updated text for recipe to <code>RecipeAppModel</code> to modify recipe fields.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			String name = view.getRecipeName();
			String ing = view.getRecipeIngredients();
			String dir = view.getRecipeDirections();
			Recipe rec = model.getRecipe(mainView.getRecipeSelected());
			rec.setRecipeName(name);
			rec.setRecipeIngredients(ing);
			rec.setRecipeDirections(dir);
			List<Recipe> recipes = model.getRecipesList();
			mainView.getRecipeDropdown().removeAllItems();
			mainView.setRecipeDropdown(recipes);
			view.setRecipeName("");
			view.setDirectionsText("");
			view.setIngredientsText("");
			mainView.displayAlertMessage("Recipe updated");
		}

	}

	class ClearListener implements ActionListener {

		/**
		 * Clears contents of edit recipe form.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			view.setRecipeName("");
			view.setDirectionsText("");
			view.setIngredientsText("");

		}

	}
}
