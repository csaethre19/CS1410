package recipeApp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	}

	class BtnViewListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			view.getWelcomePanel().setVisible(false);
			view.getDisplayView().setVisible(true);
			

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
			// TODO Auto-generated method stub
			
		}
		
	}
}
