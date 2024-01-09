
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] arr;
    static int res;



    public static void main(String[] args) throws IOException {
        input();
        int[][] dp = new int[N][100001];
        res = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int memory = arr[i][0];
            int cost = arr[i][1];
            for (int j = 0; j <= 100000; j++) {
                if(i==0){
                    if(j>=cost) dp[i][j] = memory;
                }else{
                    if(j>=cost) dp[i][j] = Math.max(dp[i - 1][j - cost] + memory, dp[i - 1][j]);
                    else dp[i][j] = dp[i-1][j];
                }

                if(dp[i][j]>=M) res = Math.min(res, j);
            }
        }
        System.out.println(res);
    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

    }

}
