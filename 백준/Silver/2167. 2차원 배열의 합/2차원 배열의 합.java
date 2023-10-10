
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[][] arr;
    static int[][] dp;
    static int k;

    public static void main(String[] args) throws IOException {
        input();
    }

    private static int calculate(int sx, int sy, int ex, int ey){
        int sum=0;
        for (int i = sx; i <= ex; i++) {
            sum+=dp[i][ey];
        }
        if(sy!=0) {
            for (int i = sx; i <= ex; i++) {
                sum -= dp[i][sy-1];
            }
        }
        return sum;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        dp = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            dp[i][0] = arr[i][0];
        }
        for (int r = 0; r < N; r++) {
            for (int c = 1; c < M; c++) {
                dp[r][c] = dp[r][c - 1] + arr[r][c];
            }
        }
        k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken())-1;
            int sy = Integer.parseInt(st.nextToken())-1;
            int ex = Integer.parseInt(st.nextToken())-1;
            int ey = Integer.parseInt(st.nextToken())-1;
            System.out.println(calculate(sx,sy,ex,ey));

        }

    }


}
