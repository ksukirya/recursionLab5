import java.util.Stack;

public class recursionLab5 {
    public static void main(String args[]) {
        String test_sum = sum1ToN(5) == 15 ? "pass" : "fail";
        System.out.println(test_sum);
        String test_mul1 = multiplication(3, 4) == 12 ? "pass" : "fail";
        System.out.println(test_mul1);
        String test_mul2 = multiplication(4, 3) == 12 ? "pass" : "fail";
        System.out.println(test_mul2);
        String test_mul3 = multiplication(0, 5) == 0 ? "pass" : "fail";
        System.out.println(test_mul3);
        String test_mul4 = multiplication(5, 0) == 0 ? "pass" : "fail";
        System.out.println(test_mul4);

        Stack<Integer> s = new Stack<Integer>();
        s.push(43);
        s.push(64);
        s.push(29);
        s.push(33);
        boolean a = find(34, s);
        System.out.println(a);
    }

    // Problem 1
    public static int sum1ToN(int n) {
        if (n <= 1) {
            return n;
        }
        return n + sum1ToN(n - 1);
    }

    // Problem 2
    public static int multiplication(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        } else {
            return a + multiplication(a, b - 1);
        }
    }

    // Problem 3
    public static boolean find(int target, Stack<Integer> s) {
        Stack<Integer> tempStack = new Stack<>();
        boolean isFound = false;

        while (!isFound && !s.empty()) {
            if (s.peek() == target) { // checking the next element (without removing it)
                isFound = true;
                break;
            }
            tempStack.push(s.pop()); // removing the next element and storing it on the temporary stack
        }

        while (!tempStack.isEmpty()) {
            s.push(tempStack.pop()); // placing the orignal elements back into the original stack s
        }
        return isFound;
    }
}