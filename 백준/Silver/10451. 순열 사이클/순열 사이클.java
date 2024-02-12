import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < tc; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N+1];
            boolean[] visited = new boolean[N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            sb.append(cycle(arr, visited, N)).append("\n");

        }
        System.out.println(sb);



    }
    private static int cycle(int[] arr, boolean[] visited, int N){
        int cnt=0;
        for (int i = 1; i <= N; i++) {
            if(!visited[i]){
                visit(arr[i],arr,visited);
                cnt++;
            }
        }
        return cnt;
    }
    private static void visit(int n,int[] arr, boolean[] visited){
        if(!visited[n]){
            visited[n]=true;
            visit(arr[n],arr,visited);
        }
    }




}


//
/*
 * 2143
 * 3412
 * */
