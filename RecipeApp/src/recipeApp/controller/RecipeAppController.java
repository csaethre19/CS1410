package recipeApp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import recipeApp.model.Recipe;
import recipeApp.model.RecipeAppModel;
import recipeApp.view.RecipeAppView;

/**
 * Communicates with <code>RecipeAppView</code> and <code>RecipeAppModel</code>
 * to update recipe management panels and pass user inputs to model.
 * 
 * @author Charlotte Saethre
 *
 */
public class RecipeAppController {
	RecipeAppView view;
	RecipeAppModel model;

	public RecipeAppController(RecipeAppView view, RecipeAppModel model) {
		this.view = view;
		this.model = model;
		view.addBtnViewListener(new BtnViewListener());
		view.addBtnHomeListener(new BtnHomeListener());
		view.addBtnAddRecipeListener(new BtnAddListener());
		view.addBtnEditRecipeListener(new BtnEditListener());
		view.addBtnDeleteRecipeListener(new BtnDeleteListener());
	}

	class BtnViewListener implements ActionListener {

		/**
		 * Changes the view on button click to recipe user selected from combo-box.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			if (view.getWelcomePanel().isVisible()) {
				view.getWelcomePanel().setVisible(false);
			} else if (view.getAddRecipeView().isVisible()) {
				view.getAddRecipeView().setVisible(false);
			} else {
				view.getEditView().setVisible(false);
			}
			view.getRecipeDisplay().setVisible(true);
			if (!model.getRecipesList().isEmpty()) {
				Recipe rec = model.getRecipe(view.getRecipeSelected());
				String name = rec.getRecipeName();
				String ing = rec.getRecipeIngredients();
				ing = model.addNewLine(ing);
				String dir = rec.getRecipeDirections();
				dir = model.addNewLine(dir);
				view.getRecipeDisplay().setLblRecipeName(name);
				view.getRecipeDisplay().setLblIngredients(ing);
				view.getRecipeDisplay().setLblDirections(dir);
			} else {
				view.getRecipeDisplay().setLblRecipeName("No recipes :(");
				view.getRecipeDisplay().setLblIngredients("");
				view.getRecipeDisplay().setLblDirections("");
			}

		}

	}

	class BtnEditListener implements ActionListener {

		/**
		 * Changes view to edit view that allows user to edit currently selected recipe.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			if (view.getWelcomePanel().isVisible()) {
				view.getWelcomePanel().setVisible(false);
			} else if (view.getRecipeDisplay().isVisible()) {
				view.getRecipeDisplay().setVisible(false);
			} else if (view.getAddRecipeView().isVisible()) {
				view.getAddRecipeView().setVisible(false);
			}
			view.getEditView().setVisible(true);
			if (!model.getRecipesList().isEmpty()) {
				Recipe rec = model.getRecipe(view.getRecipeSelected());
				String name = rec.getRecipeName();
				String ing = rec.getRecipeIngredients();
				String dir = rec.getRecipeDirections();
				view.getEditView().setRecipeName(name);
				view.getEditView().setIngredientsText(ing);
				view.getEditView().setDirectionsText(dir);
			} else {
				view.getEditView().setRecipeName("no recipes :(");
			}
		}

	}

	class BtnDeleteListener implements ActionListener {

		/**
		 * Deletes recipe that user has selected.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			int n = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this recipe?");
			if (n == 0) {
				if (!model.getRecipesList().isEmpty()) {
					int index = view.getRecipeSelected();
					String recipeToRemove = view.getRecipeDropdown().getItemAt(index);				
					List<Recipe> recipes = model.getRecipesList();
					for (int i = 0; i < recipes.size(); i++) {
						if (recipes.get(i).getRecipeName() == recipeToRemove) {
							model.removeRecipe(i);
						}
					}
					view.getRecipeDropdown().removeAllItems();
					view.setRecipeDropdown(recipes);
					view.displayAlertMessage("Recipe has been deleted");
				}
			}

		}

	}

	class BtnAddListener implements ActionListener {

		/**
		 * Changes view to add view to allow user to input information for a new recipe.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			if (view.getWelcomePanel().isVisible()) {
				view.getWelcomePanel().setVisible(false);
			} else if (view.getRecipeDisplay().isVisible()) {
				view.getRecipeDisplay().setVisible(false);
			} else {
				view.getEditView().setVisible(false);
			}
			view.getAddRecipeView().setVisible(true);

		}

	}

	class BtnHomeListener implements ActionListener {

		/**
		 * Changes view to home screen.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			if (view.getAddRecipeView().isVisible()) {
				view.getAddRecipeView().setVisible(false);
			} else if (view.getRecipeDisplay().isVisible()) {
				view.getRecipeDisplay().setVisible(false);
			} else {
				view.getEditView().setVisible(false);
			}
			view.getWelcomePanel().setVisible(true);
		}

	}
}
