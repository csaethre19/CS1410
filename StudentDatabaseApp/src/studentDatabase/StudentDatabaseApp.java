package studentDatabase;
import java.util.Scanner;
/**
 * Student Database Application that allows user to enter student data 
 * for a number of students and enroll student(s) in courses.
 * 
 * @author Charlotte Saethre
 *
 */
public class StudentDatabaseApp {

	public static void main(String[] args) {
		studentEntryPrompt();
	}

	private static void studentEntryPrompt() {
		Scanner sc = new Scanner(System.in);
		// Ask user how many students will be added to database
		System.out.println("Number of Students: ");
		int numOfStudents = sc.nextInt();

		Student[] students = new Student[numOfStudents];
		// Create n number of students
		for (int i = 0; i < numOfStudents; i++) {
			students[i] = new Student();
			students[i].makePayment();
			System.out.println();
			System.out.println(students[i].displayStudentStatus());
		}
		
		sc.close();
	}

	
}
