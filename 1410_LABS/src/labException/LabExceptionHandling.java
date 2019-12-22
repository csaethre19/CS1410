package labException;

import java.util.Scanner;

/**
 * Lab ExceptionHandling demonstrates some of the key concepts of the Java
 * exception handling mechanism.
 * 
 * @author MargretP
 *
 */
public class LabExceptionHandling {
	public static void main(String[] args) {
		try {
			int digit = numberFromUser();
			int result = sevenModulusN(digit);
			System.out.printf("7 %% %d = %d", digit, result);
		} catch (IllegalArgumentException e) {
			System.out.println("An illegal argument has been detected.\n" + e.getMessage());
		}

	}

	private static int numberFromUser() {
		try (Scanner input = new Scanner(System.in)) {

			System.out.print("number: ");
			while (!input.hasNextInt()) {
				input.nextLine(); // remove wrong input
				System.out.print("The number entered needs to be a whole number: ");
			}
			return input.nextInt();
		}

		
	}

	private static int sevenModulusN(int number) {
		if (number == 0)
			throw new IllegalArgumentException("The method sevenModulusN cannot accept " + "zero as an argument.");
		return 7 % number;
	}
}
