
/**
 * This program creates Customer object that keeps track of a customer's name and
 * ID number.
 * 
 * @author Brandon, Jasmine, Quinn and Alec
 * 
 */

public class Customer {

	private String name = "";
	private int customerID = 0;

	/**
	 * Default constructor.
	 */
	public Customer() {

	}

	/**
	 * Main constructor. Builds a Customer object given a String name and int ID.
	 * 
	 * @param name - String representing the name of customer
	 * @param customerID - int representing customer's ID number
	 */
	public Customer(String name, int customerID) {
		this.name = name;
		if (customerID >= 0) // Ensure ID is nonnegative
			this.customerID = customerID;
	}

	/**
	 * Copy constructor. Builds a new Customer object given another Customer object
	 * to copy.
	 * 
	 * @param customer - The Customer object to be copied
	 */
	public Customer(Customer customer) {
		String s = customer.name; // Create a String copy
		this.name = s;
		this.customerID = customer.customerID;
	}

	/**
	 * Getter method for name of customer.
	 * 
	 * @return - name of customer as a String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter method for name of customer.
	 * 
	 * @param name - Name of customer as a String
	 */
	public void setName(String name) {
		String s = name; // Create a String copy
		this.name = s;
	}

	/**
	 * Getter method for customer ID.
	 * 
	 * @return - Customer ID as an integer
	 */
	public int getID() {
		return customerID;
	}

	/**
	 * Setter method for customer ID.
	 * 
	 * @param customerID - Positive int representing an ID number
	 */
	public void setID(int customerID) {
		if (customerID >= 0)
			this.customerID = customerID;
	}

	/**
	 * toString method that makes a string builder to organize information about the
	 * customer.
	 * 
	 * @return - a String formatted as "Customer Name: <name> ID#: <customerID>"
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Customer Name: ");
		sb.append(this.name);
		sb.append(" ID#: ");
		sb.append(this.customerID);
		String res = sb.toString(); // Construct the String
		return res;
	}
}
