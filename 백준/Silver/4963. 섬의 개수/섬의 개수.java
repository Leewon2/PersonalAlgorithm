
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] arr;
    static int[] dr = {1, 1, 1, -1, -1, -1, 0, 0};
    static int[] dc = {1, -1, 0, 1, -1, 0, 1, -1};
    static Queue<Node> q;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        while (input(br, st)) {
            int cnt = 0;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (!visited[r][c] && arr[r][c] == 1) {
                        q.offer(new Node(r, c));
                        visited[r][c] = true;
                        while (!q.isEmpty()) {
                            Node poll = q.poll();
                            int rr = poll.r;
                            int cc = poll.c;
                            for (int i = 0; i < 8; i++) {
                                int nr = rr + dr[i];
                                int nc = cc + dc[i];
                                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                                if (!visited[nr][nc] && arr[nr][nc] == 1) {
                                    q.offer(new Node(nr, nc));
                                    visited[nr][nc] = true;
                                }
                            }

                        }
                        cnt++;
                    }

                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean input(BufferedReader br, StringTokenizer st) throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        q = new ArrayDeque<>();

        if (N == 0 && M == 0) return false;
        arr = new int[N][M];
        visited = new boolean[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        return true;
    }

    private static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
