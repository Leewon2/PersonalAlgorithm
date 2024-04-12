import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[16];
        dp[1] = 3;
        for (int i = 2; i <= 15; i++) {
            dp[i] = dp[i - 1] * 2 - 1;
        }
        System.out.println(dp[N]*dp[N]);
    }
}