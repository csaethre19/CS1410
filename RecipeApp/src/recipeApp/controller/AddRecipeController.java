package recipeApp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import recipeApp.model.Recipe;
import recipeApp.model.RecipeAppModel;
import recipeApp.view.AddRecipeView;

public class AddRecipeController {

	private AddRecipeView view;
	private RecipeAppModel model;
	
	public AddRecipeController(AddRecipeView view, RecipeAppModel model) {
		this.view = view;
		this.model = model;
		view.addSubmitBtnListener(new AddRecipeListener());
		view.addClearBtnListener(new ClearListener());
	}
	
	class AddRecipeListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String recipeName = view.getRecipeName();
			String recipeIngredients = view.getRecipeIngredients();
			String recipeDirections = view.getRecipeDirections();
			model.createRecipe(recipeName, recipeIngredients, recipeDirections);

		}
		
	}
	
	class ClearListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			view.setLblRecipeName("");
			view.setIngredients("");
			view.setDirections("");
			
		}
	}

}
