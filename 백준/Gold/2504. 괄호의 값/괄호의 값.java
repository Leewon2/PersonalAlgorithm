import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    static String str;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        if (!effectiveness()) {
            System.out.println(0);
            System.exit(0);
        }
        Stack<Character> stack = new Stack<>();
        int res = 0;
        int value = 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.add(str.charAt(i));
                value *= 2;
            } else if (str.charAt(i) == '[') {
                stack.add(str.charAt(i));
                value *= 3;
            } else if (str.charAt(i) == ')') {
                if (str.charAt(i - 1) == '(') {
                    res += value;
                }
                stack.pop();
                value /= 2;
            } else if (str.charAt(i) == ']') {
                if (str.charAt(i - 1) == '[') {

                    res += value;
                }
                stack.pop();
                value /= 3;
            }
        }
        System.out.println(res);

    }


    private static boolean effectiveness() {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (stack.isEmpty()) {
                stack.add(str.charAt(i));
            } else if (str.charAt(i) == '(' || str.charAt(i) == '[') {
                stack.add(str.charAt(i));
            } else if (str.charAt(i) == ')') {
                if (stack.peek() != '(') return false;
                stack.pop();
            } else if (str.charAt(i) == ']') {
                if (stack.peek() != '[') return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

}
