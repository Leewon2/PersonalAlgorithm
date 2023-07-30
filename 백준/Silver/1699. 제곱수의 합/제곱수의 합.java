

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[(int) Math.sqrt(N)+1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = i*i;
        }
        int[] dp = new int[N + 1];
        Arrays.fill(dp,9999999);

        for(int i=1; i<arr.length; i++){
            int idx=1;
            for (int j = 1; j <= N / i; j++) {
                if(arr[i]*j >N) break;
                dp[arr[i]*j] = Math.min(idx,dp[arr[i]*j]);
                idx++;

            }
        }


        for(int i=2; i<=N; i++){
            for (int j = 1; j <arr.length; j++) {
                if(i-arr[j]<1) break;
                dp[i] = Math.min(dp[i], dp[i - arr[j]] + 1);

            }
        }
        System.out.println(dp[N]);
//        System.out.println(Arrays.toString(dp));
    }
}
    