

import java.util.Scanner;

public class Main {

    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] compare = new int[M];
        sb = new StringBuilder();
        backtracking(N,M,0,compare);
        System.out.println(sb);
    }

    private static void backtracking(int N, int M, int idx, int[] compare){
        if(idx==M){
            for (int i = 0; i < compare.length; i++) {
                sb.append(compare[i]).append(" ");
            }
            sb.append("\n");

            return;
        }
        for (int i = 1; i <= N; i++) {
            compare[idx]=i;
            backtracking(N,M,idx+1,compare);
        }
    }
}
