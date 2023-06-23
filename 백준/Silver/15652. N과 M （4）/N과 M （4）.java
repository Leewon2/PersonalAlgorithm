

import java.util.Scanner;

public class Main{
	static boolean[] visited;
	static int[] compare;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i]=i+1;
		}
		compare = new int[M];
		
		visited = new boolean[N];
		sb= new StringBuilder();
		backtracking(0, 0, N, M, arr);
		System.out.println(sb);
	}
	
	public static void backtracking(int idx, int sidx,int N, int M, int[] arr) {
		// 기저조건
		if(sidx==M) {
			for(int i=0; i<M; i++) {
				sb.append(compare[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		// 재귀조건
		for(int i=idx; i<N; i++) {
				compare[sidx] = arr[i];
				backtracking(i, sidx+1, N, M, arr);
		}
	}
}
