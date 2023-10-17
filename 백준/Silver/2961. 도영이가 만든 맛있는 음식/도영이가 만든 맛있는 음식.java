

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] sour;
    static int[] taste;
    static boolean[] check;
    static int min;


    public static void main(String[] args) throws IOException {
        input();
        backtracking(0);
        System.out.println(min);
    }

    private static void backtracking(int idx){
        if (idx == N) {
            boolean not = false;
            int s=1;
            int t=0;

            for (int i = 0; i < N; i++) {
                if (check[i]) {
                    not = true;
                    s*=sour[i];
                    t += taste[i];
                }
            }
            if (not) {
                min = Math.min(min, Math.abs(s - t));
            }
            return;
        }

        check[idx] = true;
        backtracking(idx + 1);
        check[idx]=false;
        backtracking(idx + 1);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        sour = new int[N];
        taste = new int[N];
        check = new boolean[N];
        min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            sour[i] = Integer.parseInt(st.nextToken());
            taste[i] = Integer.parseInt(st.nextToken());
        }
    }
}
