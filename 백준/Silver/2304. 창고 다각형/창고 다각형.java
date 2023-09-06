

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[1002];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        int[] prefix = new int[1002];
        int[] suffix = new int[1002];
        for (int i = 1; i <= 1000; i++) {
            prefix[i] = Math.max( prefix[i-1],arr[i]);
        }
        for (int i = 1000; i >= 1; i--) {
            suffix[i] = Math.max(suffix[i+1],arr[i]);
        }

        int[] dp = new int[1002];
        int sum=0;
        for (int i = 1; i <= 1000; i++) {
            dp[i] = Math.min(suffix[i], prefix[i]);
            sum+=dp[i];
        }
        System.out.println(sum);

    }

}
