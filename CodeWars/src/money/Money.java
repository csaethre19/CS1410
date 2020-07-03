package money;

public class Money {

	public static void main(String[] args) {
		double principal = 1000.00;
		double interest = 0.05;
		double tax = 0.18;
		double desired = 1100.00;
		System.out.printf("Time to accrue desired amount (%.2f): %d years\n", desired,
				calculateYears(principal, interest, tax, desired));
	}

	/**
	 * Calculates the number of years to earn a desired amount of interest on a
	 * given principle balance after a percentage of taxes are taken away.
	 * 
	 * @param principal principal amount
	 * @param interest interest rate
	 * @param tax tax rate
	 * @param desired desired amount
	 * @return number of years it takes to accrue desired amount
	 */
	public static int calculateYears(double principal, double interest, double tax, double desired) {
		double principalPlusInterest = 0.0;
		double finalAmount = 0.0;
		int years = 0;
		double onlyInterest = 0.0;
		if (principal == desired) return 0;
		while (finalAmount < desired) {
			years++;
			principalPlusInterest = (principal * Math.pow(1 + (interest / 12), 12 * years));
			onlyInterest = principalPlusInterest - principal;
			finalAmount = principal + (onlyInterest - (onlyInterest * tax));
		}
		return years;
	}
}
