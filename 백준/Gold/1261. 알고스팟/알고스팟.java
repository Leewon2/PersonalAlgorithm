

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{

    static int N;
    static int M;
    static int[][] arr;
    static boolean[][] visited;
    static final int[] dr = {1, 0, -1, 0};
    static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];


        for (int r = 0; r < N; r++) {
            String str = br.readLine();
            for (int c = 0; c < M; c++) {
                arr[r][c] = Character.getNumericValue(str.charAt(c));
            }
        }
        System.out.println(bfs());

    }

    public static int bfs(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, 0));
        visited[0][0]=true;

        while (!pq.isEmpty()) {
            Node poll = pq.poll();

            if (poll.row == N - 1 && poll.col == M - 1) {
                return poll.cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nr = poll.row+dr[i];
                int nc = poll.col+dc[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc]) continue;

                visited[nr][nc]=true;
                if (arr[nr][nc] == 1) {
                    pq.offer(new Node(nr, nc, poll.cnt + 1));
                } else {
                    pq.offer(new Node(nr, nc, poll.cnt));
                }


            }

        }

        return 0;


    }

    public static class Node implements Comparable<Node>{
        int row;
        int col;
        int cnt;

        public Node(int row, int col, int cnt) {
            this.row=row;
            this.col=col;
            this.cnt=cnt;
        }
        @Override
        public int compareTo(Node o) {
            return this.cnt-o.cnt;
        }
    }
}