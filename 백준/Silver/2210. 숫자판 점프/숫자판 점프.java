import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static Set<String> set;
    static int[] a;
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[5][5];
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        set = new HashSet<>();
        a = new int[6];
        visited = new boolean[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(0, i, j);
            }
        }
        System.out.println(set.size());
    }

    private static void dfs(int idx, int r, int c){
        if(idx==6){
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                str.append(a[i]);
            }

            set.add(str.toString());
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nr = r+dr[i];
            int nc = c+dc[i];
            if(nr<0 || nc<0 || nr>=5 || nc>=5) continue;
            a[idx] = arr[nr][nc];
            dfs(idx + 1, nr, nc);
        }
    }
}
