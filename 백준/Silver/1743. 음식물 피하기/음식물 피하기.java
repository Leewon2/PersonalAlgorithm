import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[][] arr = new boolean[N][M];
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            arr[r][c] = true;
        }
        int max = 0;
        Queue<Node> q = new LinkedList<>();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (arr[r][c] && !visited[r][c]) {
                    q.offer(new Node(r, c));
                    int cnt = 0;
                    visited[r][c] = true;
                    while (!q.isEmpty()) {
                        cnt++;
                        Node poll = q.poll();
                        for (int i = 0; i < 4; i++) {
                            int nr = poll.row + dr[i];
                            int nc = poll.col + dc[i];
                            if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc]) continue;
                            if (arr[nr][nc]) {
                                visited[nr][nc] = true;
                                q.offer(new Node(nr, nc));
                            }
                        }
                    }
                    max = Math.max(cnt, max);
                }
            }
        }
        System.out.println(max);

    }

    private static class Node {
        int row;
        int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
