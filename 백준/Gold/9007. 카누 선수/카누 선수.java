

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int k, n;
    static int[][] arr;

    static int[] newN1;
    static int[] newN2;

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        input();
    }

    private static int twoPointer() {
        int s = 0;
        int e = newN2.length-1;
        int res = Integer.MAX_VALUE;
        while (s<newN1.length && e>=0) {
            // 처음+끝이 k보다 큰 경우
//            System.out.println("s : " + newN1[s] + " e : " + newN2[e]);
            if (newN1[s] + newN2[e] > k) {
                if (Math.abs(k - (newN1[s] + newN2[e])) <=Math.abs(k -res)) {
                    if(Math.abs(k - (newN1[s] + newN2[e])) ==Math.abs(k -res)){
                        res = Math.min(newN1[s] + newN2[e],res);
                    }else{
                        res = newN1[s] + newN2[e];
                    }
                }
                e--;
            }
            // 작은 경우
            else if (newN1[s] + newN2[e] < k) {
                if (Math.abs(k - (newN1[s] + newN2[e])) <= Math.abs(k -res)) {
                    if(Math.abs(k - (newN1[s] + newN2[e])) ==Math.abs(k -res)){
                        res = Math.min(newN1[s] + newN2[e],res);
                    }else{
                        res = newN1[s] + newN2[e];
                    }
                }
                s++;
            }
            // 같은 경우
            else {
                res = k;
                break;
            }
//            System.out.println(res);
        }
        if(s==newN1.length) s--;
        if(e ==-1) e++;
        if (Math.abs(k - (newN1[s] + newN2[e])) <= Math.abs(k -res)) {
            if(Math.abs(k - (newN1[s] + newN2[e])) ==Math.abs(k -res)){
                res = Math.min(newN1[s] + newN2[e],res);
            }else{
                res = newN1[s] + newN2[e];
            }
        }
        return res;

    }

    private static void sum(int[][] arr) {
        newN1 = new int[n * n];
        newN2 = new int[n * n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newN1[idx] = arr[0][i] + arr[1][j];
                newN2[idx++] = arr[2][i] + arr[3][j];

            }
        }
        Arrays.sort(newN1);
        Arrays.sort(newN2);
//        System.out.println(Arrays.toString(newN1));
//        System.out.println(Arrays.toString(newN2));
    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb= new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            arr = new int[4][n];
            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            sum(arr);
            sb.append(twoPointer()).append("\n");
        }
        System.out.println(sb);
    }
}
