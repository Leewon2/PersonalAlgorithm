

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static Map<Character, Integer> hash = new HashMap<>();

	public static void main(String[] args) {

		Stack<Character> stack = new Stack<>();
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		StringBuilder sb = new StringBuilder();
		makePr();

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
				sb.append(str.charAt(i));
			}

			// 닫는 괄호가 나온 경우는
			// 여는 괄호가 나올 때 가지 스택에서 푸쉬하자.
			else if (str.charAt(i) == ')') {

				while (true) {
					// 스택에서 하나 빼자.
					char poll = stack.pop();
					// 여는 괄호가 나오면 break
					if (poll == '(')
						break;
					// 기호가 나온다면 sb에 연결
					else
						sb.append(poll);
				}
			}
			// 기호인 경우
			else {
				// 자신보다 우선순위가 높은 녀석이 안에 있다면??
				// 꺼내줘야겠다.
				// 조건
				// 1. 스택이 비어있으면 안되겠다.
				// 2. 여는 괄호면 안되겠다.
//				System.out.println(hash.get(str.charAt(i)));

				// 자신보다 우선순위가 높은 녀석들이 있는지 확인해보자.
				// while문을 사용해 자신보다 높은 우선순위 녀석은 다 꺼낸다.
				while (!stack.isEmpty() && hash.get(str.charAt(i)) != 0
						&& hash.get(stack.peek()) >= hash.get(str.charAt(i))) {
					sb.append(stack.pop());
				}

				// 위의 조건에 만족하지 않거나,
				// while문이 끝났으면 비교한 녀석은 넣어줘야겠다.
				stack.push(str.charAt(i));
			}
		}
		// 연산이 종료되고, stack에 있는 모든 값을 빼내자.
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb);

	}

	private static void makePr() {
		hash.put('(', 0);
		hash.put(')', 0);
		hash.put('+', 1);
		hash.put('-', 1);
		hash.put('*', 2);
		hash.put('/', 2);
	}
}
