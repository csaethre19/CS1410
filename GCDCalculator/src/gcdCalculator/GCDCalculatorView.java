package gcdCalculator;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
/**
 * Displays user interface that allows user to input two numbers that then calculates the GCD.
 * @author charl
 *
 */
public class GCDCalculatorView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField secondNumberInput;
	private JTextField firstNumberInput;
	private JLabel lblGcdResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GCDCalculatorView frame = new GCDCalculatorView();
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
	public GCDCalculatorView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 250, 210));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblGcdCalculator = createLblGcdCalculator();
		contentPane.add(lblGcdCalculator);
		
		JLabel lblFirstNumber = createLblFirstNumber();
		contentPane.add(lblFirstNumber);
		
		firstNumberInput = createFirstNumberInput();
		contentPane.add(firstNumberInput);
		
		JLabel lblSecondNumber = createLblSecondNumber();
		contentPane.add(lblSecondNumber);
		
		secondNumberInput = createSecondNumberInput();
		contentPane.add(secondNumberInput);
		
		JButton btnCalculate = createBtnCalculate();
		contentPane.add(btnCalculate);
		
		lblGcdResult = createLblGcdResult();
		contentPane.add(lblGcdResult);
	}
	
	private JTextField createSecondNumberInput() {
		JTextField secondNumberInput = new JTextField();
		secondNumberInput.setColumns(10);
		return secondNumberInput;
	}

	private JLabel createLblSecondNumber() {
		JLabel lblSecondNumber = new JLabel("Enter a whole number:");
		lblSecondNumber.setBorder(new EmptyBorder(10, 10, 10, 10));
		lblSecondNumber.setFont(new Font("Verdana", Font.PLAIN, 18));
		return lblSecondNumber;
	}

	private JTextField createFirstNumberInput() {
		JTextField firstNumberInput = new JTextField();
		firstNumberInput.setBorder(null);
		firstNumberInput.setColumns(10);
		return firstNumberInput;
	}

	private JLabel createLblFirstNumber() {
		JLabel lblFirstNumber = new JLabel("Enter a whole number:");
		lblFirstNumber.setBorder(new EmptyBorder(10, 10, 10, 10));
		lblFirstNumber.setFont(new Font("Verdana", Font.PLAIN, 18));
		return lblFirstNumber;
	}

	private JLabel createLblGcdCalculator() {
		JLabel lblGcdCalculator = new JLabel("GCD Calculator");
		lblGcdCalculator.setBorder(new EmptyBorder(16, 100, 16, 100));
		lblGcdCalculator.setHorizontalAlignment(SwingConstants.CENTER);
		lblGcdCalculator.setFont(new Font("Verdana", Font.BOLD, 18));
		return lblGcdCalculator;
	}
	
	private JLabel createLblGcdResult() {
		JLabel lblGcdResult = new JLabel("GCD is ... ");
		lblGcdResult.setBorder(new EmptyBorder(10, 10, 10, 10));
		lblGcdResult.setFont(new Font("Verdana", Font.PLAIN, 18));
		return lblGcdResult;
	}
	
	private JButton createBtnCalculate() {
		JButton btnCalculate = new JButton("Calculate");
		return btnCalculate;
	}

}
