

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        long[] dp = new long[1000001];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        for (int i = 4; i <= 1000000; i++) {
            dp[i] = (dp[i-1]%1000000009+dp[i-2]%1000000009+dp[i-3]%1000000009)%1000000009;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            sb.append(dp[k]).append("\n");
        }
        System.out.println(sb);
    }
}
