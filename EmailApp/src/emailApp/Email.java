package emailApp;

import java.util.Scanner;

/**
 * Generates email and password for new hire.
 * 
 * @author Charlotte Saethre
 *
 */
public class Email {
	private String firstName;
	private String lastName;
	private String department;
	private int length = 10;
	private String password;
	private int mailboxCap = 500;
	private String email;
	private String companySuffix = "company.com";
	private final Scanner sc = new Scanner(System.in);

	/**
	 * Constructor to receive first name and last name.
	 * 
	 * @param firstName
	 * @param lastName
	 * @param department
	 */
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = departmentPrompt();
		this.password = generatePassword(length);
		System.out.println("Your password: " + this.password);
		this.email = generateEmail();
	}

	private String departmentPrompt() {
		System.out.println("Employee: " + this.firstName + " " + this.lastName
				+ "\nEnter Department Code: \n1. Sales\n2. Development" + "\n3. Accounting\n0. none");
		int result = sc.nextInt();
		switch (result) {
		case 1:
			return "sales";
		case 2:
			return "dev";
		case 3:
			return "acct";
		default:
			return "";
		}

	}

	/*
	 * generates random String for password
	 */
	private String generatePassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@#$%";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int randChar = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(randChar);
		}

		return new String(password);
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param mailboxCap the mailboxCap to set
	 */
	public void setMailboxCap(int mailboxCap) {
		this.mailboxCap = mailboxCap;
	}

	/**
	 * @param altEmail the altEmail to set
	 */
	public void setAltEmail(String altEmail) {
	}

	/**
	 * @return the name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the name
	 */
	public String getLastName() {
		return lastName;
	}

	private String generateEmail() {
		return this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + this.department.toLowerCase()
				+ "." + companySuffix;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the mailboxCap
	 */
	public int getMailboxCap() {
		return mailboxCap;
	}

	public String showInfo() {
		return "DISPLAY NAME: " + this.firstName + " " + this.lastName + "\nEMAIL: " + this.email + "\nEMAIL CAPACITY: "
				+ this.mailboxCap;
	}

}
