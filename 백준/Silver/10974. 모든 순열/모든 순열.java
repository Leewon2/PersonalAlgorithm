

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static int N;
    static StringBuilder sb;
    static int[] compare;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i+1;
        }
        visited = new boolean[N];
        sb = new StringBuilder();
        compare = new int[N];
        perm(0);
        System.out.println(sb);
    }

    private static void perm(int idx){
        if(idx==N){
            for (int i = 0; i < N; i++) {
                sb.append(compare[i]).append(" ");
            }
            sb.append("\n");
        }

        for (int i = 0; i < N; i++) {
            if(!visited[i]){
                compare[idx] = arr[i];
                visited[i]=true;
                perm(idx+1);
                visited[i]=false;

            }
        }
    }
}
