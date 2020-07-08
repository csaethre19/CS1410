package gcdCalculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Interacts with the GCDCalculatorView and the GCDCalculatorModel to update GCD calculation. 
 * @author Charlotte Saethre
 *
 */
public class GCDCalculatorController {
	private GCDCalculatorView view;
	private GCDCalculatorModel model;
	
	public GCDCalculatorController(GCDCalculatorView view, GCDCalculatorModel model) {
		this.view = view;
		this.model = model;
		this.view.addCalculateGcdListener(new CalculateGCDListener());
	}
	
	class CalculateGCDListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int a = Integer.parseInt(view.getFirstNumberInput().getText());
			int b = Integer.parseInt(view.getSecondNumberInput().getText());
			int result = model.calculateGcd(a, b);
			view.setLblGcdResult(Integer.toString(result));
			view.getFirstNumberInput().setText("");
			view.getSecondNumberInput().setText("");
		}
		
	}
}
