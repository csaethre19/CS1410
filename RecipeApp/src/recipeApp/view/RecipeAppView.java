package recipeApp.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

import recipeApp.controller.RecipeAppController;
import recipeApp.model.Recipe;
import recipeApp.model.RecipeAppModel;

/**
 * Recipe management application that allows user to add, view, edit, and delete recipes.
 * 
 * @author Charlotte Saethre
 *
 */
@SuppressWarnings("serial")
public class RecipeAppView extends JFrame {

	private JPanel contentPane;
	private JComboBox<String> recipeDropdown;
	private DisplayRecipeView displayView;
	private JButton btnViewRecipe;
	private JButton btnEditRecipe;
	private JButton btnDeleteRecipe;
	private JButton btnAddRecipe;
	private JPanel welcomePanel;
	private RecipeAppModel model;
	private JButton btnHome;
	private AddRecipeView addView;
	private EditRecipeView editView;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					RecipeAppView frame = new RecipeAppView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RecipeAppView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel recipePanel = createRecipePanel();
		contentPane.add(recipePanel, BorderLayout.CENTER);

		JPanel menuPanel = createMenuPanel();
		contentPane.add(menuPanel, BorderLayout.SOUTH);

		@SuppressWarnings("unused")
		RecipeAppController controller = new RecipeAppController(this, model);

	}

	private JPanel createMenuPanel() {
		JPanel menuPanel = new JPanel();
		menuPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JLabel lblRecipeDropdown = createLblRecipeDropdown();
		menuPanel.add(lblRecipeDropdown);

		createRecipeDropdown();
		menuPanel.add(recipeDropdown);

		btnViewRecipe = createBtnViewRecipe();
		menuPanel.add(btnViewRecipe);

		btnEditRecipe = createBtnEditRecipe();
		menuPanel.add(btnEditRecipe);

		btnDeleteRecipe = createBtnDeleteRecipe();
		menuPanel.add(btnDeleteRecipe);

		btnAddRecipe = createBtnAddRecipe();
		menuPanel.add(btnAddRecipe);

		btnHome = createBtnHome();
		menuPanel.add(btnHome);

		return menuPanel;
	}

	private JButton createBtnHome() {
		JButton btnHome = new JButton("Home");
		btnHome.setFont(new Font("Book Antiqua", Font.PLAIN, 16));
		return btnHome;
	}

	private JButton createBtnAddRecipe() {
		JButton btnAddRecipe = new JButton("Add");
		btnAddRecipe.setFont(new Font("Book Antiqua", Font.PLAIN, 16));
		return btnAddRecipe;
	}

	private JButton createBtnDeleteRecipe() {
		JButton btnDeleteRecipe = new JButton("Delete");
		btnDeleteRecipe.setFont(new Font("Book Antiqua", Font.PLAIN, 16));
		return btnDeleteRecipe;
	}
	
	/**
	 * Adds ActionListener to delete button.
	 * 
	 * @param listener
	 */
	public void addBtnDeleteRecipeListener(ActionListener listener) {
		btnDeleteRecipe.addActionListener(listener);
	}

	private JButton createBtnEditRecipe() {
		JButton btnEditRecipe = new JButton("Edit");
		btnEditRecipe.setFont(new Font("Book Antiqua", Font.PLAIN, 16));
		return btnEditRecipe;
	}
	
	/**
	 * Adds ActionListener to edit button.
	 * 
	 * @param listener
	 */
	public void addBtnEditRecipeListener(ActionListener listener) {
		btnEditRecipe.addActionListener(listener);
	}

	private JButton createBtnViewRecipe() {
		JButton btnViewRecipe = new JButton("View");
		btnViewRecipe.setFont(new Font("Book Antiqua", Font.PLAIN, 16));
		return btnViewRecipe;
	}

	/**
	 * Adds ActionListener to view recipe button.
	 * 
	 * @param listener
	 */
	public void addBtnViewListener(ActionListener listener) {
		btnViewRecipe.addActionListener(listener);
	}

	/**
	 * Adds ActionListener to home button.
	 * 
	 * @param listener
	 */
	public void addBtnHomeListener(ActionListener listener) {
		btnHome.addActionListener(listener);
	}

	private void createRecipeDropdown() {
		this.recipeDropdown = new JComboBox<String>();
		recipeDropdown.setBorder(new EmptyBorder(4, 8, 4, 8));
		recipeDropdown.setFont(new Font("Book Antiqua", Font.PLAIN, 16));
		List<Recipe> recipes = model.getRecipesList();
		if (recipes != null) {
			setRecipeDropdown(recipes);
		}
		//return recipeDropdown;
	}

	/**
	 * Returns combo-box of recipes.
	 * 
	 * @return recipeDropdown
	 */
	public JComboBox<String> getRecipeDropdown() {
		return recipeDropdown;
	}

	/**
	 * Populates combo-box with user recipes.
	 * 
	 * @param recipes
	 */
	public void setRecipeDropdown(List<Recipe> recipes) {
		for (int i = 0; i < recipes.size(); i++) {
			String r = recipes.get(i).getRecipeName();
			if (r.length() > 20) {
				r = r.substring(0, 20) + "...";
			}
			recipeDropdown.addItem(r);
		}
	}

	/**
	 * Returns selected recipe from combo-box
	 * 
	 * @return recipeDropdown item
	 */
	public int getRecipeSelected() {
		return recipeDropdown.getSelectedIndex();
	}

	private JLabel createLblRecipeDropdown() {
		JLabel lblRecipeDropdown = new JLabel("Choose a recipe ...");
		lblRecipeDropdown.setBorder(new EmptyBorder(8, 8, 8, 8));
		lblRecipeDropdown.setFont(new Font("Book Antiqua", Font.BOLD, 16));
		return lblRecipeDropdown;
	}

	private JPanel createRecipePanel() {
		JPanel recipePanel = new JPanel();
		recipePanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		recipePanel.setLayout(new CardLayout(0, 0));

		welcomePanel = createWelcomePanel();
		recipePanel.add(welcomePanel, "name_424632408537600");
		displayView = new DisplayRecipeView();
		recipePanel.add(displayView, "name_431476528960000");

		this.model = new RecipeAppModel();
		
		addView = new AddRecipeView(this, model);
		recipePanel.add(addView, "name_269362323597800");

		editView = new EditRecipeView(this, model);
		recipePanel.add(editView, "name_480702289636600");

		return recipePanel;
	}

	/**
	 * Returns display view of recipe.
	 * 
	 * @return displayView
	 */
	public DisplayRecipeView getRecipeDisplay() {
		return this.displayView;
	}

	private JPanel createWelcomePanel() {
		JPanel welcomePanel = new JPanel();
		welcomePanel.setLayout(new BorderLayout(0, 0));

		JLabel lblDisplayImage = createLblDisplayImage();
		welcomePanel.add(lblDisplayImage, BorderLayout.CENTER);

		return welcomePanel;
	}

	/**
	 * Returns welcome message display.
	 * 
	 * @return welcomePanel
	 */
	public JPanel getWelcomePanel() {
		return this.welcomePanel;
	}
	
	/**
	 * Returns edit view for selected recipe.
	 * 
	 * @return editView
	 */
	public EditRecipeView getEditView() {
		return this.editView;
	}

	/**
	 * Returns add view.
	 * 
	 * @return addView
	 */
	public JPanel getAddRecipeView() {
		return this.addView;
	}
	
	/**
	 * Displays an alert message to user.
	 * 
	 * @param text
	 */
	public void displayAlertMessage(String text) {
		JOptionPane.showMessageDialog(this, text);
	}

	private JLabel createLblDisplayImage() {
		JLabel lblDisplayImage = new JLabel("");
		lblDisplayImage.setBorder(new EmptyBorder(0, 50, 0, 0));
		lblDisplayImage.setSize(640, 426);
		ImageIcon img = new ImageIcon(RecipeAppView.class.getResource("/recipeApp/view/img/desktop-recipe-book.png"));
		lblDisplayImage.setIcon(new ImageIcon(img.getImage().getScaledInstance(lblDisplayImage.getWidth(),
				lblDisplayImage.getHeight(), Image.SCALE_SMOOTH)));
		return lblDisplayImage;
	}

	/**
	 * Adds ActionListener to add recipe button.
	 * 
	 * @param listener
	 */
	public void addBtnAddRecipeListener(ActionListener listener) {
		btnAddRecipe.addActionListener(listener);
	}

}
