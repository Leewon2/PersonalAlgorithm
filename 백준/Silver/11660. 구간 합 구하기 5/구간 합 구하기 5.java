

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][N];
		int[][] dp = new int[N][N];
		for(int r=0; r<N; r++) {
			int sum=0;
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				int x =Integer.parseInt(st.nextToken());
				arr[r][c]=x;
				sum+=x;
				dp[r][c]=sum;
			}
		}
//		for(int[] list:dp) {
//			System.out.println(Arrays.toString(list));
//		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken())-1;
			int c1 = Integer.parseInt(st.nextToken())-1;
			int r2 = Integer.parseInt(st.nextToken())-1;
			int c2 = Integer.parseInt(st.nextToken())-1;
			int result=0;
			for(int r=r1; r<=r2; r++) {
				if(c1==0) {
					result+=dp[r][c2];
				}else {
					result+=dp[r][c2]-dp[r][c1-1];
				}
			}
			sb.append(result).append("\n");
		}
		
		System.out.println(sb);
		
	}
}
