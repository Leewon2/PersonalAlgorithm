
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dp = new int[100001];
        Arrays.fill(dp,100000);
        dp[2]=1;
        dp[4]=2;
        dp[5]=1;
        for (int i = 6; i < 100001; i++) {
            if (dp[i - 2] != 100000 || dp[i - 5] != 100000) {
                dp[i] = Math.min(dp[i-2], dp[i-5]) +1;
            }

        }
        int n = sc.nextInt();
        if (dp[n] == 100000) {
            System.out.println(-1);
        }else{
            System.out.println(dp[n]);
        }
    }
}
