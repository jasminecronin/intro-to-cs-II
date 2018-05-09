
/**
 * This program creates a BankAccount object that keeps track of a double
 * balance, performs withdrawals limited to a specified overdraft amount and
 * performs deposits of double amounts.
 * 
 * @author Brandon, Jasmine, Quinn and Alec
 * 
 */

public class BankAccount {

	private double balance = 0;
	private double overdraftAmount = 100.0;
	private Customer customer;

	/**
	 * Default constructor.
	 */
	public BankAccount() {

	}
	
	/**
	 * Main constructor. Builds the BankAccount object with a default dummy customer
	 * object and the given initial deposit.
	 * 
	 * @param dep - Initial deposit amount
	 */
	public BankAccount(double initialBalance) {
		this.deposit(initialBalance); // Checks the deposit is positive
		this.customer = new Customer();
	}

	/**
	 * Main constructor. Builds the BankAccount object with a Customer object and a
	 * deposit.
	 * 
	 * @param customer - Customer object
	 * @param dep - Initial deposit as a double
	 */
	public BankAccount(Customer customer, double dep) {
		this.setCustomer(customer);
		this.deposit(dep); // Checks for invalid deposits
	}

	/**
	 * Getter method for balance of type double.
	 * 
	 * @return - Current balance in the BankAccount object
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Sets the balance to a specified amount.
	 * 
	 * @param bal - The new account balance as a positive double
	 */
	public void setBalance(double bal) {
		if (bal > 0) {
			this.balance = bal;
		}
	}

	/**
	 * Setter method for double overdraft amount for current bank account object
	 * 
	 * @param amt - A double for a new overdraft amount. Only changes value of
	 *            overdraftAmount if entry is positive
	 */
	public void setOverdraftAmount(double amt) {
		if (amt >= 0) {
			this.overdraftAmount = amt;
		}
	}

	/**
	 * Getter method for customer object.
	 * 
	 * @return customer - Associated customer object
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Setter method for customer object.
	 * 
	 * @param customer - Customer object
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * Deposit method for current BankAccount object which deposits only positive
	 * amounts of money into the double balance variable
	 * 
	 * @param dep - a double for an amount of money to deposit
	 */
	public void deposit(double dep) {
		if (dep > 0) {
			balance += dep;
		}
	}

	/**
	 * Withdraw method for bank account object which lets user withdraw only
	 * positive amounts of money which are smaller than or equal to their total
	 * balance + their overdraft
	 * 
	 * @param wit - a double for an amount of money to withdraw
	 */
	public void withdraw(double wit) {
		// Check if withdrawal will exceed overdraft
		if (balance - wit < -overdraftAmount) {
			System.out.println("Insufficient Funds.");
		} else if (wit > 0) { // Ensure withdrawal is positive
			balance -= wit;
		}
	}
}
