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
	}

	class BtnViewListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			view.getWelcomePanel().setVisible(false);
			view.getDisplayView().setVisible(true);
			Recipe rec = model.getRecipe(view.getRecipeSelected());
			String name = rec.getRecipeName();
			String ing = rec.getRecipeIngredients();
			String dir = rec.getRecipeDirections();
			view.getRecipeDisplay().setLblRecipeName(name);
			view.getRecipeDisplay().setLblIngredients(ing);
			view.getRecipeDisplay().setLblDirections(dir);
		}
		
	}
	
	class BtnEditListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class BtnDeleteListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class BtnAddListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (view.getWelcomePanel().isVisible()) {
				view.getWelcomePanel().setVisible(false);
			}
			else if (view.getDisplayView().isVisible()) {
				view.getDisplayView().setVisible(false);
			}
			view.getAddRecipeView().setVisible(true);
			
		}
		
	}
	
	class BtnHomeListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			view.getWelcomePanel().setVisible(true);
			view.getDisplayView().setVisible(false);
			
		}
		
	}
}
