

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x != 0)
				if(x<0)
				pq2.offer(x);
				else
					pq.offer(x);
			else {
				if (pq.isEmpty() && pq2.isEmpty())
					sb.append(0).append("\n");
				else {
					int peek1=Integer.MAX_VALUE;
					int peek2=Integer.MAX_VALUE;
					if(!pq.isEmpty()) {
						peek1 = pq.peek();
					}
					if(!pq2.isEmpty()) {
						peek2=pq2.peek();
					}
					if(peek1 < Math.abs(peek2)){
						sb.append(pq.poll()).append("\n");
					}else {
						sb.append(pq2.poll()).append("\n");
					}
					
				}
			}
		}
		System.out.println(sb);
	}
}
