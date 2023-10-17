

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    static boolean[] check;
    static int max;
    static int compare[];

    public static void main(String[] args) throws IOException{
        input();
        backtracking(0);
        System.out.println(max);
    }

    private static void backtracking(int idx){
        // 기저
        if (idx == N) {
            int sum=0;
            for (int i = 0; i < N-1; i++) {
                sum+= Math.abs(compare[i+1]-compare[i]);
            }
            max = Math.max(sum, max);
            return;
        }

        // 재귀
        for (int i = 0; i < N; i++) {
            if(!check[i]){
                check[i]=true;
                compare[idx]=arr[i];
                backtracking(idx + 1);
                check[i]=false;

            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        check = new boolean[N];
        max = 0;
        compare = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
