
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {

			Stack<Character> stack = new Stack<>();

			boolean check = false;

			String x = sc.nextLine();

			if (x.equals("."))
				break;

			for (int i = 0; i < x.length(); i++) {
//				System.out.println(x.charAt(i));

				if (x.charAt(i) == '(' || x.charAt(i) == '[') {
					stack.push(x.charAt(i));
				}
				if (x.charAt(i) == ')') {
					if (stack.isEmpty()) {
						check = true;
						break;
					}

					if (stack.peek() != '(') {
						check = true;
						break;
					}
					if (!stack.isEmpty())
						stack.pop();
				}

				if (x.charAt(i) == ']') {
					if (stack.isEmpty()) {
						check = true;
						break;
					}
					if (stack.peek() != '[') {
						check = true;
						break;
					}
					if (!stack.isEmpty())
						stack.pop();
				}
//				System.out.println(1);
			}
			if(!stack.isEmpty()) check=true;
			stack.clear();
			System.out.println(check ? "no" : "yes");
		}

	}

}
