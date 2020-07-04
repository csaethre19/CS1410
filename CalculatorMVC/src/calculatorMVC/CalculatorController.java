package calculatorMVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Coordinates interactions between the View and the Model
 * @author charl
 *
 */
public class CalculatorController {
	private  CalculatorView view;
	private CalculatorModel model;
	
	public CalculatorController(CalculatorView view, CalculatorModel model) {
		this.view = view;
		this.model = model;
		
		// Tell the View that whenever the calculate button
		// is clicked to execute the actionPerformed method
		// in the CalculateListener inner class
		
		this.view.addCalculateListener(new CalculateListener());
	}
	
	class CalculateListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int firstNumber, secondNumber =  0;
			
			// We surround interactions with the view
			// with a try block in case numbers were not 
			// properly entered
			try {
				firstNumber = view.getFirstNumber();
				secondNumber = view.getSecondNumber();
				
				model.addTwoNumbers(firstNumber, secondNumber);
				view.setCalcSolution(model.getCalculationValue());
			}
			catch (NumberFormatException ex) {
				view.displayErrorMessage("You Need to Enter 2 Integers");
			}
			
		}
		
	}
}
