package fibMVC;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;

/**
 * Displays user interface that calculates the nth number of the Fibonacci sequence. 
 * 
 * @author Charlotte Saethre
 *
 */
public class FibonacciView extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JLabel nthNumberLbl;
	private JLabel inputLbl;
	private JButton btnCalculate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FibonacciModel model = new FibonacciModel();
					FibonacciView view = new FibonacciView();
					@SuppressWarnings("unused")
					FibonacciController controller = new FibonacciController(view, model);
					view.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FibonacciView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblFibonacci = createLblNthFibonacci();
		contentPane.add(lblFibonacci);

		inputLbl = createLblInput();
		contentPane.add(inputLbl);

		createTextField();
		contentPane.add(textField);
		textField.setColumns(10);

		createBtnCalculate();
		contentPane.add(btnCalculate);

		nthNumberLbl = createLblNthNumber();
		contentPane.add(nthNumberLbl);

	}
	
	/**
	 * 
	 * @return
	 */
	public int getNthNumber() {
		return Integer.parseInt(textField.getText());
	}
	
	public void setTextField() {
		textField.setText("");
	}
	
	/**
	 * 
	 * @param n
	 */
	public void setNthNumberLbl(int n, int nthFib) {
		nthNumberLbl.setText("Nth Number: " + n + " of the Fibonacci Sequence is ... " + Integer.toString(nthFib));
	}
	
	private void createBtnCalculate() {
		btnCalculate = new JButton("Calculate");
		btnCalculate.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 12));
	}
	
	public void addCalculateListener(ActionListener listenForCalcButton) {
		btnCalculate.addActionListener(listenForCalcButton);
	}
	
	public void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}

	private JLabel createLblNthNumber() {
		nthNumberLbl = new JLabel("The Nth number of the Fibonacci Sequence is ... ");
		nthNumberLbl.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		return nthNumberLbl;
	}

	private void createTextField() {
		textField = new JTextField();
	}

	private JLabel createLblInput() {
		inputLbl = new JLabel("Enter a Whole Number: ");
		inputLbl.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		inputLbl.setBorder(new EmptyBorder(40,10,40,10));
		return inputLbl;
	}

	private JLabel createLblNthFibonacci() {
		JLabel lblFibonacci = new JLabel("Nth Number of the Fibonacci Sequence");
		lblFibonacci.setBackground(new Color(255, 255, 255));
		lblFibonacci.setForeground(new Color(218, 165, 32));
		lblFibonacci.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblFibonacci.setHorizontalAlignment(SwingConstants.CENTER);
	    lblFibonacci.setBorder(new EmptyBorder(20,10,20,10));
		return lblFibonacci;
	}

}
