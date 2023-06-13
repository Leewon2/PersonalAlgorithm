

import java.util.Scanner;

public class Main {
	
	static boolean[] check;
	static int[][] arr;
	
	static int N;
	static int M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N+1][N+1];
		
		check = new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			int connect1 = sc.nextInt();
			int connect2 = sc.nextInt();
			arr[connect1][connect2] =1;
			arr[connect2][connect1] =1;
		}
		
		int result=0;
		
		for(int i=1; i<=N; i++) {
			if(!check[i]) {
				dfs(i);
				result++;
			}
		}
		System.out.println(result);
	}
	public static void dfs(int i) {
		for(int k=1; k<=N;k++) {
			if(!check[k] && (arr[k][i]==1 || arr[i][k]==1)) {
				check[k]=true;
				dfs(k);
			}
		}
	}
	
}
