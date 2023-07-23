

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[100][10];

        dp[0][0] = 0;
        for (int i = 1; i <= 9; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][1];
            for (int j = 1; j < 9; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                dp[i][j] = dp[i][j] % 1000000000;
            }
            dp[i][9] = dp[i - 1][8];
        }
        int sum = 0;
        for (int i = 0; i < 10; i++)
        {
            sum += dp[n - 1][i];
            sum = sum % 1000000000;
        }
        System.out.println(sum);
    }
}
