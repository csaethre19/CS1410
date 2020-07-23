package recipeApp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import recipeApp.model.Recipe;
import recipeApp.model.RecipeAppModel;
import recipeApp.view.RecipeAppView;

/**
 * 
 * @author charl
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
	}

	class BtnViewListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (view.getWelcomePanel().isVisible()) {
				view.getWelcomePanel().setVisible(false);
			} else if (view.getAddRecipeView().isVisible()) {
				view.getAddRecipeView().setVisible(false);
			} else {
				view.getEditView().setVisible(false);
			}
			view.getDisplayView().setVisible(true);
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

		@Override
		public void actionPerformed(ActionEvent e) {
			if (view.getWelcomePanel().isVisible()) {
				view.getWelcomePanel().setVisible(false);
			} else if (view.getDisplayView().isVisible()) {
				view.getDisplayView().setVisible(false);
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

		@Override
		public void actionPerformed(ActionEvent e) {

		}

	}

	class BtnAddListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (view.getWelcomePanel().isVisible()) {
				view.getWelcomePanel().setVisible(false);
			} else if (view.getDisplayView().isVisible()) {
				view.getDisplayView().setVisible(false);
			} else {
				view.getEditView().setVisible(false);
			}
			view.getAddRecipeView().setVisible(true);

		}

	}

	class BtnHomeListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (view.getAddRecipeView().isVisible()) {
				view.getAddRecipeView().setVisible(false);
			} else if (view.getDisplayView().isVisible()) {
				view.getDisplayView().setVisible(false);
			} else {
				view.getEditView().setVisible(false);
			}
			view.getWelcomePanel().setVisible(true);
		}

	}
}
