
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer> list;
    static int len;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(DP(0,0,0));
    }

    private static int DP(int left, int right, int idx) {
        if (idx == len) return 0;
        if (dp[left][right][idx] != 0) return dp[left][right][idx];
        int next = list.get(idx);
        int leftSum = calculate(left, next) + DP(next, right, idx + 1);
        int rightSum = calculate(right, next) + DP(left, next, idx + 1);
        dp[left][right][idx] = Math.min(leftSum, rightSum);
        return dp[left][right][idx];

    }

    private static int calculate(int x, int y) {
        if (x == 0) return 2;
        else if (x == y) return 1;
        else if ((x + 2) % 4 == y % 4) return 4;
        return 3;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new ArrayList<>();
        while (true) {
            int k = Integer.parseInt(st.nextToken());
            if (k == 0) break;
            list.add(k);
        }
        len = list.size();
        dp = new int[5][5][len];

    }
}
