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

@SuppressWarnings("serial")
public class EditRecipeView extends JPanel {
	private JTextField recipeName;
	private JButton btnUpdate;
	private JButton btnClear;
	private JTextArea directionsText;
	private JTextArea ingredientsText;
	private RecipeAppView mainView;

	/**
	 * Create the panel.
	 */
	public EditRecipeView(RecipeAppView mainView) {
		
		this.mainView = mainView;
		
		setLayout(new GridLayout(4, 1, 0, 0));

		JPanel namePanel = createNamePanel();
		add(namePanel);

		JPanel ingredientsPanel = createIngredientsPanel();
		add(ingredientsPanel);

		JPanel directionsPanel = createDirectionsPanel();
		add(directionsPanel);

		JPanel updatePanel = createUpdatePanel();
		add(updatePanel);
		
		RecipeAppModel model = new RecipeAppModel();
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

	public void setRecipeName(String name) {
		this.recipeName.setText(name);
	}
	
	public void setDirectionsText(String text) {
		this.directionsText.setText(text);
	}
	
	public void setIngredientsText(String text) {
		this.ingredientsText.setText(text);
	}
	
	public String getRecipeName() {
		return this.recipeName.getText();
	}
	
	public String getRecipeIngredients() {
		return this.ingredientsText.getText();
	}
	
	public String getRecipeDirections() {
		return this.directionsText.getText();
	}
	
	private JButton createBtnClear() {
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 16));
		return btnClear;
	}
	
	public void addClearListener(ActionListener listener) {
		this.btnClear.addActionListener(listener);
	}

	private JButton createBtnUpdate() {
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		return btnUpdate;
	}
	
	public void addUpdateListener(ActionListener listener) {
		this.btnUpdate.addActionListener(listener);
	}

	private JPanel createDirectionsPanel() {
		JPanel directionsPanel = new JPanel();

		directionsPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		directionsPanel.setBackground(new Color(255, 127, 80));
		
		JLabel lblDirections = createLblDirections();
		directionsPanel.add(lblDirections);

		directionsText = createDirectionsTextArea();
		JScrollPane scrollDir = new JScrollPane(directionsText);
		directionsPanel.add(scrollDir);

		return directionsPanel;
	}

	private JTextArea createDirectionsTextArea() {
		JTextArea directionsText = new JTextArea();
		directionsText.setColumns(20);
		directionsText.setRows(3);
		directionsText.setLineWrap(true);
		return directionsText;
	}

	private JLabel createLblDirections() {
		JLabel lblDirections = new JLabel("Directions: ");
		lblDirections.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDirections.setBorder(new EmptyBorder(10, 20, 10, 20));
		return lblDirections;
	}

	private JPanel createIngredientsPanel() {
		JPanel ingredientsPanel = new JPanel();

		ingredientsPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		ingredientsPanel.setBackground(new Color(255, 127, 80));
		
		JLabel lblIngredients = createLblIngredients();
		ingredientsPanel.add(lblIngredients);

		ingredientsText = createIngredientsTextArea();
		JScrollPane scrollIng = new JScrollPane(ingredientsText);
		ingredientsPanel.add(scrollIng);

		return ingredientsPanel;
	}

	private JTextArea createIngredientsTextArea() {
		JTextArea ingredientsText = new JTextArea();
		ingredientsText.setColumns(30);
		ingredientsText.setRows(6);
		ingredientsText.setLineWrap(true);
		return ingredientsText;
	}

	private JLabel createLblIngredients() {
		JLabel lblIngredients = new JLabel("Ingredients: ");
		lblIngredients.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIngredients.setBorder(new EmptyBorder(10, 20, 10, 20));
		return lblIngredients;
	}

	private JPanel createNamePanel() {
		JPanel namePanel = new JPanel();

		namePanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		namePanel.setBackground(new Color(255, 127, 80));
		
		JLabel lblRecipeName = createLblRecipeName();
		namePanel.add(lblRecipeName);

		createRecipeNameField();
		namePanel.add(recipeName);
		recipeName.setColumns(20);

		return namePanel;
	}

	private void createRecipeNameField() {
		recipeName = new JTextField();
		recipeName.setBorder(new EmptyBorder(10, 0, 10, 0));
	}

	private JLabel createLblRecipeName() {
		JLabel lblRecipeName = new JLabel("Recipe Name: ");
		lblRecipeName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRecipeName.setBorder(new EmptyBorder(10, 0, 10, 0));
		return lblRecipeName;
	}

}