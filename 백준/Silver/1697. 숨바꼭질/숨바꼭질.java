

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int K;
	static int N;
	static Queue<Integer> q = new LinkedList<>();
	static int[] count;
	static final int INF = Integer.MAX_VALUE;
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 수빈이의 위치
		N = sc.nextInt();
		
		// 동생의 위치
		K = sc.nextInt();
		q.offer(N);
		count = new int[100001];
		Arrays.fill(count, INF);
		
		count[N]=0;
		bfs();
		System.out.println(count[K]);
//		System.out.println(Arrays.toString(count));
		
		
	}
	public static void bfs() {
		
		while(!q.isEmpty()) {
			int poll = q.poll();
//			System.out.println(poll);
			
			if(poll-1>=0) {
				if (count[poll - 1] > count[poll] + 1) {
					count[poll - 1] = count[poll] + 1;
					q.offer(poll - 1);
//					System.out.println("poll-1");
				}
				
			}
			if(poll*2<K*2 && poll*2<count.length) {
				if(count[poll*2]>count[poll]+1) {
					count[poll*2]=count[poll]+1;
					q.offer(poll*2);
//					System.out.println("poll*2");
				}
			}
			
			if(poll+1<K*2 && poll+1<count.length) {
				if(count[poll+1]>count[poll]+1) {
					count[poll+1]=count[poll]+1;
					q.offer(poll+1);
//					System.out.println("poll+1");
				}
				
			}
			
		}
		
	}
}
