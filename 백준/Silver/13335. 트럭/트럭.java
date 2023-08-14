import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 트럭의 수를 입력받자.
		int truckCnt = sc.nextInt();

		// 다리의 길이를 입력 받자.
		int bridgeLen = sc.nextInt();

		// 다리의 최대하중을 입력 받자.
		int bridgeWeight = sc.nextInt();

		// 트럭무게를 입력 받고 큐에 저장하자.
		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();

		// 트럭 무게 정보를 입력 받자.
		for (int i = 0; i < truckCnt; i++) {
			q1.offer(sc.nextInt());
		}

		int sum = 1;
		q2.offer(q1.peek());
		int poll = q1.poll();
		int len = bridgeLen;
		while (!q1.isEmpty()) {
			// q1 가장 앞 값을 빼서 poll에 저장한다.
			len--;
			if (len == 0) {
				poll -= q2.poll();
				len=1;
			}
			// q1이 비어있지 않고, poll 값과 q1을 더한 값이 bridgeWeight보다 작거나 같다면
			if (!q1.isEmpty() && poll + q1.peek() <= bridgeWeight) {
				q2.offer(q1.peek());
				poll += q1.poll();
			}
			// q1이 비었거나, poll값과 q1을 더한 값이 bridgeWeight보다 크다면
			// bidgeLen만큼 더하자.
			else {
				q2.offer(0);

			}
			sum++;
		}
		System.out.println(sum+bridgeLen);
	}
}