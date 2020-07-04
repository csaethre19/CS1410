package calculatorMVC;
/**
 * The model performs all the calculations needed for the view.
 * @author charl
 *
 */
public class CalculatorModel {

	private int calculationValue;
	
	public void addTwoNumbers(int firstNumber, int secondNumber) {
		calculationValue = firstNumber + secondNumber;
	}
	
	public int getCalculationValue() {
		return calculationValue;
	}
}
