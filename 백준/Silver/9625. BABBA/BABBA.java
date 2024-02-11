import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int[][] dp = new int[k + 1][2];
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;
        for (int i = 2; i <= k; i++) {
            dp[i][0] = dp[i-1][1];
            dp[i][1]=dp[i-1][0]+dp[i-1][1];

        }
        System.out.println(dp[k][0]+" "+dp[k][1]);


    }


}


//
/*
 * 2143
 * 3412
 * */
