
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

                if (arr[r][c] == 1) {
                    if (r - 1 >= 0) {
                        if (c - 1 >= 0) {
                            dp[r][c] = Math.max(dp[r-1][c], dp[r][c-1])+1;
                        }else{
                            dp[r][c] = dp[r-1][c]+1;
                        }
                    }else{
                        if(c-1>=0){
                            dp[r][c] = dp[r][c-1]+1;
                        }
                    }
                }else{
                    if (r - 1 >= 0) {
                        if (c - 1 >= 0) {
                            dp[r][c] = Math.max(dp[r-1][c], dp[r][c-1]);
                        }else{
                            dp[r][c] = dp[r-1][c];
                        }
                    }else{
                        if(c-1>=0){
                            dp[r][c] = dp[r][c-1];
                        }
                    }
                }
            }
        }
        System.out.println(dp[N-1][M-1]);


    }

}
