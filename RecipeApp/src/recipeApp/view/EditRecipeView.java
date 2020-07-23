package recipeApp.view;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class EditRecipeView extends JPanel {
	private JTextField recipeName;
	private JButton btnUpdate;
	private JButton btnClear;
	private JTextArea directionsText;
	private JTextArea ingredientsText;

	/**
	 * Create the panel.
	 */
	public EditRecipeView() {
		setLayout(new GridLayout(4, 1, 0, 0));

		JPanel namePanel = createNamePanel();
		add(namePanel);

		JPanel ingredientsPanel = createIngredientsPanel();
		add(ingredientsPanel);

		JPanel directionsPanel = createDirectionsPanel();
		add(directionsPanel);

		JPanel updatePanel = createUpdatePanel();
		add(updatePanel);

	}

	private JPanel createUpdatePanel() {
		JPanel updatePanel = new JPanel();

		btnUpdate = createBtnUpdate();
		updatePanel.add(btnUpdate);

		btnClear = createBtnClear();
		updatePanel.add(btnClear);

		return updatePanel;
	}

	private JButton createBtnClear() {
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 16));
		return btnClear;
	}

	private JButton createBtnUpdate() {
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		return btnUpdate;
	}

	private JPanel createDirectionsPanel() {
		JPanel directionsPanel = new JPanel();

		directionsPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		directionsPanel.setBackground(new Color(255, 127, 80));
		
		JLabel lblDirections = createLblDirections();
		directionsPanel.add(lblDirections);

		directionsText = createDirectionsTextArea();
		directionsPanel.add(directionsText);

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
		ingredientsPanel.add(ingredientsText);

		return ingredientsPanel;
	}

	private JTextArea createIngredientsTextArea() {
		JTextArea ingredientsText = new JTextArea();
		ingredientsText.setColumns(20);
		ingredientsText.setRows(3);
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
