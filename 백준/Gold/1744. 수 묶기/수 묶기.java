

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int min = Integer.MAX_VALUE;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder());
		for (int i = 0; i < N; i++) {
			pq.add(sc.nextInt());
		}

		int[] arr = new int[pq.size()];
		int idx = 0;
		boolean check = false;
		// pq가 홀수인 경우
		if ((pq.size() & 1) == 1) {
			while (pq.size() != 0) {
//				System.out.println("pqsizehaha : " + pq.size());
				if (pq.size() >= 2) {
					int x = pq.poll();
					int y = pq.poll();

//					System.out.println("x : " + x + " y : " + y);
					if (x > 1 && y > 1) {
						arr[idx++] = x * y;
					} else if (x > 0 && y > 0) {
						arr[idx++] = x;
						arr[idx++] = y;
					} else if (x > 0 && y <= 0) {
						arr[idx++] = x;
						pq.offer(y);
						pq2 = new PriorityQueue<>();
						while (!pq.isEmpty()) {
							pq2.offer(pq.poll());
						}
						pq = new PriorityQueue<>();
						while (!pq2.isEmpty()) {
							pq.offer(pq2.poll());
						}
					} else if (x <= 0 && y <= 0) {
						if (!check) {
//							System.out.println(1);
							pq.offer(x);
							pq.offer(y);
							pq2 = new PriorityQueue<>();
							while (!pq.isEmpty()) {
								pq2.offer(pq.poll());
							}
							pq = new PriorityQueue<>();
							while (!pq2.isEmpty()) {
								pq.offer(pq2.poll());
							}
							check = true;
						} else {
							arr[idx++] = x * y;
						}
					}
				} else {
					arr[idx++] = pq.poll();
				}
			}
//			
		}

		else {
			while (!pq.isEmpty()) {
//				System.out.println("pqsize : " + pq.size());
				int x = pq.poll();
				int y = pq.poll();
//				System.out.println("x : " + x + " y : " + y);
				if (x > 1 && y > 1) {
					arr[idx++] = x * y;
				} else if (x > 0 && y > 0) {
					arr[idx++] = x;
					arr[idx++] = y;
				} else if (x > 0 && y <= 0) {
					arr[idx++] = x;
					arr[idx++] = y;
				} else if (x <= 0 && y <= 0) {
					if (!check) {
						pq.offer(x);
						pq.offer(y);
						pq2 = new PriorityQueue<>();
						while (!pq.isEmpty()) {
							pq2.offer(pq.poll());
						}
						pq = new PriorityQueue<>();
						while (!pq2.isEmpty()) {
							pq.offer(pq2.poll());
						}
						check = true;
					} else {

						arr[idx++] = x * y;
					}
				}
			}
		}
		int sum = 0;
		for (int i = 0; i < idx; i++) {
			sum += arr[i];
		}
		System.out.println(sum);

	}
}
