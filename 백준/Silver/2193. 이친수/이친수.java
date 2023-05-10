
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		long[] dp = new long[n+1];
		
		dp[1]=1;
		if(n>=2) {
			dp[2]=1;
		}
		if(n>=3)
		dp[3]=2;
		for(int i=4; i<=n; i++) {
			dp[i] = dp[i-1]+dp[i-2];
		}
		
		System.out.println(dp[n]);
	}
}
