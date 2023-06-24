
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[2][n];
			int[][] dp = new int[2][n];
			for (int idx = 0; idx < 2; idx++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int i = 0; i < n; i++) {
					arr[idx][i] = Integer.parseInt(st.nextToken());
				}
			}
			dp[0][0] = arr[0][0];
			dp[1][0] = arr[1][0];
			if(n>1) {
				dp[0][1] = arr[0][1]+arr[1][0];
				dp[1][1] = arr[1][1]+arr[0][0];
			}
			
			for(int i=2; i<n; i++) {
				dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2])+arr[0][i];
				dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2])+arr[1][i];
			}
			
			int max = Math.max(dp[0][n-1], dp[1][n-1]);
			sb.append(max).append("\n");
//			for(int[] list : dp) {
//				System.out.println(Arrays.toString(list));
//			}
			
		}
		System.out.println(sb);
	}
}
