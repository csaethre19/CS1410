package recipeApp.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

import recipeApp.controller.RecipeAppController;
import recipeApp.model.Recipe;
import recipeApp.model.RecipeAppModel;
/**
 * 
 * @author charl
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
	private static List<Recipe> recipes = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecipeAppView frame = new RecipeAppView();
					RecipeAppModel model = new RecipeAppModel();
					@SuppressWarnings("unused")
					RecipeAppController controller = new RecipeAppController(frame, model);
					recipes = model.getRecipesList();
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
		setBounds(100, 100, 650, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel recipePanel = createRecipePanel();
		contentPane.add(recipePanel, BorderLayout.CENTER);

		JPanel menuPanel = createMenuPanel();
		contentPane.add(menuPanel, BorderLayout.SOUTH);
	}

	private JPanel createMenuPanel() {
		JPanel menuPanel = new JPanel();
		menuPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JLabel lblRecipeDropdown = createLblRecipeDropdown();
		menuPanel.add(lblRecipeDropdown);

		recipeDropdown = createRecipeDropdown();
		menuPanel.add(recipeDropdown);

		btnViewRecipe = createBtnViewRecipe();
		menuPanel.add(btnViewRecipe);

		btnEditRecipe = createBtnEditRecipe();
		menuPanel.add(btnEditRecipe);

		btnDeleteRecipe = createBtnDeleteRecipe();
		menuPanel.add(btnDeleteRecipe);

		btnAddRecipe = createBtnAddRecipe();
		menuPanel.add(btnAddRecipe);

		return menuPanel;
	}

	private JButton createBtnAddRecipe() {
		JButton btnAddRecipe = new JButton("Add");
		btnAddRecipe.setFont(new Font("Calibri", Font.PLAIN, 16));
		return btnAddRecipe;
	}

	private JButton createBtnDeleteRecipe() {
		JButton btnDeleteRecipe = new JButton("Delete");
		btnDeleteRecipe.setFont(new Font("Calibri", Font.PLAIN, 16));
		return btnDeleteRecipe;
	}

	private JButton createBtnEditRecipe() {
		JButton btnEditRecipe = new JButton("Edit");
		btnEditRecipe.setFont(new Font("Calibri", Font.PLAIN, 16));
		return btnEditRecipe;
	}

	private JButton createBtnViewRecipe() {
		JButton btnViewRecipe = new JButton("View");
		btnViewRecipe.setFont(new Font("Calibri", Font.PLAIN, 16));
		return btnViewRecipe;
	}
	
	/**
	 * 
	 * @param listener
	 */
	public void addBtnViewListener(ActionListener listener) {
		btnViewRecipe.addActionListener(listener);
	}

	private JComboBox<String> createRecipeDropdown() {
		JComboBox<String> recipeDropdown = new JComboBox<String>();
		recipeDropdown.setBorder(new EmptyBorder(4, 8, 4, 8));
		recipeDropdown.setFont(new Font("Calibri", Font.PLAIN, 16));
		recipeDropdown.addItem("placeholder");
		return recipeDropdown;
	}
	
	public int getRecipeSelected() {
		return recipeDropdown.getSelectedIndex();
	}

	private JLabel createLblRecipeDropdown() {
		JLabel lblRecipeDropdown = new JLabel("Choose a recipe ...");
		lblRecipeDropdown.setBorder(new EmptyBorder(8, 8, 8, 8));
		lblRecipeDropdown.setFont(new Font("Calibri", Font.BOLD, 16));
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

		return recipePanel;
	}

	private JPanel createWelcomePanel() {
		JPanel welcomePanel = new JPanel();
		welcomePanel.setLayout(new BorderLayout(0, 0));

		JLabel lblDisplayImage = createLblDisplayImage();
		welcomePanel.add(lblDisplayImage, BorderLayout.CENTER);

		return welcomePanel;
	}
	
	public JPanel getWelcomePanel() {
		return this.welcomePanel;
	}
	
	public JPanel getDisplayView() {
		return this.displayView;
	}

	private JLabel createLblDisplayImage() {
		JLabel lblDisplayImage = new JLabel("");
		lblDisplayImage
				.setIcon(new ImageIcon(RecipeAppView.class.getResource("/recipeApp/view/img/desktop-recipe-book.png")));
		return lblDisplayImage;
	}

}
