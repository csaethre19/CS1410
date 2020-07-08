package gcdCalculator;
/**
 * Calculates the Greatest Common Denominator of any two given numbers.
 * @author Charlotte Saethre
 *
 */
public class GCDCalculatorModel {

	public int calculateGcd(int a, int b) {
		while (a != b) {
			if (a > b) {
				a -= b;
			}
			else {
				b -= a;
			}
		}
		return a;
	}
}
