

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				pq.offer(Integer.parseInt(st.nextToken()));
			}
		}
		int cnt=0;
		while(!pq.isEmpty()) {
			cnt++;
			int poll = pq.poll();
			if(N==cnt) {
				System.out.println(poll);
				break;
			}
		}
	}
}
