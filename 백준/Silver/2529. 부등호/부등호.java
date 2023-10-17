

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static char[] arr;
    static boolean[] check;
    static int[] num;
    static long max;
    static long min;

    public static void main(String[] args) throws IOException {
        input();
        backtracking(0);
        String m = String.valueOf(max);
        String mi = String.valueOf(min);
        if (m.length() != mi.length()) {
            mi = "0"+mi;
        }
        System.out.println(m);
        System.out.println(mi);
    }

    private static void backtracking(int idx){
        // 기저
        if (idx == N+1) {
            for (int i = 0; i < N; i++) {
                if (arr[i] == '>') {
                    if(num[i]<num[i+1]) return;
                } else {
                    if(num[i]>num[i+1]) return;
                }
            }
            String str="";
            for (int i = 0; i <= N; i++) {
                str+=num[i];
            }
            long k = Long.parseLong(str);
            max = Math.max(max, k);
            min = Math.min(min, k);
            return;
        }

        // 재귀(순열)
        for (int i = 0; i <=9; i++) {
            if(!check[i]){
                check[i]=true;
                num[idx] = i;
                backtracking(idx+1);
                check[i]=false;
            }
        }

    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new char[N];
        check = new boolean[10];
        max = 0;
        min=Long.MAX_VALUE;
        num = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
    }
}
