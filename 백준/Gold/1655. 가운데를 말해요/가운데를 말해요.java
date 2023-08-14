

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

	static int left;
	static int right;
	static int mid;

	// 오른쪽은 오름차순으로 정렬 => 큰 값들을 넣을거다.
	// 왼쪽은 내림차순으로 정렬 => 작은 값들을 넣을거다.
	static PriorityQueue<Integer> pqRight = new PriorityQueue<>();
	static PriorityQueue<Integer> pqLeft = new PriorityQueue<>(Collections.reverseOrder());

	public static void main(String[] args) throws NumberFormatException, IOException {

//		left=0;
//		right=0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		// 첫번째 값을 mid로 설정 후 시작해보자.
		int a = Integer.parseInt(br.readLine());
		// 첫번째 값 왼쪽에 넣기
		sb.append(a).append("\n");
		// 두번째 값 입력 받기
		int b = Integer.parseInt(br.readLine());
		// a가 b보다 작으면 b는 오른쪽에 넣자.
		if (a < b) {
			pqLeft.offer(a);
			pqRight.offer(b);
		}
		// 반대는 반대로
		else {
			pqLeft.offer(b);
			pqRight.offer(a);
		}

		// 두개 중 작은 수를 sb에 연결
		// 작은 수는 left에 있겠다.
		sb.append(pqLeft.peek()).append("\n");

		for (int i = 2; i < N; i++) {
			int x = Integer.parseInt(br.readLine());

			// 첫번째 값은 작은쪽에 넣어야 하므로,,,
			// 큰 값들의 q가 비어있지 않고, 큰 값들 중 가장 작은 값이
			// 이번에 입력받은 x보다 크다면???
			// 작은값들의 q에 넣어야겠다.
			// 아니라면? 큰값들의 q에 넣으면 되겠다.
			if (pqRight.peek() >= x) {
				// 왼쪽에 넣자.
				pqLeft.offer(x);
			} else {
				pqRight.offer(x);
			}
//			System.out.println("왼쪽 가장 앞 : " + pqLeft.peek());
//			System.out.println("오른쪽 가장 앞 : " + pqRight.peek());

			// 큰 값들의 큐와 작은 값들의 큐 사이즈를 비교해서 2가 될때를 알아보자.
			if (Math.abs(pqLeft.size() - pqRight.size()) == 2) {
				// left의 size가 크다면???
				// 왼쪽에 값이 3개 오른쪽에 1개 있다면???
				// 왼쪽 값 1개를 오른쪽으로 옮겨줘야한다.

				// 왼쪽 값은 내림차순으로 정렬했으니,,,
				// 가장 앞에 있는 값이 가장 큰 값일테니 그냥 옮기면 될듯
				if (pqLeft.size() > pqRight.size()) {
					pqRight.offer(pqLeft.poll());
				}
				// 반대의 경우는 반대로 수행하면 될듯
				else {
					pqLeft.offer(pqRight.poll());
				}
			}

			// 이제 출력해보자.
			// left와 right 크기의 차이가 무조건 1 이하다.
			// 짝수와 left size가 더 큰 경우는 left에서 연결
			// right size가 더 큰 경우는 right에서 연결
			// left에 있는 녀석 출력하면 될듯?
			if(pqRight.size()>pqLeft.size()) {
				sb.append(pqRight.peek()).append("\n");
			}else {
				sb.append(pqLeft.peek()).append("\n");
			}

		}
		System.out.println(sb);
	}

}
