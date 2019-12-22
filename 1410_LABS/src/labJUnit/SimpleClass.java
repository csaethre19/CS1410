package labJUnit;
/**
 * Simple class to demonstrate automated testing with JUnite Jupiter (JUnit 5).
 * @author Charlotte Saethre
 *
 */
public class SimpleClass {
	
	/**
	 * Determines whether a given year is a leap year.
	 * <p>
	 * @param year
	 * @return	true if <code>year</code> is a leap year and false otherwise.
	 * @throws	IllegalArgumentException if <code>year</code> is not positive.
	 */
	public static boolean isLeapYear(int year) {
		if (year <= 0) 
			throw new IllegalArgumentException("Year cannot be a negative number");
		if (year % 100 == 0 && year % 400 != 0) {
			return false;
		}
		return year % 4 == 0;
	}
}
