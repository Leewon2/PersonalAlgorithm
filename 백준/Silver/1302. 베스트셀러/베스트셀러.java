

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
        Arrays.sort(arr);
        int[] dp = new int[N];
        dp[0]=1;
        for (int i = 1; i < N; i++) {
            if(arr[i].equals(arr[i-1])) dp[i]=dp[i-1]+1;
            else dp[i]=1;
        }
        String res = arr[0];
        int max=1;
        for (int i = 1; i < N; i++) {
            if(dp[i]>max) {
                max = dp[i];
                res = arr[i];
            }
        }
        System.out.println(res);
    }
}
