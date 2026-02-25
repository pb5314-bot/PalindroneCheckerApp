import java.util.Scanner;

/**
 * PalindromeCheckerApp
 * Version: 1.0
 * Console-based Java Application
 */

public class PalindromeCheckerApp {

    // Application Version Constant
    static final String APP_VERSION = "1.0";

    // Entry Point
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice;

        // UC1 - Welcome Message
        displayWelcomeMessage();

        // Menu Loop
        do {
            displayMenu();
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
            }

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {

                case 1:
                    checkSimplePalindrome(scanner);
                    break;

                case 2:
                    checkIgnoreCasePalindrome(scanner);
                    break;

                case 3:
                    checkIgnoreSpecialCharacters(scanner);
                    break;

                case 4:
                    System.out.println("Thank you for using Palindrome Checker App!");
                    break;

                default:
                    System.out.println("Invalid choice! Please select 1-4.");
            }

        } while (choice != 4);

        scanner.close();
    }

    // Welcome Message
    public static void displayWelcomeMessage() {
        System.out.println("=======================================");
        System.out.println("      Welcome to Palindrome Checker    ");
        System.out.println("=======================================");
        System.out.println("Application Name : Palindrome Checker App");
        System.out.println("Application Version : " + APP_VERSION);
        System.out.println("Technology Used : Java (Console Based)");
        System.out.println("=======================================");
    }

    // Menu
    public static void displayMenu() {
        System.out.println("\n========== MENU ==========");
        System.out.println("1. Check Simple Palindrome");
        System.out.println("2. Check Palindrome (Ignore Case)");
        System.out.println("3. Check Palindrome (Ignore Spaces & Special Characters)");
        System.out.println("4. Exit");
        System.out.println("==========================");
    }

    // Simple Palindrome
    public static void checkSimplePalindrome(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("Result: It is a Palindrome.");
        } else {
            System.out.println("Result: Not a Palindrome.");
        }
    }

    // Ignore Case
    public static void checkIgnoreCasePalindrome(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine().toLowerCase();

        if (isPalindrome(input)) {
            System.out.println("Result: It is a Palindrome (Ignoring Case).");
        } else {
            System.out.println("Result: Not a Palindrome.");
        }
    }
g
    // Ignore Spaces & Special Characters
    public static void checkIgnoreSpecialCharacters(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        input = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if (isPalindrome(input)) {
            System.out.println("Result: It is a Palindrome (Ignoring Spaces & Special Characters).");
        } else {
            System.out.println("Result: Not a Palindrome.");
        }
    }

    // Core Logic - Two Pointer Technique
    public static boolean isPalindrome(String str) {

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
