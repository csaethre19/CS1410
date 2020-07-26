package recipeApp.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

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
		setBackground(new Color(176, 224, 230));
		setLayout(new GridLayout(0, 2, 0, 0));
		lblRecipeName = createLblRecipeName();
		add(lblRecipeName);

		JLabel emptyBlock = new JLabel("What you need and what to do!");
		add(emptyBlock);

		JLabel lblDirections_Tag = createLblDirectionsTag();
		add(lblDirections_Tag);

		lblDirections = createDirectionsSection();
		JScrollPane dirScroll = new JScrollPane(lblDirections);
		add(dirScroll);

		JLabel lblIngredients_Tag = createLblIngredientsTag();
		add(lblIngredients_Tag);

		lblIngredients = createIngredientsSection();
		JScrollPane ingScroll = new JScrollPane(lblIngredients);
		add(ingScroll);

	}

	private JLabel createLblDirectionsTag() {
		JLabel lblDirections_Tag = new JLabel("Directions:");
		lblDirections_Tag.setHorizontalAlignment(SwingConstants.CENTER);
		lblDirections_Tag.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblDirections_Tag.setFont(new Font("Tahoma", Font.PLAIN, 18));
		return lblDirections_Tag;
	}

	private JLabel createLblIngredientsTag() {
		JLabel lblIngredients_Tag = new JLabel("Ingredients:");
		lblIngredients_Tag.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngredients_Tag.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblIngredients_Tag.setFont(new Font("Tahoma", Font.PLAIN, 18));
		return lblIngredients_Tag;
	}

	public void setLblRecipeName(String name) {
		this.lblRecipeName.setText("Recipe: " + name);
	}

	public void setLblDirections(String directions) {
		this.lblDirections.setText(directions);
	}

	public void setLblIngredients(String ingredients) {
		this.lblIngredients.setText(ingredients);
	}

	private JLabel createIngredientsSection() {
		JLabel lblIngredients = new JLabel("Ingredients: ");
		lblIngredients.setBorder(new EmptyBorder(0, 20, 0, 20));
		lblIngredients.setFont(new Font("Tahoma", Font.PLAIN, 16));
		return lblIngredients;
	}

	private JLabel createDirectionsSection() {
		JLabel lblDirections = new JLabel("Directions: ");
		lblDirections.setBorder(new EmptyBorder(0, 20, 0, 20));
		lblDirections.setFont(new Font("Tahoma", Font.PLAIN, 16));
		return lblDirections;
	}

	private JLabel createLblRecipeName() {
		JLabel lblRecipeName = new JLabel("recipe name");
		lblRecipeName.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblRecipeName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRecipeName.setHorizontalAlignment(SwingConstants.CENTER);
		return lblRecipeName;
	}

}
