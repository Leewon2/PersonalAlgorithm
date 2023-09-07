
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < tc; t++) {
            long[] count = new long[10000001];
            StringTokenizer st = new StringTokenizer(br.readLine());
            long d = Long.parseLong(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            long[] arr = new long[n+1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            long[] dp = new long[n+1];
            for (int i = 1; i <= n; i++) {
                dp[i] = dp[i-1]+arr[i];
            }
            int start=0;
            int cnt=0;
            for (int i = 1; i <= n; i++) {
                count[(int) (dp[i]%d)]++;
                if(dp[i]%d==0) cnt+=count[(int) (dp[i]%d)];
                else cnt+=count[(int) (dp[i]%d)]-1;
            }

            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
