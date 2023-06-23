

import java.util.Arrays;
import java.util.Scanner;

public class Main{
	
	static int[] compare;
	static StringBuilder sb;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		compare = new int[M];
		visited = new boolean[N];
		sb = new StringBuilder();
		backtracking(0,0, N, M, arr);
		System.out.println(sb);
	}
	
	public static void backtracking(int idx, int sidx, int N, int M, int[] arr) {
		// 기저조건
		if(sidx==M) {
			for(int i=0; i<M; i++) {
				sb.append(compare[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		// 재귀조건
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				compare[sidx]=arr[i];
				visited[i] = true;
				backtracking(i+1, sidx+1, N, M, arr);
				visited[i]=false;
				
			}
		}
	}
}
