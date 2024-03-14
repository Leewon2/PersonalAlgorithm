import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] oddDr = {1, 0, -1, 0, -1, 1};
    static int[] oddDc = {0, 1, 0, -1, 1, 1};
    static int[] evenDr = {0, 1, -1, 0, -1, 1};
    static int[] evenDc = {1, 0, 0, -1, -1, -1};
    static boolean[][] visited;
    static int N, M;
    static Queue<Node> q;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        arr = new int[N][M];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[r][c] = -1;
        }
        // 짝수면 상하좌우, 왼쪽위 ,왼쪽 아래
        // 홀수면 상하좌우, 오른쪽 위, 오른쪽 아래
        q = new LinkedList<>();
        q.offer(new Node(0, 0, 0));
        while (!q.isEmpty()) {
            Node poll = q.poll();
            int r = poll.r;
            int c = poll.c;
            int cnt = poll.cnt;
            if(r==N-1 && c==M-1){
                System.out.println(cnt);
                System.exit(0);
            }
            if (r % 2 == 0) {
                calculate(r, c, cnt, evenDr, evenDc);

            } else {
                calculate(r, c, cnt, oddDr, oddDc);
            }
        }
        System.out.println(-1);

    }

    private static void calculate(int r, int c, int cnt, int[] dr, int[] dc) {
        for (int i = 0; i < 6; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || arr[nr][nc] == -1) continue;
            visited[nr][nc] = true;
            q.offer(new Node(nr, nc, cnt + 1));
        }
    }

    private static class Node {
        int r;
        int c;
        int cnt;

        public Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}
