

import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visited;
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        visited = new boolean[N][M];
        int res=0;
        for (int r = 0; r < N; r++) {
            String str = br.readLine();
            for (int c = 0; c < M; c++) {
                arr[r][c] = str.charAt(c);
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if(!visited[r][c]){
                    if(arr[r][c] =='-'){
                        visited[r][c] = true;
                        dfs1(r,c,M);
                    }else{
                        visited[r][c] = true;
                        dfs2(r,c,N);
                    }
                    res++;
                }
            }
        }
        System.out.println(res);

    }

    // -
    private static void dfs1(int r, int c, int M){
        int nc = c+1;
        if(nc<M && arr[r][nc]=='-') {
            visited[r][nc] = true;
            dfs1(r, nc, M);
        }
    }

    // |
    private static void dfs2(int r, int c, int N){
        int nr = r+1;
        if(nr<N && arr[nr][c]=='|') {
            visited[nr][c] = true;
            dfs2(nr, c, N);
        }
    }
}
