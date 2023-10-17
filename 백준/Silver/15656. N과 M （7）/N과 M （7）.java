
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int[] compare = new int[M];
        sb = new StringBuilder();
        boolean[] check = new boolean[N];
        backtracking(arr, N,M,0,compare, 0);
        System.out.println(sb);
    }

    private static void backtracking(int[] arr, int N, int M, int idx, int[] compare,int start){
        if(idx==M){
            for (int i = 0; i < compare.length; i++) {
                sb.append(compare[i]).append(" ");
            }
            sb.append("\n");

            return;
        }
        for (int i = 0; i < N; i++) {
            compare[idx] = arr[i];
            backtracking(arr, N, M, idx + 1, compare, i);
        }
    }
}
