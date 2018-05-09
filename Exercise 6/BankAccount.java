
/**
 * This program creates a BankAccount object that keeps track of a balance of
 * type double, an associated Customer object, and performs withdrawals,
 * deposits, and transfers.
 * 
 * @author Brandon, Jasmine, Quinn and Alec
 * 
 */

public class BankAccount {

	private double balance = 0;
	private Customer accountHolder;

	/**
	 * Default constructor.
	 */
	public BankAccount() {

	}

	/**
	 * Main constructor. Builds the BankAccount object with a default dummy customer
	 * object and the given initial deposit.
	 * 
	 * @param initialBalance - Initial deposit amount
	 */
	public BankAccount(double initialBalance) {
		this.deposit(initialBalance); // Checks the deposit is positive
		this.accountHolder = new Customer();
	}

	/**
	 * Main constructor. Builds the BankAccount object with a Customer object and a
	 * deposit.
	 * 
	 * @param customer - Customer object
	 * @param amount - Initial deposit as a double
	 */
	public BankAccount(Customer customer, double amount) {
		this.setCustomer(customer);
		this.deposit(amount); // Checks the deposit is positive
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
	 * @param amount - The new account balance as a double
	 */
	protected void setBalance(double amount) {
		this.balance = amount;
	}

	/**
	 * Getter method for customer object.
	 * 
	 * @return accountHolder - Associated customer object
	 */
	public Customer getCustomer() {
		return accountHolder;
	}

	/**
	 * Setter method for customer object.
	 * 
	 * @param customer - New Customer object
	 */
	public void setCustomer(Customer customer) {
		this.accountHolder = customer;
	}

	/**
	 * Deposit method for current BankAccount object which deposits only positive
	 * amounts of money into the double balance variable
	 * 
	 * @param amount - a double for an amount of money to deposit
	 */
	public void deposit(double amount) {
		if (amount >= 0) {
			balance += amount;
		}
	}

	/**
	 * Withdraw method for bank account object which lets user withdraw only
	 * positive amounts of money. Does not allow the account to reach a negative
	 * balance.
	 * 
	 * @param amount - a double for an amount of money to withdraw
	 */
	public void withdraw(double amount) {
		// Check the amount is positive and will not result in a negative balance
		if (amount > 0 && this.balance - amount >= 0) {
			this.balance -= amount;
		}
	}

	/**
	 * Transfers the specified amount from the current BankAccount object to the
	 * given BankAccount object. Does not allow the transfer if it will result in a
	 * negative balance for the current BankAccount object.
	 * 
	 * @param amount - The amount to be transferred
	 * @param toAccount - the account receiving the transfer
	 */
	public void transfer(double amount, BankAccount toAccount) {
		// Check the transfer will not result in a negative balance
		if (this.getBalance() - amount >= 0) {
			this.withdraw(amount);
			toAccount.deposit(amount);
		}
	}
}
