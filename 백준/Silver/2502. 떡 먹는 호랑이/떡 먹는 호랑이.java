

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int D = sc.nextInt();
		
//		int A = 0;
//		int B =0 ;
		
		
		int K = sc.nextInt();
		
		int[] dp = new int[D+1];
		
		outer : for(int i=1; i<=K; i++) {
			for(int j=1; j<=K; j++) {
				dp[1] = i;
				dp[2] = j;
				for(int k=3; k<=D; k++) {
					dp[k]=dp[k-1]+dp[k-2];
				}
				if(dp[D]==K) {
					break outer;
				}
			}
		}
		System.out.println(dp[1]);
		System.out.println(dp[2]);
	}
}
