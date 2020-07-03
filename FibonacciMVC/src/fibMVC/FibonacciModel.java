package fibMVC;
/**
 * Calculates the Nth number of the Fibonacci sequence.
 * 
 * @author Charlotte Saethre
 *
 */
public class FibonacciModel {
	
	/**
	 * Calculates nth number of the Fibonacci Sequence
	 * @param n number input by user
	 * @return nth number of sequence
	 */
	public int calculateNthFibonacci(int n) {
		int next = 1;
		int prev = 0;
		int temp = 0;
		for (int i = 1; i < n; i++) {
			temp = next;
			next += prev;
			prev = temp;
		}
		
		return prev;
	}
	
}
