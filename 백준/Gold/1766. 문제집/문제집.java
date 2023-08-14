

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		Scanner sc = new Scanner(System.in);
		
		// 문제의 수
		int N = sc.nextInt();
		
		// 먼저 푸는 것이 좋은 문제에 대한 정보의 개수
		int M = sc.nextInt();
		
		int[][] arr = new int[M][2];
		
		int[] inDegree = new int[N+1];
		
		for(int i=0; i<M; i++) {
			arr[i][0]=sc.nextInt();
			arr[i][1]=sc.nextInt();
			inDegree[arr[i][1]]++;
		}
		
		for(int i=1; i<=N; i++) {
			if(inDegree[i]==0) {
				pq.offer(i);
				
			}
		}
		StringBuilder sb = new StringBuilder();
		
		
		while(!pq.isEmpty()) {
			int poll = pq.poll();
			sb.append(poll).append(" ");
			
			for(int i=0; i<M; i++) {
				if(arr[i][0]==poll) {
					inDegree[arr[i][1]]--;
					if(inDegree[arr[i][1]]==0) {
						pq.offer(arr[i][1]);
						
					}
				}
				
			}
		}
		System.out.println(sb);
	}
}
