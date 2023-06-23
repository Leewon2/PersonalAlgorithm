

import java.util.Arrays;
import java.util.Scanner;

public class Main{
	static int N;
	static int M;
	static int[] arr;
	static int[] compare;
	static StringBuilder sb;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		compare = new int[M];
		sb = new StringBuilder();
		visited = new boolean[10001];
		backtracking(0);
		System.out.println(sb);
	}

	public static void backtracking(int sidx) {
		// 기저조건
		if (sidx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(compare[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		// 재귀조건
		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			if(i>=1&& arr[i-1]==arr[i] && !visited[i-1]) continue;
			compare[sidx] = arr[i];
			visited[i] = true;
			backtracking(sidx + 1);
			visited[i] = false;

		}
	}
}
