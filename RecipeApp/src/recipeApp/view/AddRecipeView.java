package recipeApp.view;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

@SuppressWarnings("serial")
public class AddRecipeView extends JPanel {
	private JTextField recipeName;
	private JTextArea directionsText;
	private JTextArea ingredientsText;

	/**
	 * Create the panel.
	 */
	public AddRecipeView() {
		setBackground(new Color(173, 216, 230));
		setLayout(new GridLayout(3, 2, 0, 0));
		
		JLabel lblRecipeName = createLblRecipeName();
		add(lblRecipeName);
		
		createRecipeNameField();
		add(recipeName);
		recipeName.setColumns(10);
		
		JLabel lblIngredients = createLblIngredients();
		add(lblIngredients);
		
		ingredientsText = createIngredientsTextArea();
		add(ingredientsText);
		
		JLabel lblDirections = createLblDirections();
		add(lblDirections);
		
		directionsText = createDirectionsTextArea();
		add(directionsText);
		directionsText.setColumns(10);

	}
	
	public String getRecipeName() {
		return this.recipeName.getSelectedText();
	}
	
	public String getRecipeDirections() {
		return this.directionsText.getSelectedText();
	}
	
	public String getRecipeIngredients() {
		return this.ingredientsText.getSelectedText();
	}

	private JTextArea createDirectionsTextArea() {
		JTextArea directionsText = new JTextArea();
		directionsText.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		directionsText.setLineWrap(true);
		return directionsText;
	}

	private JLabel createLblDirections() {
		JLabel lblDirections = new JLabel("Directions:");
		lblDirections.setHorizontalAlignment(SwingConstants.CENTER);
		lblDirections.setFont(new Font("Tahoma", Font.PLAIN, 18));
		return lblDirections;
	}

	private JTextArea createIngredientsTextArea() {
		JTextArea ingredientsText = new JTextArea();
		ingredientsText.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		ingredientsText.setLineWrap(true);
		return ingredientsText;
	}

	private JLabel createLblIngredients() {
		JLabel lblIngredients = new JLabel("Ingredients:");
		lblIngredients.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngredients.setFont(new Font("Tahoma", Font.PLAIN, 18));
		return lblIngredients;
	}

	private void createRecipeNameField() {
		recipeName = new JTextField();
	}

	private JLabel createLblRecipeName() {
		JLabel lblRecipeName = new JLabel("Recipe Name: ");
		lblRecipeName.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecipeName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		return lblRecipeName;
	}

}
