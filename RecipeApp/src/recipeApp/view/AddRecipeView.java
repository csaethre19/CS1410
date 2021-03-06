package recipeApp.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

import recipeApp.controller.AddRecipeController;
import recipeApp.model.RecipeAppModel;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
/**
 * Displays view that allows a user to add a recipe.
 * 
 * @author Charlotte Saethre
 *
 */
@SuppressWarnings("serial")
public class AddRecipeView extends JPanel {
	private JTextArea directionsText;
	private JTextArea ingredientsText;
	private JTextField recipeName;
	private JButton btnSubmit;
	private JButton btnClear;
	@SuppressWarnings("unused")
	private RecipeAppView mainView;
	@SuppressWarnings("unused")
	private RecipeAppModel model;

	/**
	 * Create the panel.
	 */
	public AddRecipeView(RecipeAppView mainView, RecipeAppModel model) {
		setLayout(new GridLayout(4, 1, 0, 0));

		this.mainView = mainView;
		this.model = model;
		
		JPanel namePanel = createNamePanel();
		add(namePanel);

		JLabel lblRecipeName = createLblRecipeName();
		namePanel.add(lblRecipeName);

		createRecipeNameField();
		namePanel.add(recipeName);
		recipeName.setColumns(20);

		JPanel ingredientsPanel = createIngredientsPanel();
		add(ingredientsPanel);

		JLabel lblIngredients = createLblIngredients();
		ingredientsPanel.add(lblIngredients);

		createIngredientsTextArea();
		JScrollPane ingScroll = new JScrollPane(ingredientsText);
		ingredientsPanel.add(ingScroll);

		JPanel directionsPanel = createDirectionsPanel();
		add(directionsPanel);

		JLabel lblDirections = createLblDirections();
		directionsPanel.add(lblDirections);

		createDirectionsTextArea();
		JScrollPane dirScroll = new JScrollPane(directionsText);
		directionsPanel.add(dirScroll);

		JPanel submitPanel = new JPanel();
		submitPanel.setBackground(new Color(255, 255, 240));
		add(submitPanel);

		createSubmitBtn();
		submitPanel.add(btnSubmit);

		btnClear = createClearBtn();
		submitPanel.add(btnClear);

		@SuppressWarnings("unused")
		AddRecipeController controller = new AddRecipeController(this, model, mainView);

	}

	private JButton createClearBtn() {
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Book Antiqua", Font.PLAIN, 16));
		return btnClear;
	}
	
	/**
	 * Adds ActionListener to clear button.
	 * 
	 * @param listener
	 */
	public void addClearBtnListener(ActionListener listener) {
		btnClear.addActionListener(listener);
	}

	private JPanel createNamePanel() {
		JPanel namePanel = new JPanel();
		namePanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		namePanel.setBackground(new Color(245, 222, 179));
		return namePanel;
	}

	private void createRecipeNameField() {
		recipeName = new JTextField();
		recipeName.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	}

	private JPanel createIngredientsPanel() {
		JPanel ingredientsPanel = new JPanel();
		ingredientsPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		ingredientsPanel.setBackground(new Color(245, 222, 179));
		return ingredientsPanel;
	}

	private JPanel createDirectionsPanel() {
		JPanel directionsPanel = new JPanel();
		directionsPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		directionsPanel.setBackground(new Color(245, 222, 179));
		return directionsPanel;
	}

	private void createSubmitBtn() {
		btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Book Antiqua", Font.PLAIN, 16));
	}

	/**
	 * Adds ActionListener to submit button.
	 * 
	 * @param listener
	 */
	public void addSubmitBtnListener(ActionListener listener) {
		btnSubmit.addActionListener(listener);
	}

	private void createDirectionsTextArea() {
		directionsText = new JTextArea();
		directionsText.setRows(6);
		directionsText.setColumns(40);
		directionsText.setLineWrap(true);
	}
	
	/**
	 * Sets directions text.
	 * 
	 * @param text
	 */
	public void setDirections(String text) {
		directionsText.setText(text);
	}

	private JLabel createLblDirections() {
		JLabel lblDirections = new JLabel("Directions:");
		lblDirections.setBorder(new EmptyBorder(10, 20, 10, 20));
		lblDirections.setFont(new Font("Book Antiqua", Font.PLAIN, 16));
		return lblDirections;
	}

	private void createIngredientsTextArea() {
		ingredientsText = new JTextArea();
		ingredientsText.setColumns(40);
		ingredientsText.setRows(6);
		ingredientsText.setLineWrap(true);
	}
	
	/**
	 * Sets ingredients text. 
	 * 
	 * @param text
	 */
	public void setIngredients(String text) {
		ingredientsText.setText(text);
	}

	private JLabel createLblIngredients() {
		JLabel lblIngredients = new JLabel("Ingredients:");
		lblIngredients.setHorizontalAlignment(SwingConstants.LEFT);
		lblIngredients.setBorder(new EmptyBorder(10, 20, 10, 20));
		lblIngredients.setFont(new Font("Book Antiqua", Font.PLAIN, 16));
		return lblIngredients;
	}

	private JLabel createLblRecipeName() {
		JLabel lblRecipeName = new JLabel("Recipe Name:");
		lblRecipeName.setHorizontalAlignment(SwingConstants.LEFT);
		lblRecipeName.setBorder(new EmptyBorder(10, 0, 10, 0));
		lblRecipeName.setFont(new Font("Book Antiqua", Font.PLAIN, 16));
		return lblRecipeName;
	}
	
	/**
	 * Sets recipe name label.
	 * 
	 * @param text
	 */
	public void setLblRecipeName(String text) {
		recipeName.setText(text);
	}

	/**
	 * Returns user input for recipe name.
	 * 
	 * @return name of recipe
	 */
	public String getRecipeName() {
		return this.recipeName.getText();
	}

	/**
	 * Returns user input for recipe directions.
	 * 
	 * @return
	 */
	public String getRecipeDirections() {
		return this.directionsText.getText();
	}

	/**
	 * Returns user input for recipe ingredients.
	 * @return
	 */
	public String getRecipeIngredients() {
		return this.ingredientsText.getText();
	}

}
