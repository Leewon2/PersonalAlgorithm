import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        if(C*R<K){
            System.out.println(0);
            System.exit(0);
        }
        int sr = R-1;
        int sc = 0;
        boolean[][] visited = new boolean[R][C];
        visited[sr][sc]=true;
        int idx=0;
        for (int i = 0; i < K-1; i++) {
            int nr = sr+dr[idx%4];
            int nc = sc+dc[idx%4];
            if(nr<0 || nr>=R || nc<0 || nc>=C || visited[nr][nc]){
                idx++;
            }
            sr += dr[idx%4];
            sc += dc[idx%4];
            visited[sr][sc] = true;
        }
        System.out.println((sc+1)+" "+(R-sr));



    }
}
