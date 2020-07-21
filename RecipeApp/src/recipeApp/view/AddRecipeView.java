package recipeApp.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class AddRecipeView extends JPanel {
	private JTextArea directionsText;
	private JTextArea ingredientsText;
	private JTextField recipeName;
	private JButton btnSubmit;

	/**
	 * Create the panel.
	 */
	public AddRecipeView() {
		setLayout(new GridLayout(4, 1, 0, 0));

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

	}

	private JPanel createNamePanel() {
		JPanel namePanel = new JPanel();
		namePanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		namePanel.setBackground(new Color(32, 178, 170));
		return namePanel;
	}

	private void createRecipeNameField() {
		recipeName = new JTextField();
		recipeName.setBorder(new EmptyBorder(10, 0, 10, 0));
	}

	private JPanel createIngredientsPanel() {
		JPanel ingredientsPanel = new JPanel();
		ingredientsPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		ingredientsPanel.setBackground(new Color(32, 178, 170));
		return ingredientsPanel;
	}

	private JPanel createDirectionsPanel() {
		JPanel directionsPanel = new JPanel();
		directionsPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		directionsPanel.setBackground(new Color(32, 178, 170));
		return directionsPanel;
	}

	private void createSubmitBtn() {
		btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 16));
	}

	private void createDirectionsTextArea() {
		directionsText = new JTextArea();
		directionsText.setRows(3);
		directionsText.setColumns(20);
		directionsText.setLineWrap(true);
	}

	private JLabel createLblDirections() {
		JLabel lblDirections = new JLabel("Directions:");
		lblDirections.setBorder(new EmptyBorder(10, 20, 10, 20));
		lblDirections.setFont(new Font("Tahoma", Font.PLAIN, 16));
		return lblDirections;
	}

	private void createIngredientsTextArea() {
		ingredientsText = new JTextArea();
		ingredientsText.setColumns(20);
		ingredientsText.setRows(3);
		ingredientsText.setLineWrap(true);
	}

	private JLabel createLblIngredients() {
		JLabel lblIngredients = new JLabel("Ingredients:");
		lblIngredients.setHorizontalAlignment(SwingConstants.LEFT);
		lblIngredients.setBorder(new EmptyBorder(10, 20, 10, 20));
		lblIngredients.setFont(new Font("Tahoma", Font.PLAIN, 16));
		return lblIngredients;
	}

	private JLabel createLblRecipeName() {
		JLabel lblRecipeName = new JLabel("Recipe Name:");
		lblRecipeName.setHorizontalAlignment(SwingConstants.LEFT);
		lblRecipeName.setBorder(new EmptyBorder(20, 0, 0, 0));
		lblRecipeName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		return lblRecipeName;
	}

	public String getRecipeDirections() {
		return this.directionsText.getSelectedText();
	}

	public String getRecipeIngredients() {
		return this.ingredientsText.getSelectedText();
	}

}
