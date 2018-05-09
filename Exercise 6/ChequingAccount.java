/**
 * Creates a ChequingAccount object inheriting from BankAccount. Holds an
 * overdraftAmount to determine valid withdrawals and transfers, and charges an
 * overdraftFee in the event of a balance overdraft.
 * 
 * @author Brandon, Jasmine, Quinn and Alec
 *
 */
public class ChequingAccount extends BankAccount {

	private double overdraftAmount = 100.0;
	private double overdraftFee;

	/**
	 * Builds a ChequingAccount with the given transactionFee.
	 * 
	 * @param transactionFee - fee to be charged in an overdraft
	 */
	public ChequingAccount(double transactionFee) {
		super(); // To initialize the balance and customer
		this.setTransactionFee(transactionFee);
	}

	/**
	 * Builds a ChequingAccount with a Customer, initial balance, and transaction
	 * fee.
	 * 
	 * @param accountHolder - Customer object
	 * @param startBalance - initial balance
	 * @param transactionFee - fee to be charged in an overdraft
	 */
	public ChequingAccount(Customer accountHolder, double startBalance, double transactionFee) {
		super(accountHolder, startBalance);
		this.setTransactionFee(transactionFee);
	}

	/**
	 * Getter method for overdraftFee.
	 * 
	 * @return overdraftFee - the current fee for overdrafting the account
	 */
	public double getTransactionFee() {
		return this.overdraftFee;
	}

	/**
	 * Setter method for overdraftFee.
	 * 
	 * @param fee - the new fee for overdrafting the account
	 */
	public void setTransactionFee(double fee) {
		if (fee > 0) {
			this.overdraftFee = fee;
		}
	}

	/**
	 * Getter method for overdraftAmount.
	 * 
	 * @return overdraftAmount - the current allowed overdraft amount
	 */
	public double getOverdraftAmount() {
		return this.overdraftAmount;
	}

	/**
	 * Setter method for overdraftAmount
	 * 
	 * @param amount - the new allowed overdraft amount
	 */
	public void setOverdraftAmount(double amount) {
		if (amount > 0) {
			this.overdraftAmount = amount;
		}
	}

	/**
	 * Withdraw method that overrides the method from the BankAccount class.
	 * Prevents withdrawing more than the allowed overdraft amount. If withdrawal
	 * results in an overdraft, charges the overdraft fee.
	 * 
	 * @param amount - The amount to be withdrawn
	 */
	@Override
	public void withdraw(double amount) {
		if (this.getBalance() - amount >= -this.overdraftAmount) {
			if (this.getBalance() - amount < 0) { // Check for overdraft
				this.setBalance(this.getBalance() - this.overdraftFee); // Charge fee
			}
			this.setBalance(this.getBalance() - amount);
		}
	}

	/**
	 * Transfer method that overrides the method from the BankAccount class.
	 * Prevents transferring more than the allowed overdraft amount.
	 * 
	 * @param amount - The amount to be transferred
	 * @param toAccount - The account to receive the transfer
	 */
	@Override
	public void transfer(double amount, BankAccount toAccount) {
		if (this.getBalance() - amount >= -this.getOverdraftAmount()) {
			this.withdraw(amount); // Will check for overdraft and charge fee if applicable
			toAccount.deposit(amount);
		}
	}
}
