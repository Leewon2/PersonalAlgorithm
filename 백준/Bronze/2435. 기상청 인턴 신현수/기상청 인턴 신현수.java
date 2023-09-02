

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] dp = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum=0;
        for (int i = 0; i < K; i++) {
            sum+=arr[i];
        }
        dp[K-1] = sum;
        for (int i = K; i < N; i++) {
            dp[i] =  dp[i-1]+arr[i] - arr[i-K];
            sum = Math.max(sum, dp[i]);
        }
        System.out.println(sum);
    }
}
