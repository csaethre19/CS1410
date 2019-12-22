package guiDice;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

/**
 * Creates window that displays an image of a six sided die. When the user
 * clicks the "Roll 'em" button the image changes to display a new side of the
 * die indicating a random dice roll.
 * 
 * @author Charlotte Saethre
 *
 */
@SuppressWarnings("serial")
public class LabGuiDice extends JFrame {

	private JPanel contentPane;
	private JLabel lblImage;
	private String die;
	private String prevDie;
	private int roll;
	private final Random rand = new Random();
	private String[] images = new String[] {"/Images/die-1.png", "/Images/die-2.png", 
			"/Images/die-3.png", "/Images/die-4.png", "/Images/die-5.png", 
			"/Images/die-6.png"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LabGuiDice frame = new LabGuiDice();
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
	public LabGuiDice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JButton btnRollem = newBtnRollEm();
		contentPane.add(btnRollem, BorderLayout.SOUTH);

		lblImage = newLblImage();
		contentPane.add(lblImage, BorderLayout.CENTER);

	}

	/**
	 * Creates label that displays image.
	 * 
	 * @return lblImage
	 */
	private JLabel newLblImage() {
		lblImage = new JLabel("");
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		changeDice();
		lblImage.setIcon(new ImageIcon(LabGuiDice.class.getResource(die)));
		return lblImage;
	}

	/**
	 * Creates button that changes image.
	 * 
	 * @return btnRollem
	 */
	private JButton newBtnRollEm() {
		JButton btnRollem = new JButton("Roll 'Em");
		btnRollem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prevDie = die;
				do {
					changeDice();
				}
				while (isSameImage());
				lblImage.setIcon(new ImageIcon(LabGuiDice.class.getResource(die)));
				
			}
		});
		btnRollem.setBackground(Color.WHITE);
		btnRollem.setForeground(Color.BLUE);
		btnRollem.setFont(new Font("Snap ITC", Font.BOLD, 16));
		return btnRollem;
	}

	/**
	 * Generates a random number 1 - 6 that corresponds to an image of one of the
	 * six sides of a die.
	 * 
	 */
	private void changeDice() {
		roll = rand.nextInt(6);
		die = images[roll];
	}

	/**
	 * Determines if we have already seen image. 
	 * 
	 * @return true or false
	 */
	private boolean isSameImage() {
		return die.equals(prevDie);
	}
}
