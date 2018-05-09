/**
 * This program creates a SavingsAccount object that keeps track of a double
 * balance, performs withdrawals limited to a specified overdraft amount and
 * performs deposits of double amounts. It also maintains an interest rate,
 * and can deposit monthly earned interest.
 * 
 * @author Brandon, Quinn, Alec, and Jasmine
 */

public class SavingsAccount extends BankAccount {
	
	public double AnnualInterestRate =  0.0;
	
	/**
	 * Default constructor
	 */
	public SavingsAccount() {
		super();
	}
	
	/**
	 * Constructor for Savings Account with Customer and deposit. Calls the
	 * constructor from the superclass.
	 * 
	 * @param c - Customer object for allocation
	 * @param initialBalance - Initial balance of type double
	 */
	public SavingsAccount(Customer c, double initialBalance) {
		super(c, initialBalance);
	}
	
	/**
	 * Constructor for savings account with inputs of type double for both initialBalance 
	 * and initialInterest. Both values must be positive or they will not change the
	 * default values.
	 * 
	 * @param initialBalance deposit of type double
	 * @param initialInterest interest rate of type double
	 */
	public SavingsAccount (double initialBalance, double initialInterest) {
		super(initialBalance);
		this.setAnnualInterestRate(initialInterest); // Checks the interest is positive
	}
	
	/**
	 * Getter method for the AnnualInterestRate of type double
	 * 
	 * @return - current AnnualInterestRate
	 */
	public double getAnnualInterestRate() {
		return this.AnnualInterestRate;	
	}
	
	/**
	 * Setter method for the AnnualInterestRate of type double
	 * 
	 * @param r - input interest rate of type double
	 */
	public void setAnnualInterestRate (double r) {
		if (r > 0) { // checks to make sure the interest is positive
			this.AnnualInterestRate = r;
		}	
	}		
	
	/**
	 * Method for applying the annual interest onto a balance to see how much is 
	 * gained from interest for the month
	 */
	public void depositMonthlyInterest() {
		double monthlyInterestRate = this.getAnnualInterestRate()/12; // Monthly interest rate
		double n = monthlyInterestRate/100; // Get the multiplication factor of interest
		double interest = this.getBalance()*n; // Interest to deposit
		this.deposit(interest);
	}
	
}
