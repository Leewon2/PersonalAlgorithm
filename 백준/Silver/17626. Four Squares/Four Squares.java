

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[n+1];
		
		for(int i=1; i<=Math.sqrt(n); i++) {
			dp[(int) Math.pow(i, 2)] = 1;
		}
//		System.out.println(Arrays.toString(dp));
		
		int find=n;
		int result=0;
		
		for(int i=1; i<n;i++) {
			for(int j=1; j<=Math.sqrt(n); j++) {
				int k=(int) (i+Math.pow(j, 2));
				if(k<=n) {
					if(dp[k]!=0) {
						dp[k]=Math.min(dp[i]+1, dp[k]);
					}else
						dp[k]=dp[i]+1;
				}
			}
		}
		System.out.println(dp[n]);
		
	}
}
