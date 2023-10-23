
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;

    // 날짜
    static int[] ti;
    // 금액
    static int[] pi;
    static int[] dp;
    static int max;

    public static void main(String[] args) throws IOException {
        input();
        dp();
        System.out.println(max);
//        System.out.println(Arrays.toString(dp));
    }

    private static void dp() {
        for (int i = 0; i <= N; i++) {
            // i일에 일을 할 수 있는 경우
            max = Math.max(max, dp[i]);
            if (i + ti[i] <= N) {
                int idx = i + ti[i];
                dp[idx] = Math.max(dp[idx], max + pi[i]);
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ti = new int[N + 1];
        pi = new int[N + 1];
        dp = new int[N + 1];
        max = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ti[i] = Integer.parseInt(st.nextToken());
            pi[i] = Integer.parseInt(st.nextToken());
        }
    }
}
