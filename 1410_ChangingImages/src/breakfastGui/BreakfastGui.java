package breakfastGui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
/**
 * Creates a window that generates a picture panel 
 * that displays different breakfast items that can be changed by 
 * the user. 
 * 
 * @author Charlotte Saethre
 *
 */
@SuppressWarnings("serial")
public class BreakfastGui extends JFrame {

	private JPanel contentPane;
	private JCheckBox chckbxMainDish;
	private JCheckBox chckbxSideDish;
	private JCheckBox chckbxDrink;
	private PicturePanel breakfastPanel;
	private JLabel lblWhatsForBreakfast;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BreakfastGui frame = new BreakfastGui();
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
	public BreakfastGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel controlPanel = createControlPanel();
		contentPane.add(controlPanel, BorderLayout.SOUTH);

		breakfastPanel = new PicturePanel();
		contentPane.add(breakfastPanel, BorderLayout.CENTER);
		
		createBreakfastGuiTitle();
		breakfastPanel.add(lblWhatsForBreakfast);
	}

	/**
	 * Creates breakfast gui title:
	 * {What's for Breakfast?} 
	 */
	private void createBreakfastGuiTitle() {
		lblWhatsForBreakfast = new JLabel("What's for Breakfast?");
		lblWhatsForBreakfast.setFont(new Font("Snap ITC", Font.BOLD, 24));
		lblWhatsForBreakfast.setHorizontalAlignment(SwingConstants.CENTER);
	}

	/**
	 * Creates control panel that allows user to change breakfast items being
	 * displayed.
	 * 
	 * @return controlPanel
	 */
	private JPanel createControlPanel() {
		JPanel controlPanel = new JPanel();

		chckbxMainDish = new JCheckBox("Main dish");
		chckbxMainDish.setBorder(new EmptyBorder(8, 16, 8, 16));
		controlPanel.add(chckbxMainDish);

		chckbxSideDish = new JCheckBox("Side dish");
		chckbxSideDish.setBorder(new EmptyBorder(8, 16, 8, 16));
		controlPanel.add(chckbxSideDish);
		
		chckbxDrink = new JCheckBox("Drink");
		chckbxDrink.setBorder(new EmptyBorder(8, 16, 8, 16));
		controlPanel.add(chckbxDrink);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setBorder(new EmptyBorder(8, 16, 8, 16));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxMainDish.isSelected()) {
					breakfastPanel.changeBrkfastMain();
				}
				
				if (chckbxSideDish.isSelected()) {
					breakfastPanel.changeBrkfastSide();
				}
				
				if (chckbxDrink.isSelected()) {
					breakfastPanel.changeBrkfastDrink();
				}
				
				if (!chckbxMainDish.isSelected() && !chckbxSideDish.isSelected()
						&& !chckbxDrink.isSelected())  {
					breakfastPanel.changeBackground();
				}
			}
		});
		controlPanel.add(btnSubmit);

		return controlPanel;
	}

}
