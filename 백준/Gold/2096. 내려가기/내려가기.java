

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][3];
		int[][] dp = new int[N][3];
		int[][] mindp = new int[N][3];

		for(int r=0; r<N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c=0; c<3; c++) {
				arr[r][c]=Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0]=arr[0][0];
		dp[0][1]=arr[0][1];
		dp[0][2]=arr[0][2];
		mindp[0][0]=arr[0][0];
		mindp[0][1]=arr[0][1];
		mindp[0][2]=arr[0][2];
		for(int r=1; r<N; r++) {
			int compare=0;
			// 갈 수 있는 곳 중 큰 녀석 선택
			
			// 왼쪽
			if(dp[r-1][0]>dp[r-1][1]) {
				dp[r][0]=dp[r-1][0]+arr[r][0];
			}else {
				dp[r][0]=dp[r-1][1]+arr[r][0];
			}
			
			// 가운데
			if(dp[r-1][0]>dp[r-1][1]) {
				compare = dp[r-1][0];
			}else {
				compare = dp[r-1][1];
			}
			if(compare<dp[r-1][2]) {
				compare=dp[r-1][2];
			}
			dp[r][1]=compare+arr[r][1];
			
			// 끝
			if(dp[r-1][2]>dp[r-1][1]) {
				dp[r][2]=dp[r-1][2]+arr[r][2];
			}else {
				dp[r][2]=dp[r-1][1]+arr[r][2];
			}
		}
		
		for(int r=1; r<N; r++) {
			int compare=0;
			// 갈 수 있는 곳 중 큰 녀석 선택
			
			// 왼쪽
			if(mindp[r-1][0]>=mindp[r-1][1]) {
				mindp[r][0]=mindp[r-1][1]+arr[r][0];
			}else {
				mindp[r][0]=mindp[r-1][0]+arr[r][0];
			}
			
			// 가운데
			if(mindp[r-1][0]<mindp[r-1][1]) {
				compare = mindp[r-1][0];
			}else {
				compare = mindp[r-1][1];
			}
			if(compare>mindp[r-1][2]) {
				compare=mindp[r-1][2];
			}
			mindp[r][1]=compare+arr[r][1];
			
			// 끝
			if(mindp[r-1][2]<mindp[r-1][1]) {
				mindp[r][2]=mindp[r-1][2]+arr[r][2];
			}else {
				mindp[r][2]=mindp[r-1][1]+arr[r][2];
			}
		}
		
		
		int maxResult=0;
		int minResult=9999999;
		for(int i=0;i<3; i++) {
			maxResult = Math.max(maxResult, dp[N-1][i]);
			minResult = Math.min(minResult, mindp[N-1][i]);
		}
		System.out.print(maxResult+" "+minResult);
	}
}
