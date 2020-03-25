package zodiac;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;

/**
 * Displays the zodiac information such as personality blurb, zodiac facts, and
 * image corresponding to zodiac glyph. Information is read from a file that
 * contains different text relating to each of the 12 astrological signs.
 * 
 * @author Charlotte Saethre
 *
 */
@SuppressWarnings("serial")
public class ZodiacDisplay extends JPanel {

	private JLabel lblZodiacImage;
	private JLabel lblZodiacFacts;
	private JPanel buttonPanel;
	private JLabel lblPersonalityDisplay;
	private JButton nextBtn;

	/**
	 * Create the panel.
	 */
	public ZodiacDisplay(ZodiacUser user) {
		this.setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		lblZodiacImage = createZodiacImageLbl(user);
		add(lblZodiacImage);
		JPanel buttonPanel = createButtonPanel(user);
		add(buttonPanel, BorderLayout.SOUTH);
	}

	private JPanel createButtonPanel(ZodiacUser user) {
		buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.WHITE);
		nextBtn = new JButton("Next");
		nextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeDisplay(user);
			}

		});

		buttonPanel.add(nextBtn);
		return buttonPanel;
	}

	private JLabel createZodiacImageLbl(ZodiacUser user) {
		lblZodiacImage = new JLabel();
		lblZodiacImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblZodiacImage.setBackground(Color.WHITE);
		lblZodiacImage.setSize(240, 300);
		lblZodiacImage.setIcon(
				new ImageIcon(ZodiacDisplay.class.getResource("/zodiac/zodiacImages/" + user.getZodiacImage())));

		return lblZodiacImage;
	}

	private void createZodiacFactsDisplay(ZodiacUser user) {
		//user.getName() + " Birthday: " + user.getBirthMonth() + "/" + user.getBirthDay() 
		lblZodiacFacts = new JLabel(readZodiacFactsTxtFile(user.getSign(), "zodiacFacts.txt"));
		lblZodiacFacts.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 36));
		lblZodiacFacts.setBorder(new EmptyBorder(50, 50, 50, 50));
	}

	private void createPersonalityDisplay(ZodiacUser user) {
		lblPersonalityDisplay = new JLabel(readZodiacFactsTxtFile(user.getSign(), "Signs.txt"));
		lblPersonalityDisplay.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 18));
		lblPersonalityDisplay.setBorder(new EmptyBorder(25, 50, 25, 50));
	}

	private String readZodiacFactsTxtFile(Zodiac sign, String source) {
		String zodiacFacts = "";
		String temp = "";
		boolean signMatch = false;
		try (Scanner reader = new Scanner(new File("Resources\\" + source))) {
			while (reader.hasNextLine()) {
				temp = reader.nextLine();
				if (signMatch) {
					zodiacFacts = temp;
					break;
				}
				if (temp.equals(sign.toString())) {
					signMatch = true;
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return zodiacFacts;
	}

	private void changeDisplay(ZodiacUser user) {
		if (lblZodiacImage.isVisible()) {
			lblZodiacImage.setVisible(false);
			createZodiacFactsDisplay(user);
			add(lblZodiacFacts);
			lblZodiacFacts.setVisible(true);
		}
		else {
			lblZodiacFacts.setVisible(false);
			createPersonalityDisplay(user);
			add(lblPersonalityDisplay);
			lblPersonalityDisplay.setVisible(true);
			nextBtn.setVisible(false);
		}
	}
}
