
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N+1][N+1];
        int[][][] dp = new int[N + 1][N + 1][11];
        for (int r = 1; r <= N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= N; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                for (int i = 1; i <= 10; i++) {
                    dp[r][c][i] += dp[r][c-1][i];
                    dp[r][c][i]+=dp[r-1][c][i];
                    dp[r][c][i]-=dp[r-1][c-1][i];
                }
                dp[r][c][arr[r][c]]++;
            }
        }



        int Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());

            int[] count = new int[11];
            for (int j = 1; j<= 10; j++) {
                count[j] = dp[ex][ey][j];
            }
            for (int j = 1; j <= 10; j++) {
                count[j] -= dp[sx -1][ey][j];
                count[j] -= dp[ex][sy-1][j];
                count[j] += dp[sx - 1][sy - 1][j];
            }
            int cnt = 0;
            for (int j = 1; j <= 10; j++) {
                if(count[j]>0) cnt++;
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);

    }
}
