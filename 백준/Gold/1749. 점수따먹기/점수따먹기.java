
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N + 1][M + 1];
        for (int r = 1; r <= N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= M; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N + 1][M + 1];
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= M; c++) {
                dp[r][c] = dp[r][c - 1] + dp[r - 1][c] - dp[r - 1][c - 1] + arr[r][c];
            }
        }
        int max = -99999999;
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= M; c++) {
                for (int i = r; i <= N; i++) {
                    for (int j = c; j <= M; j++) {
                        int sum = dp[i][j] - dp[r - 1][j] - dp[i][c - 1] + dp[r - 1][c - 1];
                        max = Math.max(max, sum);
                    }
                }
            }
        }
        System.out.println(max);
    }
}
