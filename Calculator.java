import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Simple Console Calculator
 * ---------------------------------
 * A Java console program that performs basic arithmetic operations:
 * Addition, Subtraction, Multiplication, and Division.
 *
 * Features:
 *  - Takes user input using Scanner
 *  - Displays results clearly
 *  - Handles invalid inputs (e.g., division by zero, non-numeric input)
 *  - Loops until the user chooses to exit
 */
public class Calculator {

    public static void main(String[] args) {
        // Scanner object to read user input from the console
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculating = true;

        System.out.println("========================================");
        System.out.println("      SIMPLE JAVA CONSOLE CALCULATOR");
        System.out.println("========================================");

        // Main loop: keeps the calculator running until user decides to quit
        while (continueCalculating) {
            try {
                // Display the menu of operations
                System.out.println("\nChoose an operation:");
                System.out.println("1. Addition (+)");
                System.out.println("2. Subtraction (-)");
                System.out.println("3. Multiplication (*)");
                System.out.println("4. Division (/)");
                System.out.print("Enter your choice (1-4): ");

                // Read the menu choice; nextInt() can throw InputMismatchException
                // if the user types something that isn't an integer.
                int choice = scanner.nextInt();

                // Validate the menu choice is within the expected range
                if (choice < 1 || choice > 4) {
                    System.out.println("Invalid choice! Please select a number between 1 and 4.");
                    continue; // Skip the rest of the loop and show the menu again
                }

                // Prompt for the two numbers to operate on
                System.out.print("Enter the first number: ");
                double num1 = scanner.nextDouble();

                System.out.print("Enter the second number: ");
                double num2 = scanner.nextDouble();

                double result = 0;
                String operationSymbol = "";

                // Perform the selected operation
                switch (choice) {
                    case 1: // Addition
                        result = num1 + num2;
                        operationSymbol = "+";
                        break;

                    case 2: // Subtraction
                        result = num1 - num2;
                        operationSymbol = "-";
                        break;

                    case 3: // Multiplication
                        result = num1 * num2;
                        operationSymbol = "*";
                        break;

                    case 4: // Division
                        // Explicitly guard against division by zero
                        // instead of letting it silently produce "Infinity".
                        if (num2 == 0) {
                            throw new ArithmeticException("Division by zero is not allowed.");
                        }
                        result = num1 / num2;
                        operationSymbol = "/";
                        break;
                }

                // Display the result clearly, formatted to 2 decimal places
                System.out.printf("Result: %.2f %s %.2f = %.2f%n", num1, operationSymbol, num2, result);

            } catch (InputMismatchException e) {
                // Triggered when the user enters non-numeric input
                // where a number was expected.
                System.out.println("Invalid input! Please enter numeric values only.");
                scanner.next(); // Clear the invalid token from the scanner buffer

            } catch (ArithmeticException e) {
                // Triggered by our manual division-by-zero check above
                System.out.println("Math Error: " + e.getMessage());

            } catch (Exception e) {
                // Catch-all for any other unexpected errors
                System.out.println("Something went wrong: " + e.getMessage());
            }

            // Ask the user if they want to perform another calculation
            System.out.print("\nDo you want to perform another calculation? (yes/no): ");
            String response = scanner.next().trim().toLowerCase();

            if (!response.equals("yes") && !response.equals("y")) {
                continueCalculating = false;
                System.out.println("Thank you for using the calculator. Goodbye!");
            }
        }

        // Always close the scanner to release system resources
        scanner.close();
    }
}
