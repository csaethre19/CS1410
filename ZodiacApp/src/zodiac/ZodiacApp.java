package zodiac;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

/**
 * Allows user to input information to create a <code>ZodiacUser</code> object
 * that will calculate the user's astrological sign and display information
 * based on sign.
 * 
 * @author Charlotte Saethre
 *
 */
@SuppressWarnings("serial")
public class ZodiacApp extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField nameTxtField;
	private JLabel lblEnterName;
	private JLabel lblEnterBirthMonth;
	private JLabel lblEnterBirthDay;
	private ZodiacDisplay zodiacPanel;
	private JPanel buttonPane;
	private ZodiacUser zodiacUser;
	@SuppressWarnings("rawtypes")
	private JComboBox birthMonthDropdown;
	@SuppressWarnings("rawtypes")
	private JComboBox birthDayDropdown;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ZodiacApp dialog = new ZodiacApp();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ZodiacApp() {
		setBounds(100, 100, 650, 450);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(51, 0, 153));
		contentPanel.setBorder(new EmptyBorder(50, 100, 150, 100));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblEnterName = createNameInputLbl();
		contentPanel.add(lblEnterName);

		createUserNameTxtField();
		contentPanel.add(nameTxtField);

		JLabel lblEnterBirthMonth = createBirthMonthInputLbl();
		contentPanel.add(lblEnterBirthMonth);

		createBirthMonthDropdownMenu();
		contentPanel.add(birthMonthDropdown);

		JLabel lblEnterBirthDay = createBirthDayInputLbl();
		contentPanel.add(lblEnterBirthDay);

		createBirthDayDropdownMenu();
		contentPanel.add(birthDayDropdown);

		JPanel buttonPane = createButtonPane();
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = createEnterBtn();
		buttonPane.add(okButton);

	}

	private void createUserNameTxtField() {
		nameTxtField = new JTextField();
		nameTxtField.setColumns(10);
	}

	@SuppressWarnings("unchecked")
	private void createBirthMonthDropdownMenu() {
		String[] birthMonth = { "January", "February", "March", "April", "June", "July", "August", "September",
				"October", "November", "December" };
		birthMonthDropdown = new JComboBox(birthMonth);
	}

	private void createBirthDayDropdownMenu() {
		String[] birthDay;
		birthDay = new String[32];
		for (int i = 0; i < birthDay.length - 1; i++) {
			birthDay[i] = String.format("%d", i + 1);
		}
		birthDayDropdown = new JComboBox(birthDay);
	}

	private JLabel createBirthDayInputLbl() {
		lblEnterBirthDay = new JLabel("Enter Birth Day: ");
		lblEnterBirthDay.setFont(new Font("Courier New", Font.BOLD, 18));
		lblEnterBirthDay.setForeground(new Color(255, 255, 255));
		lblEnterBirthDay.setHorizontalAlignment(SwingConstants.LEFT);
		return lblEnterBirthDay;
	}

	private JButton createEnterBtn() {
		JButton enterButton = new JButton("Enter");
		enterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int day = Integer.parseInt((String) birthDayDropdown.getSelectedItem());
				zodiacUser = new ZodiacUser(nameTxtField.getText(), birthMonthDropdown.getSelectedItem().toString(), 
						day);
				zodiacPanel = new ZodiacDisplay(zodiacUser);
				add(zodiacPanel);
				contentPanel.setVisible(false);
				buttonPane.setVisible(false);
				zodiacPanel.setVisible(true);
			}
		});
		enterButton.setActionCommand("Enter");

		getRootPane().setDefaultButton(enterButton);
		return enterButton;
	}

	private JPanel createButtonPane() {
		buttonPane = new JPanel();
		buttonPane.setBackground(Color.WHITE);
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		return buttonPane;
	}

	private JLabel createBirthMonthInputLbl() {
		lblEnterBirthMonth = new JLabel("Enter Birth Month: ");
		lblEnterBirthMonth.setForeground(new Color(255, 255, 255));
		lblEnterBirthMonth.setFont(new Font("Courier New", Font.BOLD, 18));
		lblEnterBirthMonth.setHorizontalAlignment(SwingConstants.LEFT);
		return lblEnterBirthMonth;
	}

	private JLabel createNameInputLbl() {
		lblEnterName = new JLabel("Enter Name: ");
		lblEnterName.setForeground(new Color(255, 255, 255));
		lblEnterName.setFont(new Font("Courier New", Font.BOLD, 18));
		lblEnterName.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnterName.setBorder(new EmptyBorder(0, 0, 0, 0));
		return lblEnterName;
	}

}
