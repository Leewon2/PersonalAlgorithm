

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static StringBuilder sb;
	static int[] compare;
	static int[] arr;
	static boolean[] visited;
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int M = sc.nextInt();
		sb = new StringBuilder();
//		arr = new int[N];
//		for(int i=1; i<=N; i++)
		compare = new int[M];
		visited = new boolean[N+1];
		
		backtracking(1, 0, M);
		System.out.println(sb);
		
	}
	public static void backtracking(int idx, int sidx, int M ) {
		// 기저조건
		if(sidx==M) {
			for(int i=0; i<M; i++) {
				sb.append(compare[i]).append(" ");
			}
			sb.append("\n");
//			System.out.println(Arrays.toString(visited));
			return;
		}
		
		// 재귀조건
		for(int i=idx; i<=N; i++) {
			if(!visited[i]) {
				compare[sidx]=i;
				visited[i]=true;

				backtracking(i+1, sidx+1, M);
				visited[i]=false;

			}
		}
		

		
	}
}
