import java.util.Stack;

public class UseCase13PalindromeCheckerApp {

    // Method 1: Two Pointer Approach
    public static boolean twoPointerPalindrome(String word) {
        int start = 0;
        int end = word.length() - 1;

        while (start < end) {
            if (word.charAt(start) != word.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Method 2: Stack Approach
    public static boolean stackPalindrome(String word) {

        Stack<Character> stack = new Stack<>();

        for (char c : word.toCharArray()) {
            stack.push(c);
        }

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String word = "racecar";

        // Two Pointer Timing
        long startTime1 = System.nanoTime();
        boolean result1 = twoPointerPalindrome(word);
        long endTime1 = System.nanoTime();

        // Stack Timing
        long startTime2 = System.nanoTime();
        boolean result2 = stackPalindrome(word);
        long endTime2 = System.nanoTime();

        // Results
        System.out.println("Two Pointer Result: " + result1);
        System.out.println("Two Pointer Time: " + (endTime1 - startTime1) + " ns");

        System.out.println("Stack Result: " + result2);
        System.out.println("Stack Time: " + (endTime2 - startTime2) + " ns");
    }
}
