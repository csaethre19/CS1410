package thanksgiving;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

/**
 * Creates a JFrame that allows a user to pick from four different thanksgiving
 * recipes. The ingredients list and directions are then displayed to the user, along with 
 * the Recipe's image. 
 * The user has the option to input notes that get added to the file after directions. 
 * Once the application is reopened the notes will be displayed as well.
 * 
 * @author Charlotte Saethre & Kimberlie Harvey
 *
 */
@SuppressWarnings("serial")
public class ThanksgivingApp extends JFrame {

	private List<Recipe> recipes = new ArrayList<>();
	private JPanel contentPane;
	private RecipeCards displayPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThanksgivingApp frame = new ThanksgivingApp();
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
	public ThanksgivingApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 640);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		List<String> recipeFiles = new ArrayList<>();
		File recipeFilePath = new File("Recipes");
		for (File el : recipeFilePath.listFiles()) {
			recipeFiles.add(el.getName());
		}
		List<String> recipeImageFiles = new ArrayList<>();
		File imagePath = new File("RecipeImages");
		for (File el : imagePath.listFiles()) {
			recipeImageFiles.add(el.getName());
		}
		for (int i = 0; i < recipeFiles.size(); i++) {
			recipes.add(new Recipe(recipeFiles.get(i), recipeImageFiles.get(i)));
		}
		JPanel controlPanel = createControlPanel();
		contentPane.add(controlPanel, BorderLayout.WEST);

		displayPanel = new RecipeCards(recipes);
		contentPane.add(displayPanel, BorderLayout.CENTER);
	}

	/**
	 * Creates control panel that allows user to choose the recipe that is to be
	 * displayed.
	 * 
	 * @return control panel
	 */
	private JPanel createControlPanel() {
		JPanel controlPanel = new JPanel();
		controlPanel.setForeground(new Color(255, 255, 255));
		controlPanel.setBorder(new EmptyBorder(0, 0, 0, 10));
		controlPanel.setBackground(Color.WHITE);
		controlPanel.setLayout(new GridLayout(4, 1, 0, 25));
		
		JButton recipe1 = new JButton(recipes.get(0).getName());
		recipe1.setForeground(new Color(255, 255, 255));
		recipe1.setFont(new Font("Book Antiqua", Font.BOLD, 12));
		recipe1.setBackground(new Color(128, 0, 0));
		recipe1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayPanel.showCard("recipe_one");
			}
		});

		JButton recipe2 = new JButton(recipes.get(1).getName());
		recipe2.setForeground(new Color(255, 255, 255));
		recipe2.setFont(new Font("Book Antiqua", Font.BOLD, 12));
		recipe2.setBackground(new Color(128, 0, 0));
		recipe2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayPanel.showCard("recipe_two");
			}
		});

		JButton recipe3 = new JButton(recipes.get(2).getName());
		recipe3.setForeground(new Color(255, 255, 255));
		recipe3.setFont(new Font("Book Antiqua", Font.BOLD, 12));
		recipe3.setBackground(new Color(128, 0, 0));
		recipe3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayPanel.showCard("recipe_three");
			}
		});

		JButton recipe4 = new JButton(recipes.get(3).getName());
		recipe4.setForeground(new Color(255, 255, 255));
		recipe4.setFont(new Font("Book Antiqua", Font.BOLD, 12));
		recipe4.setBackground(new Color(128, 0, 0));
		recipe4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				displayPanel.showCard("recipe_four");
			}
		});
		controlPanel.add(recipe1);
		controlPanel.add(recipe2);
		controlPanel.add(recipe3);
		controlPanel.add(recipe4);

		return controlPanel;
	}

}
