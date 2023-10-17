

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int S;
    static int[] arr;
    static boolean[] check;
    static int res;

    public static void main(String[] args) throws IOException {
        input();
        backtracking(0);
        System.out.println(res);
    }

    private static void backtracking(int idx) {
        //기저
        if (idx == N) {
            int sum = 0;
            boolean not = false;
            for (int i = 0; i < N; i++) {
                if (check[i]) {
                    not = true;
                    sum += arr[i];
                }
            }
            if (not&& sum == S) res++;
            return;
        }

        // 재귀(부분집합)
        check[idx] = true;
        backtracking(idx + 1);
        check[idx]=false;
        backtracking(idx+1);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        check = new boolean[N];
        res = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
