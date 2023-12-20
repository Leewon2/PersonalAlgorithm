

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static boolean[][] visited;
    static int[][] arr;
    static int res;
    static int[] dr = {-1, -1, -1};
    static int[] dc = {-1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];
        res = 0;
        dfs(0);
        System.out.println(res);

    }

    private static boolean checkTrue(int x, int y, int idx) {
        int nr = x;
        int nc = y;
        while (true) {
            nr += dr[idx];
            nc += dc[idx];
            if (nr < 0 || nc < 0 || nr >= N || nc >= N) break;
            if (visited[nr][nc]) {
                return false;
            }
        }
        return true;

    }

    private static void dfs(int idx) {
        if (idx == N) {
            res++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (checkTrue(idx, i, 0) && checkTrue(idx, i, 1) && checkTrue(idx, i, 2)){
                visited[idx][i]=true;
                dfs(idx+1);
                visited[idx][i]=false;
            }
        }
    }

}
