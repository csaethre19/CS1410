package bankApp;
import java.util.ArrayList;
import java.util.List;

/**
 * Application that handles new customer bank account requests.
 * 
 * @author charl
 *
 */
public class BankApp {
	private static List<BankAccount> accounts;

	public static void main(String[] args) {
		createNewAccounts();
		for (BankAccount acct: accounts) {
			System.out.println("--------------------");
			System.out.println(acct.showInfo());
			System.out.println();
		}
	}

	private static void createNewAccounts() {
		// Read a CSV file to create new account based on data
		List<String[]> newMembers = utilities.CSV.read("bank-info.csv");
		accounts = new ArrayList<>();
		for (String[] member : newMembers) {
			String name = member[0];
			String ssn = member[1];
			double deposit = Double.parseDouble(member[3]);
			if (member[2].equals("Savings")) {
				accounts.add(new SavingsAccount(name, ssn, deposit));
			}
			else if (member[2].equals("Checking")){
				accounts.add(new CheckingAccount(name, ssn, deposit));
			}	
			else {
				System.out.println("ERROR READING ACCOUNT TYPE");
			}
		}
	}

}
