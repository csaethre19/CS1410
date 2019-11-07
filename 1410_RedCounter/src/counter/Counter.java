package counter;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

/**
 * Creates a Gui that displays a button that changes color, a label that
 * displays the number of times the color red is displayed, and a label at the
 * bottom that displays my name.
 * 
 * @author Charlotte Saethre
 *
 */
@SuppressWarnings("serial")
public class Counter extends JFrame {

	private JPanel contentPane;
	private JLabel lblRedCounter;
	private JButton btnColor;
	private Color color;
	private int count;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Counter frame = new Counter();
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
	public Counter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		lblRedCounter = newLblRedCounter();
		contentPane.add(lblRedCounter, BorderLayout.CENTER);

		JButton btnColor = newBtnColor();
		contentPane.add(btnColor, BorderLayout.EAST);

		JLabel lblMyGui = newLblMyGui();
		contentPane.add(lblMyGui, BorderLayout.SOUTH);
	}

	/**
	 * Creates label that displays my name.
	 * 
	 * @return lblMyGui
	 */
	private JLabel newLblMyGui() {
		JLabel lblMyGui = new JLabel("Charlotte's GUI");
		lblMyGui.setForeground(new Color(0, 128, 128));
		lblMyGui.setBorder(new EmptyBorder(14, 0, 14, 0));
		lblMyGui.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblMyGui.setBackground(new Color(192, 192, 192));
		lblMyGui.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyGui.setFont(new Font("Papyrus", Font.BOLD, 16));
		return lblMyGui;
	}

	/**
	 * Creates button that changes color.
	 * 
	 * @return btnColor
	 */
	private JButton newBtnColor() {
		btnColor = new JButton("Click Me");
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do {
					changeColor();
				}
				while (sameColor());
				btnColor.setBackground(color);
				if (btnColor.getBackground().equals(Color.RED)) {
					count++;
					if (count < 10) {
						lblRedCounter.setText("Red Counter:  0" + count);
					}
					else {
						lblRedCounter.setText("Red Counter: " + count);
					}
				}
			}
		});
		btnColor.setBackground(Color.BLUE);
		btnColor.setFont(new Font("Broadway", Font.BOLD, 29));
		btnColor.setForeground(Color.WHITE);
		return btnColor;
	}

	/**
	 * Creates label that counts the number of times the color red is displayed.
	 * 
	 * @return lblRedCounter
	 */
	private JLabel newLblRedCounter() {
		JLabel lblRedCounter = new JLabel("Red Counter:  00");
		lblRedCounter.setHorizontalAlignment(SwingConstants.CENTER);
		lblRedCounter.setFont(new Font("Courier New", Font.PLAIN, 28));
		lblRedCounter.setOpaque(true);
		lblRedCounter.setBackground(Color.LIGHT_GRAY);
		return lblRedCounter;
	}
	
	/**
	 * Generates random number that corresponds to a background color
	 * and sets the field <code>color</code>.
	 * 
	 */
	private void changeColor() {
		Random rand = new Random();
		int nextColor = rand.nextInt(5) + 1;
		switch (nextColor) {
		case 1:
			this.color = Color.RED;
			break;
		case 2:
			this.color = Color.BLUE;
			break;
		case 3:
			this.color = Color.GREEN;
			break;
		case 4:
			this.color = Color.MAGENTA;
			break;
		default:
			this.color = Color.ORANGE;			
		}
	}
	
	/**
	 * Determines if the current background color is the same 
	 * as the new color generated. 
	 * 
	 * @return true or false
	 */
	private boolean sameColor() {
		return btnColor.getBackground().equals(color);
	}

}
