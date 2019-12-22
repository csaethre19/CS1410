package thanksgiving;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Image;

import javax.swing.border.LineBorder;
import javax.swing.JTextArea;
import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Creates a JPanel that displays a Recipe object's ingredients and directions
 * read from a file.
 * 
 * @author Charlotte Saethre
 *
 */
@SuppressWarnings("serial")
public class RecipePanel extends JPanel {
	private JLabel recipeName;
	private JTextArea textField;

	/**
	 * Creates layout of Recipe Panel to display recipe information.
	 */
	public RecipePanel(Recipe recipe) {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));

		JLabel recipeLbl = addRecipeTitle(recipe);
		add(recipeLbl, BorderLayout.NORTH);

		JLabel ingredients = addIngredients(recipe);
		add(ingredients, BorderLayout.WEST);

		JLabel directions = addDirections(recipe);
		add(directions, BorderLayout.EAST);

		JPanel notesPanel = createUserNotesInput(recipe);

		add(notesPanel, BorderLayout.SOUTH);
		
		JLabel recipeImage = addRecipeImage(recipe);
		add(recipeImage, BorderLayout.CENTER);

	}

	/**
	 * Creates user notes input section that allows user to add notes to recipe.
	 * 
	 * @param recipe recipe being displayed
	 * @return JPanel for notes section
	 */
	private JPanel createUserNotesInput(Recipe recipe) {
		JPanel notesPanel = new JPanel();
		notesPanel.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(128, 0, 0)));
		notesPanel.setBackground(new Color(255, 255, 255));

		JLabel lblRecipeNotes = new JLabel("Recipe Notes....");
		lblRecipeNotes.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 12));
		notesPanel.add(lblRecipeNotes);

		textField = new JTextArea("Notes...");
		textField.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		textField.setRows(1);
		notesPanel.add(textField);
		textField.setColumns(50);

		JButton btnSubmit = new JButton("submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recipe.writeNote(recipe.getFile(), textField.getText());
				textField.setText("");
			}
		});
		btnSubmit.setFont(new Font("Courier New", Font.BOLD, 12));
		notesPanel.add(btnSubmit);

		return notesPanel;
	}

	/**
	 * Sets the text for directions of recipe being displayed. 
	 * 
	 * @param recipe recipe being displayed
	 * @return JLabel that displays directions
	 */
	private JLabel addDirections(Recipe recipe) {

		JLabel directions = new JLabel("<html><center><h1>Directions:</h1></center>" + recipe.getDirections()
				+ recipe.getNotes());
		directions.setBorder(new EmptyBorder(40, 40, 40, 40));
		directions.setHorizontalAlignment(SwingConstants.CENTER);
		directions.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 14));

		return directions;
	}

	/**
	 * Sets the text for ingredients list of recipe being displayed.
	 * @param recipe recipe being displayed
	 * @return JLabel that displays ingredients
	 */
	private JLabel addIngredients(Recipe recipe) {

		JLabel ingredientsList = new JLabel("<html><center><h1>Ingredients:</h1></center>" + recipe.getIngredients());
		ingredientsList.setBorder(new EmptyBorder(40, 40, 40, 40));
		ingredientsList.setHorizontalAlignment(SwingConstants.CENTER);
		ingredientsList.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 14));

		return ingredientsList;
	}

	/**
	 * Sets text for title of recipe being displayed. 
	 * 
	 * @param recipe recipe being displayed
	 * @return JLabel with name of recipe
	 */
	private JLabel addRecipeTitle(Recipe recipe) {
		recipeName = new JLabel(recipe.getName() + ":");
		recipeName.setFont(new Font("Vivaldi", Font.BOLD, 48));
		recipeName.setBorder(new LineBorder(new Color(165, 42, 42), 8, true));
		recipeName.setHorizontalAlignment(SwingConstants.CENTER);
		return recipeName;
	}
	
	/**
	 * Sets the image to be displayed for recipe.
	 * 
	 * @param recipe recipe being displayed
	 * @return JLabel with image of recipe
	 */
	private JLabel addRecipeImage(Recipe recipe) {
		JLabel recipeImageLbl = new JLabel();
		recipeImageLbl.setHorizontalAlignment(SwingConstants.CENTER);
		recipeImageLbl.setBackground(Color.WHITE);
		recipeImageLbl.setSize(240, 300);
		ImageIcon img = new ImageIcon("RecipeImages\\" + recipe.getRecipeImage());
		recipeImageLbl.setIcon(new ImageIcon(img.getImage().getScaledInstance(recipeImageLbl.getWidth(), 
			recipeImageLbl.getHeight(), Image.SCALE_SMOOTH)));
		
		return recipeImageLbl;
	}

}
