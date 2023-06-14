

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Main{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Deque<Integer> dq = new LinkedList<>();

		int testCase = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int tc = 0; tc < testCase; tc++) {
			String key = br.readLine();
			int num = Integer.parseInt(br.readLine());

			String input = br.readLine();

			String[] numbers = input.substring(1, input.length() - 1).split(",");

			for (int i = 0; i < num; i++) {
				dq.add(Integer.parseInt(numbers[i]));
			}

			boolean back = false; // 정방향이 false
			boolean er = false;

			for (int i = 0; i < key.length(); i++) {
				char mission = key.charAt(i);
				if (mission == 'R') {
					back = !back;
				}
				// D인경우 버리기
				else {
					if (dq.size() == 0) {
						sb.append("error\n");
						dq.clear();
						er = true;
						break;
					} else {
						// 뒤에서부터
						if (back) {
							dq.pollLast();
						} else {
							dq.pollFirst();
						}
					}
				}
			}
			// 제대로 끝난경우
			if (!er) {
				sb.append("[");
				// 역방향으로 끝난경우
				while (!dq.isEmpty()) {
					if (back) {
						sb.append(dq.pollLast()).append(",");
					}else {
						sb.append(dq.pollFirst()).append(",");
					}
				}
				if(sb.charAt(sb.length()-1)==',') {
					sb.delete(sb.length()-1, sb.length());
				}
				sb.append("]\n");
				
			}
		}
		sb.delete(sb.length()-1, sb.length());
		System.out.println(sb);
	}
}
