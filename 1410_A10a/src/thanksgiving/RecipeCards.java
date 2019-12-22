package thanksgiving;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Image;
import java.util.List;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.border.EmptyBorder;

/**
 * Creates a stack of Recipe Panels that displays a chosen recipe to the user. 
 * 
 * @author Kim Harvey
 *
 */
@SuppressWarnings("serial")
public class RecipeCards extends JPanel {
	private JTextField userInstruction;
		
	/**
	 * Create the Panel which contains a layout of five total panels:
	 * Welcome Panel + Panel for each of the 4 recipes presented
	 */
	public RecipeCards(List<Recipe> recipes) {		
		setBackground(Color.WHITE);
		setLayout(new CardLayout(0, 0));
		
		JPanel welcomePanel = createWelcomePanel();
		add(welcomePanel, "welcome_screen");

		RecipePanel panelRecipe_1 = new RecipePanel(recipes.get(0));
		add(panelRecipe_1, "recipe_one");

		RecipePanel panelRecipe_2 = new RecipePanel(recipes.get(1));
		add(panelRecipe_2, "recipe_two");

		RecipePanel panelRecipe_3 = new RecipePanel(recipes.get(2));
		add(panelRecipe_3, "recipe_three");

		RecipePanel panelRecipe_4 = new RecipePanel(recipes.get(3));
		add(panelRecipe_4, "recipe_four");

	}

	/**
	 * Creates JPanel screen that displays to user when program first opens.
	 * Contains instructions on how to get started, and Thanksgiving themed image.
	 * @return
	 */
	private JPanel createWelcomePanel() {
		JPanel welcomePanel = new JPanel();
		welcomePanel.setBackground(Color.WHITE);
		welcomePanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblwelcomeImage = createWelcomeImage();
		welcomePanel.add(lblwelcomeImage, BorderLayout.CENTER);
				
		createUserInstructions();
		welcomePanel.add(userInstruction, BorderLayout.SOUTH);
		return welcomePanel;
	}

	/**
	 * Sets text in Welcome Panel to instruct user how to begin.
	 */
	private void createUserInstructions() {
		userInstruction = new JTextField();
		userInstruction.setBorder(new EmptyBorder(10, 0, 10, 0));
		userInstruction.setEditable(false);
		userInstruction.setHorizontalAlignment(SwingConstants.CENTER);
		userInstruction.setFont(new Font("Script MT Bold", Font.BOLD | Font.ITALIC, 18));
		userInstruction.setText("Please select a recipe to get started...");
		
		userInstruction.setColumns(10);
	}

	/**
	 * Sets holiday image on welcome screen.
	 * @return
	 */
	private JLabel createWelcomeImage() {
		JLabel lblwelcomeImage = new JLabel();
		lblwelcomeImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblwelcomeImage.setBackground(Color.WHITE);
		lblwelcomeImage.setSize(650, 400);
		ImageIcon img = new ImageIcon(RecipeCards.class.getResource("/thanksgiving/Images/thanksgiving.jpg"));
		lblwelcomeImage.setIcon(new ImageIcon(img.getImage().getScaledInstance(lblwelcomeImage.getWidth(), 
			lblwelcomeImage.getHeight(), Image.SCALE_SMOOTH)));
		
		return lblwelcomeImage;
	}
	
	/**
	 * Takes key to find which card to display.
	 * @param key
	 */
	public void showCard(String key) {
		CardLayout layout = (CardLayout) this.getLayout();
		layout.show(this, key);
	}
}
