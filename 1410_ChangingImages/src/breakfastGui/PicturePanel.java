package breakfastGui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 * Creates a panel that displays images of different breakfast items.
 * 
 * @author Charlotte Saethre
 *
 */
@SuppressWarnings("serial")
public class PicturePanel extends JPanel {
	private String[] brkfastMainImages = new String[] {"/breakfastGui/Images/pancakes.png/",
			"/breakfastGui/Images/toast.png/", 
			"/breakfastGui/Images/muffin.png/"};
	private String[] brkfastSideImages = new String[] {"/breakfastGui/Images/egg.png/",
			"/breakfastGui/Images/bacon.png/", 
			"/breakfastGui/Images/apple.png/"};
	private String[] brkfastDrinkImages = new String[] {"/breakfastGui/Images/coffee.png/",
			"/breakfastGui/Images/oj.png/", 
			"/breakfastGui/Images/milk.png/"};
	private String[] tableItemImages = new String[] {"/breakfastGui/Images/knifeAndFork.png/",
			"/breakfastGui/Images/sugar.png/", "/breakfastGui/Images/saltAndPepper.png/"};
	
	private Color[] colors = new Color[] {Color.cyan, Color.green, Color.magenta};
	private int mainIndex = 0;
	private int sideIndex = 0;
	private int drinkIndex = 0;
	private int colorIndex = 0;
	private int tableItemIndex = 0;

	/**
	 * Creates the panel.
	 */
	public PicturePanel() {
		setBackground(Color.cyan);
	}
	
	/**
	 * Changes the color of the background and table item. 
	 */
	public void changeBackground() {
		colorIndex = ++colorIndex % colors.length;
		setBackground(colors[colorIndex]);
		tableItemIndex = ++tableItemIndex % tableItemImages.length;
		repaint();
	}
	/**
	 * Changes the picture that displays
	 * main breakfast item. 
	 */
	public void changeBrkfastMain() {
		mainIndex = ++mainIndex % brkfastMainImages.length;
		repaint();
	}
	
	/**
	 * Changes the picture that displays
	 * side breakfast item. 
	 */
	public void changeBrkfastSide() {
		sideIndex = ++sideIndex % brkfastSideImages.length;
		repaint();
	}
	
	/**
	 * Changes the picture that displays
	 * drink to have with breakfast. 
	 */
	public void changeBrkfastDrink() {
		drinkIndex = ++drinkIndex % brkfastDrinkImages.length;
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		ImageIcon plate = new ImageIcon(
				PicturePanel.class.getResource("/breakfastGui/Images/whitePlate.png/"));
		ImageIcon brkfastMain = new ImageIcon(
				PicturePanel.class.getResource(brkfastMainImages[mainIndex]));
		ImageIcon brkfastDrink = new ImageIcon(
				PicturePanel.class.getResource(brkfastDrinkImages[drinkIndex]));
		ImageIcon brkfastSide = new ImageIcon(
				PicturePanel.class.getResource(brkfastSideImages[sideIndex]));
		ImageIcon tableItem = new ImageIcon(
				PicturePanel.class.getResource(tableItemImages[tableItemIndex]));
		plate.paintIcon(null, g, 110, -10);
		brkfastSide.paintIcon(null, g, 50, 50);
		brkfastMain.paintIcon(null, g, 50, -80);
		brkfastDrink.paintIcon(null, g, -200, -90);
		tableItem.paintIcon(null, g, 480, 100);

	}
}
