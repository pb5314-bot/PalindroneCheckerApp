import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

interface PalindromeStrategy {
    boolean checkPalindrome(String word);
}

class StackStrategy implements PalindromeStrategy {

    public boolean checkPalindrome(String word) {

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
}

class DequeStrategy implements PalindromeStrategy {

    public boolean checkPalindrome(String word) {

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : word.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }
}

// Renamed Context Class
class PalindromeStrategyContext {

    private PalindromeStrategy strategy;

    public PalindromeStrategyContext(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String word) {
        return strategy.checkPalindrome(word);
    }
}

public class UseCase12PalindromeCheckerApp {

    public static void main(String[] args) {

        String word = "radar";

        PalindromeStrategy strategy = new StackStrategy();

        PalindromeStrategyContext checker = new PalindromeStrategyContext(strategy);

        boolean result = checker.check(word);

        if (result) {
            System.out.println(word + " is a Palindrome");
        } else {
            System.out.println(word + " is not a Palindrome");
        }
    }
}