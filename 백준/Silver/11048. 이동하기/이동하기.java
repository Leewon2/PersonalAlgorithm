

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        int[] dr = {-1,-1,0};
        int[] dc = {0,-1,-1};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        int[][] dp = new int[N][M];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = arr[0][0];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                for (int i = 0; i < 3; i++) {
                    int nr = r+dr[i];
                    int nc = c+dc[i];
                    if(nr<0|| nc<0 || nr>=N || nc>=M) continue;
                    dp[r][c] = Math.max(dp[r][c], dp[nr][nc]+arr[r][c]);
                }
            }
        }
//        for (int[] list : dp) {
//            System.out.println(Arrays.toString(list));
//        }
        System.out.println(dp[N-1][M-1]);

    }
}
