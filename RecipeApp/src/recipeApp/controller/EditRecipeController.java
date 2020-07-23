package recipeApp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import recipeApp.model.Recipe;
import recipeApp.model.RecipeAppModel;
import recipeApp.view.EditRecipeView;
import recipeApp.view.RecipeAppView;

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

		@Override
		public void actionPerformed(ActionEvent e) {
			String name = view.getRecipeName();
			String ing = view.getRecipeIngredients();
			String dir = view.getRecipeDirections();
			Recipe rec = model.getRecipe(mainView.getRecipeSelected());
			rec.setRecipeName(name);
			rec.setRecipeIngredients(ing);
			rec.setRecipeDirections(dir);
			view.setRecipeName("");
			view.setDirectionsText("");
			view.setIngredientsText("");
		}

	}

	class ClearListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			view.setRecipeName("");
			view.setDirectionsText("");
			view.setIngredientsText("");

		}

	}
}
