

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        long[][] dp = new long[65][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] =1;
        }
        for (int i = 2; i < 65; i++) {
            dp[i][0] =1;
        }

        for (int i = 2; i < 65; i++) {
            for (int j = 1; j < 10; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < t; tc++) {
            int x = Integer.parseInt(br.readLine());
            long sum=0;
            for (int i = 0; i < 10; i++) {
                sum+=dp[x][i];
            }
            sb.append(sum).append("\n");

        }
        System.out.println(sb);

    }
}
