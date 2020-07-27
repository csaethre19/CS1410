package recipeApp.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import recipeApp.controller.EditRecipeController;
import recipeApp.model.RecipeAppModel;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
/**
 * Displays view that allows user to edit selected recipe from combo-box.
 * 
 * @author Charlotte Saethre
 *
 */
@SuppressWarnings("serial")
public class EditRecipeView extends JPanel {
	private JTextField recipeName;
	private JButton btnUpdate;
	private JButton btnClear;
	private JTextArea directionsText;
	private JTextArea ingredientsText;
	@SuppressWarnings("unused")
	private RecipeAppView mainView;
	@SuppressWarnings("unused")
	private RecipeAppModel model;

	/**
	 * Create the panel.
	 */
	public EditRecipeView(RecipeAppView mainView, RecipeAppModel model) {
		
		this.mainView = mainView;
		this.model = model;
		
		setLayout(new GridLayout(4, 1, 0, 0));

		JPanel namePanel = createNamePanel();
		add(namePanel);

		JPanel ingredientsPanel = createIngredientsPanel();
		add(ingredientsPanel);

		JPanel directionsPanel = createDirectionsPanel();
		add(directionsPanel);

		JPanel updatePanel = createUpdatePanel();
		add(updatePanel);
		
		@SuppressWarnings("unused")
		EditRecipeController controller = new EditRecipeController(this, model, mainView);
	}

	private JPanel createUpdatePanel() {
		JPanel updatePanel = new JPanel();

		btnUpdate = createBtnUpdate();
		updatePanel.add(btnUpdate);

		btnClear = createBtnClear();
		updatePanel.add(btnClear);

		return updatePanel;
	}

	/**
	 * Sets recipe name.
	 * 
	 * @param name name of recipe
	 */
	public void setRecipeName(String name) {
		this.recipeName.setText(name);
	}
	
	/**
	 * Sets recipe directions.
	 * 
	 * @param text recipe directions
	 */
	public void setDirectionsText(String text) {
		this.directionsText.setText(text);
	}
	
	/**
	 * Sets recipe ingredients.
	 * 
	 * @param text recipe ingredients
	 */
	public void setIngredientsText(String text) {
		this.ingredientsText.setText(text);
	}
	
	/**
	 * Returns name of recipe.
	 * 
	 * @return recipe name
	 */
	public String getRecipeName() {
		return this.recipeName.getText();
	}
	
	/**
	 * Returns ingredients of recipe.
	 * 
	 * @return recipe ingredients
	 */
	public String getRecipeIngredients() {
		return this.ingredientsText.getText();
	}
	
	/**
	 * Returns directions of recipe.
	 * 
	 * @return recipe directions
	 */
	public String getRecipeDirections() {
		return this.directionsText.getText();
	}
	
	private JButton createBtnClear() {
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Book Antiqua", Font.PLAIN, 16));
		return btnClear;
	}
	
	/**
	 * Adds ActionListener to clear button.
	 * 
	 * @param listener
	 */
	public void addClearListener(ActionListener listener) {
		this.btnClear.addActionListener(listener);
	}

	private JButton createBtnUpdate() {
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Book Antiqua", Font.PLAIN, 16));
		return btnUpdate;
	}
	
	/**
	 * Adds ActionListener to update button.
	 * 
	 * @param listener
	 */
	public void addUpdateListener(ActionListener listener) {
		this.btnUpdate.addActionListener(listener);
	}

	private JPanel createDirectionsPanel() {
		JPanel directionsPanel = new JPanel();

		directionsPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		directionsPanel.setBackground(new Color(245, 222, 179));
		
		JLabel lblDirections = createLblDirections();
		directionsPanel.add(lblDirections);

		directionsText = createDirectionsTextArea();
		JScrollPane scrollDir = new JScrollPane(directionsText);
		directionsPanel.add(scrollDir);

		return directionsPanel;
	}

	private JTextArea createDirectionsTextArea() {
		JTextArea directionsText = new JTextArea();
		directionsText.setColumns(40);
		directionsText.setRows(6);
		directionsText.setLineWrap(true);
		return directionsText;
	}

	private JLabel createLblDirections() {
		JLabel lblDirections = new JLabel("Directions: ");
		lblDirections.setFont(new Font("Book Antiqua", Font.PLAIN, 16));
		lblDirections.setBorder(new EmptyBorder(10, 20, 10, 20));
		return lblDirections;
	}

	private JPanel createIngredientsPanel() {
		JPanel ingredientsPanel = new JPanel();

		ingredientsPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		ingredientsPanel.setBackground(new Color(245, 222, 179));
		
		JLabel lblIngredients = createLblIngredients();
		ingredientsPanel.add(lblIngredients);

		ingredientsText = createIngredientsTextArea();
		JScrollPane scrollIng = new JScrollPane(ingredientsText);
		ingredientsPanel.add(scrollIng);

		return ingredientsPanel;
	}

	private JTextArea createIngredientsTextArea() {
		JTextArea ingredientsText = new JTextArea();
		ingredientsText.setColumns(40);
		ingredientsText.setRows(6);
		ingredientsText.setLineWrap(true);
		return ingredientsText;
	}

	private JLabel createLblIngredients() {
		JLabel lblIngredients = new JLabel("Ingredients: ");
		lblIngredients.setFont(new Font("Book Antiqua", Font.PLAIN, 16));
		lblIngredients.setBorder(new EmptyBorder(10, 20, 10, 20));
		return lblIngredients;
	}

	private JPanel createNamePanel() {
		JPanel namePanel = new JPanel();

		namePanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		namePanel.setBackground(new Color(245, 222, 179));
		
		JLabel lblRecipeName = createLblRecipeName();
		namePanel.add(lblRecipeName);

		createRecipeNameField();
		namePanel.add(recipeName);
		recipeName.setColumns(20);

		return namePanel;
	}

	private void createRecipeNameField() {
		recipeName = new JTextField();
		recipeName.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	}

	private JLabel createLblRecipeName() {
		JLabel lblRecipeName = new JLabel("Recipe Name: ");
		lblRecipeName.setFont(new Font("Book Antiqua", Font.PLAIN, 16));
		lblRecipeName.setBorder(new EmptyBorder(10, 0, 10, 0));
		return lblRecipeName;
	}

}
