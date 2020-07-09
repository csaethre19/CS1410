package recipeApp.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
/**
 * 
 * @author charl
 *
 */
@SuppressWarnings("serial")
public class DisplayRecipeView extends JPanel {

	private JLabel lblRecipeName;
	private JLabel lblDirections;
	private JLabel lblIngredients;

	/**
	 * Create the panel.
	 */
	public DisplayRecipeView() {
		
		lblRecipeName = createLblRecipeName();
		add(lblRecipeName);
		
		lblDirections = createLblDirections();
		add(lblDirections);
		
		lblIngredients = createLblIngredients();
		add(lblIngredients);

	}

	public void setLblRecipeName(String name) {
		this.lblRecipeName.setText(name);
	}

	public void setLblDirections(String directions) {
		this.lblDirections.setText(directions);
	}

	public void setLblIngredients(String ingredients) {
		this.lblIngredients.setText(ingredients);
	}

	private JLabel createLblIngredients() {
		JLabel lblIngredients = new JLabel("Ingredients: ");
		return lblIngredients;
	}

	private JLabel createLblDirections() {
		JLabel lblDirections = new JLabel("Directions: ");
		return lblDirections;
	}

	private JLabel createLblRecipeName() {
		JLabel lblRecipeName = new JLabel("recipe name");
		return lblRecipeName;
	}

}
