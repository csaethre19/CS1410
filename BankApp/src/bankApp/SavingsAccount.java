package bankApp;
/**
 * Describes a type of bank account that is a savings account type.
 * This type of bank account includes a unique safety deposit box ID number and
 * a safety deposit box key.
 * 
 * @author Charlotte Saethre
 *
 */
public class SavingsAccount extends BankAccount {
	private int safetyDepositBoxID;
	private int safetyDepositBoxKey;
	
	public SavingsAccount(String name, String ssn, double deposit) {
		super(name, ssn, deposit);
		accountNumber = "1" + accountNumber;
		setSafetyDepositBox();
	}

	// Override showInfo method to show relevant information about savings acct
	/* (non-Javadoc)
	 * @see bankApp.BankAccount#showInfo()
	 */
	@Override
	public String showInfo() {
		return "Account Type: Savings\n" + super.showInfo() + "\nSAFETY DEPOSIT BOX ID: " 
				+ this.safetyDepositBoxID + "\nSAFETY DEPOSIT BOX KEY: " + this.safetyDepositBoxKey;
	}

	// Savings account has safety box identified by 3-digit number and accessed via 4-digit PIN
	private void setSafetyDepositBox() {
		this.safetyDepositBoxID = (int)(Math.random() * Math.pow(10, 3));
		this.safetyDepositBoxKey = (int)(Math.random() * Math.pow(10, 4));
	}

	@Override
	public void setRate() {
		rate = getBaseRate() - .25;
	}
	
}
