

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= N; i++) {
            int j = i;
            int temp=1;
            while(j<=N){
                dp[j] = Math.max(dp[j], arr[i] * temp++);
                j+=i;
            }

        }
        for (int i = 1; i <= N; i++) {
            for (int j = i-1; j > 0; j--) {
                dp[i] = Math.max(dp[i],dp[j]+dp[i-j]);
            }
        }
        System.out.println(dp[N]);
    }
}
