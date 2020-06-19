package bankApp;
/**
 * Describes a a type of bank account that is a checking account type. 
 * This type of bank account includes a unique 12-digit debit card number and 4 digit pin.
 * 
 * @author Charlotte Saethre
 *
 */
public class CheckingAccount extends BankAccount {
	private int debitCardNumber;
	private int debitCardPIN;

	public CheckingAccount(String name, String ssn, double deposit) {
		super(name, ssn, deposit);
		accountNumber = "2" + accountNumber;
		setUpDebitCard();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see bankApp.BankAccount#showInfo()
	 */
	@Override
	public String showInfo() {
		return "Account Type: Checking\n" + super.showInfo() + "\nDEBIT CARD NUMBER: " + this.debitCardNumber
				+ "\nDEBIT CARD PIN: " + this.debitCardPIN;
	}

	// Generates 12-digit number and 4-digit PIN for checking account debit card

	// Override showInfo method to show relevant information about checking acct
	private void setUpDebitCard() {
		this.debitCardNumber = (int)(Math.random() * Math.pow(10, 12));
		this.debitCardPIN = (int) (Math.random() * Math.pow(10, 4));

	}

	@Override
	public void setRate() {
		rate = .15 * getBaseRate();
	}
}
