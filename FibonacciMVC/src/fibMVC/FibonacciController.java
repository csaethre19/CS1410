package fibMVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Interacts with the view and the model.
 * Get's user input for number N and passes it to model so calculation can be done.
 * Passes the result back to the view to be displayed to the user.
 * 
 * @author Charlotte Saethre
 *
 */
public class FibonacciController {
	private FibonacciView view;
	private FibonacciModel model;
	
	/**
	 * Initializes the FibonacciView and FibonaccieModel classes <code>view</code> and <code>model</code>
	 * and adds CalculateListener to <code>view</code>.
	 * @param view
	 * @param model
	 */
	public FibonacciController(FibonacciView view, FibonacciModel model) {
		this.view = view;
		this.model = model;
		this.view.addCalculateListener(new CalculateListener());
	}
	
	class CalculateListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				int n = view.getNthNumber();
				int nthFib = model.calculateNthFibonacci(n);
				view.setNthNumberLbl(n, nthFib);
				view.setTextField();
			}
			catch (NumberFormatException ex) {
				view.displayErrorMessage("You must enter an integer");
			}
		}
		
	}
	
}
