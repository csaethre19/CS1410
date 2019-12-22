package guiIntro;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class LabGuiIntro extends JFrame {

	private JPanel contentPane;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LabGuiIntro frame = new LabGuiIntro();
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
	public LabGuiIntro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLabel lblNewLabel = newLblTitle();
		contentPane.add(lblNewLabel, BorderLayout.NORTH);

		JButton btnWest = westButton();
		contentPane.add(btnWest, BorderLayout.WEST);

		JLabel lblHi = redLabel();
		contentPane.add(lblHi, BorderLayout.CENTER);

		JPanel panel = newTextPanel();
		contentPane.add(panel, BorderLayout.SOUTH);

	}

	private JPanel newTextPanel() {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));

		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblName);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(textField_2);
		textField_2.setColumns(16);

		return panel;
	}

	private JLabel redLabel() {
		JLabel lblHi = new JLabel("Hi");
		lblHi.setOpaque(true);
		lblHi.setBackground(new Color(255, 0, 0));
		lblHi.setHorizontalAlignment(SwingConstants.CENTER);
		lblHi.setForeground(new Color(255, 140, 0));
		lblHi.setFont(new Font("Sitka Text", Font.PLAIN, 77));
		return lblHi;
	}

	private JButton westButton() {
		JButton btnWest = new JButton("WEST");
		btnWest.setForeground(new Color(0, 128, 0));
		btnWest.setFont(new Font("Sitka Small", Font.BOLD, 33));
		return btnWest;
	}

	private JLabel newLblTitle() {
		JLabel lblNewLabel = new JLabel("My First Gui");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(0, 0, 255));
		lblNewLabel.setForeground(new Color(0, 255, 255));
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD, 33));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		return lblNewLabel;
	}

}
