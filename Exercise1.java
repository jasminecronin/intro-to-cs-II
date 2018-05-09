import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Plays a number guessing game with the user. The program generates a random
 * integer between a specified range, endpoints inclusive (here it is between 1
 * and 20). It then prompts the user for guesses, and will indicate whether the
 * guess was too high or too low. Prompting ends when the user guesses the
 * correct number.
 * 
 * @author Jasmine Roebuck, Alec Lunn, Quinn Masters, Brandon Arenas
 * CPSC 233 - Catalin Dohotaru; Jan 24, 2018
 */
public class Exercise1 {

	public static void main(String[] args) {
		int min = 1; // Lower bound of the range
		int max = 20; // Upper bound of the range
		int num = pickNumber(min, max); // Generate random number in the range
		int guess = min - 1; // Initial guess outside the range so loop runs at least once

		System.out.println("I'm thinking of a number between " + min + " and " + max + ".");
		System.out.println("For testing, I've picked " + num + ".");
		Scanner in = new Scanner(System.in);
		while (guess != num) { // Stop when we guess the number
			System.out.println("What is your guess? ");
			guess = getInput(in, min, max); // Get the user's guess
			if (guess < num) {
				System.out.println("Too low.");
			} else if (guess > num) {
				System.out.println("Too high.");
			}
		}
		System.out.println("That's the number I was thinking of! Well done.");
	} // end main()

	/**
	 * Generates a random integer between the given min and max, endpoints
	 * inclusive.
	 * 
	 * @param min - the lower bound of the range
	 * @param max - the upper bound of the range
	 * @return - the randomly generated integer
	 */
	public static int pickNumber(int min, int max) {
		Random r = new Random();
		int num = r.nextInt((max - min) + 1) + min; 
		return num;
	} // end pickNumber()

	/**
	 * Uses the passed Scanner object to continually prompt the user for input. The
	 * input must be a number in the range min-max, inclusive. An error message is
	 * printed if the user enters a noninteger, or if they enter an integer outside
	 * the range. Once a valid input has been entered, it is returned.
	 * 
	 * @param in - the Scanner object that takes the input
	 * @param min - the minimum number in the range
	 * @param max - the maximum number in the range
	 * @return - the user's valid guess
	 */
	public static int getInput(Scanner in, int min, int max) {
		int num = min - 1; // Initial guess outside the range so loop runs at least once
		while (num < min || num > max) { // Prompt until user enters a number in the range
			try {
				num = in.nextInt();
			} catch (InputMismatchException e) { // Thrown when user enters a non-integer
				System.out.println("Invalid input.");
				in.next(); // Clears the memory, prevents an infinite loop
			}
			if (num < min || num > max) { // If we have an integer outside the range
				System.out.println("Please enter a number between " + min + " and " + max + ".");
			}
		}
		return num;
	} // end getInput()

} // end class Exercise1
