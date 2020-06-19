package studentDatabase;
import java.util.Scanner;
/**
 * Describes a student that has a unique <code>studentId</code> and a <code>tuitionBalance</code>
 * for <code>coursesEnrolled</code>. 
 * 
 * @author Charlotte Saethre
 *
 */
public class Student {
	private String firstName;
	private String lastName;
	private int year;
	private String studentId;
	private String coursesEnrolled;
	private int tuitionBalance = 0;
	private final int courseCost = 600;
	private static int idSuffix = 1234;
	private Scanner sc = new Scanner(System.in);
	
	/**
	 * Instantiates a student object by initializing the fields <code>firstName</code>, 
	 * <code>lastName</code>, <code>year</code>, and generating a unique <code>studentId</code>. 
	 */
	public Student () {
		this.firstName = studentFirstNamePrompt();
		this.lastName = studentLastNamePrompt();
		this.year = studentYearPrompt();
		this.studentId = generateStudentId();
		idSuffix++;
		this.coursesEnrolled = enrollStudentPrompt();
	}

	// Prompt for student name
	private String studentFirstNamePrompt() {
		System.out.println("First Name: ");
		return sc.nextLine();
	}
	
	private String studentLastNamePrompt() {
		System.out.println("Last Name: ");
		return sc.nextLine();
	}
	// Prompt for student year
	private int studentYearPrompt() {
		System.out.println("1. Freshman\n2. Sophmore\n3. Junior\n4. Senior\nYear: ");
		return sc.nextInt();
	}
	
	// Generate unique ID that starts with student year
	private String generateStudentId() {
		return Integer.toString(this.year) + Integer.toString(idSuffix);
	}
	
	// Enroll course for student
	private String enrollStudentPrompt() {
		int response = 99;
		int courseCount = 0;
		String courses = "";
		do {
			System.out.println("Enroll Student in Courses:"
					+ "\n1. History 101"
					+ "\n2. Mathametics 101"
					+ "\n3. English 101"
					+ "\n4. Chemistry 101"
					+ "\n5. Computer Science 101"
					+ "\n0. Done");
			response = sc.nextInt();
			if (response != 0) {
				courseCount++; 
				courses += enrollStudentCourses(response) + " ";
			}
		}
		while (response != 0);
		
		adjustStudentBalance(courseCount);
		
		return courses;
	}
	
	private String enrollStudentCourses(int response) {
		if (response == 1) return "HIST";
		else if (response == 2)  return "MATH";
		else if (response == 3) return "ENGL";
		else if (response == 4) return "CHEM";
		else return "CS";
	}
	// Add $600 per course to student balance
	private void adjustStudentBalance(int courseCount) {
		for (int i = 0; i < courseCount; i++) {
			this.tuitionBalance += this.courseCost;
		}
	}
	
	// View Tuition Balance
	public void viewBalance() {
		System.out.println("Your balance is: $" + this.tuitionBalance);
	}
	
	// Pay Tuition Balance
	public void makePayment() {
		int amount = 0;
		this.viewBalance();
		System.out.println("How much would you like to pay?");
		amount = sc.nextInt();
		System.out.println("Thank you for your payment.");
		System.out.println("Your payment of $" + amount + " has been applied.");
		this.tuitionBalance -= amount;
		this.viewBalance();
	}
	
	// Get full name
	public String getStudentName() {
		return this.firstName + " " + this.lastName;
	}
	
	// Show status
	public String displayStudentStatus() {
		return "Name: " + this.getStudentName()
				+ "\nID: " + this.studentId
				+ "\nCourses: " + this.coursesEnrolled
				+ "\nBalance: " + this.tuitionBalance;
	}
	
}
