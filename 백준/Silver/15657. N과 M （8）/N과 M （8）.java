
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int M;
	static int[] arr;
	static int[] compare;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		compare = new int[M];
		for(int i=0; i<N; i++) {
			arr[i]= sc.nextInt();
		}
		Arrays.sort(arr);
		sb = new StringBuilder();
		backtracking(0, 0);
		System.out.println(sb);
		
	}
	
	public static void backtracking(int idx, int sidx) {
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
			backtracking(i, sidx+1);
		}
	}
}
