

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] dp = new int[n+1][10];

        // 1번째는 모두 1
        for(int i=0; i<10; i++){
            dp[1][i]=1;
        }

        // 아래 첫번째도 모두 1
        for(int i=1; i<=n; i++){
            dp[i][0]=1;
        }

        for(int i=2; i<=n; i++){
            for(int j=1; j<10; j++){
                dp[i][j] = (dp[i-1][j]+dp[i][j-1]) % 10007;

            }
        }

        int sum=0;
        for(int i=0; i<10; i++){
            sum=((sum+dp[n][i]) % 10007);
        }
        System.out.println(sum);
    }
}
