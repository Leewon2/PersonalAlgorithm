import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 가로, 대각선, 세로
    static final int[] dr = {0, 1, 1};
    static final int[] dc = {1, 1, 0};

    static int N;
    static int[][] map;
    static int res;

    public static void main(String[] args) throws IOException {
        input();
        if (map[N - 1][N - 1] != 1) {
            dfs(0, 1, 0); 
        }

        System.out.println(res);
    }

    private static void dfs(int r, int c, int shape) {
        if (r == N - 1 && c == N - 1) {
            res++;
            return;
        }

        for (int i = 0; i < 3; i++) {
            // 조건에 따라 방향 결정
            if ((shape == 0 && i == 2) || (shape == 2 && i == 0)) continue;

            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == 1) continue;

            if (i == 1) {
                if (map[r][c + 1] == 1 || map[r + 1][c] == 1) continue;
            }
            dfs(nr, nc, i);
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        res = 0;
    }
}
