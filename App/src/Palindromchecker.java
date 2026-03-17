import java.util.*;

public class Palindromchecker {

    // Method 1: Simple Two Pointer
    public static boolean simpleCheck(String str) {
        int start = 0, end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    // Method 2: Stack
    public static boolean stackCheck(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) stack.push(ch);

        for (char ch : str.toCharArray()) {
            if (ch != stack.pop()) return false;
        }
        return true;
    }

    // Method 3: Deque
    public static boolean dequeCheck(String str) {
        Deque<Character> deque = new LinkedList<>();
        for (char ch : str.toCharArray()) deque.addLast(ch);

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Simple Check
        long start1 = System.nanoTime();
        boolean res1 = simpleCheck(input);
        long end1 = System.nanoTime();

        // Stack Check
        long start2 = System.nanoTime();
        boolean res2 = stackCheck(input);
        long end2 = System.nanoTime();

        // Deque Check
        long start3 = System.nanoTime();
        boolean res3 = dequeCheck(input);
        long end3 = System.nanoTime();

        // Results
        System.out.println("\n--- Results ---");
        System.out.println("Simple Method: " + res1 + " | Time: " + (end1 - start1) + " ns");
        System.out.println("Stack Method: " + res2 + " | Time: " + (end2 - start2) + " ns");
        System.out.println("Deque Method: " + res3 + " | Time: " + (end3 - start3) + " ns");

        sc.close();
    }
}