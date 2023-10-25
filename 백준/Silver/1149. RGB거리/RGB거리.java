
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][3];
		
		int[][] dp = new int[N+1][3];;
		
		for(int r=0; r<N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c=0; c<3; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<=N; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i-1][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i-1][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i-1][2];
		}
		
		int result = Math.min(dp[N][0], dp[N][1]);
		result = Math.min(result, dp[N][2]);
		System.out.println(result);
//		for(int[] list : dp) {
//			System.out.println(Arrays.toString(list));
//		}
		
		
		
		
	}
}
