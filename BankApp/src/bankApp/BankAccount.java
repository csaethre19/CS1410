package bankApp;
/**
 * Bank account application to manage a <code>CheckingAccount</code> and <code>SavingsAccount</code> objects. 
 * Ability to deposit, withdraw and transfer money to and from bank accounts. 
 * 
 * @author Charlotte Saethre
 *
 */
public abstract class BankAccount implements IBaseRate {
	private String name;
	private String ssn;
	protected double rate;
	private static int suffix = 10000;
	protected String accountNumber;
	private double balance;

	/**
	 * Initializes fields <code>name</code>, <code>ssn</code>, and <code>deposit</code>.
	 * 
	 * @param name Name on account
	 * @param ssn Social Security Number
	 * @param accountType Account Type
	 * @param deposit Initial Deposit
	 */
	public BankAccount(String name, String ssn, double deposit) {
		this.name = name;
		this.ssn = ssn;
		this.balance = deposit;
		this.accountNumber = setAccountNumber();
		suffix++;
		setRate();
	}

	// Method to deposit money into bank account
	public void deposit(double amount) {
		this.balance += amount;
		System.out.printf("Depositing $%.2f into your account.\n", amount);
		showBalance();
	}
	
	// Method to withdraw money from bank account
	public void withdraw(double amount) {
		this.balance -= amount;
		System.out.printf("Withdrawing $%.2f from your account.\n", amount);
		showBalance();
	}
	
	// Method to transfer money to/from bank account
	public void transfer(BankAccount acct, double amount) {
		this.balance -= amount;
		acct.deposit(amount);
	}
	
	// Show balance
	public void showBalance() {
		System.out.println(String.format("Balance: %.2f", this.balance));
	}
	
	
	// Compound interest
	public void compound() {
		double accruedInterest = this.balance * (rate/100);
		this.balance += accruedInterest;
		System.out.println("Accrued Interest: $" + accruedInterest);
	}
	
	// Method to show information about the account
	public String showInfo() {
		return "Name: " + this.name
				+ "\nSSN: " + this.ssn
				+ String.format("\nBalance: $%.2f", this.balance)
				+ "\nAccount Number: " + this.accountNumber
				+ "\nAccount Rate: " + rate + "%";
	}
	
	public abstract void setRate();
	
	// Method to generate Account Number 
	// Account Number: starts with 1 or 2 depending on checking/savings
	// last two digits of SSN
	// unique 5-digit number
	// 3-digit random number
	private String setAccountNumber() {
		String lastTwoOfSocial = this.ssn.substring(ssn.length() - 2);
		int randomNumber = (int)(Math.random() * Math.pow(10, 3));
		return lastTwoOfSocial + BankAccount.suffix + randomNumber;
	}

}
