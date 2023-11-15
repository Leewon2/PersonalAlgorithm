

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] arr;

    static int[][]map;
    static boolean[][][] visited;
    static final int[] dr = {1, 0, -1, 0};
    static final int[] dc = {0, 1, 0, -1};
    static final int INF = Integer.MAX_VALUE;
    static Queue<Node> q;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(bfs());
    }

    // bfs를 돌리는데, 벽을 뚫고 지나간 친구, 안지나간 친구 나눠서 계산
    // visited의 3번째는 0과 1로 나눈다.
    // visited[0][0][0] => 해당 값 까지 오는데 벽을 안뚫었음
    // visited[0][0][1] => 해당 값 까지 오는데 벽을 부쉈음

    private static int bfs() {
        while (!q.isEmpty()) {
            Node poll = q.poll();
            int r = poll.r;
            int c = poll.c;
            boolean check = poll.check;

            if (r == N - 1 && c == M - 1) {
                return map[r][c];
            }
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                // 범위를 벗어나는 경우
                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                // 그냥 갈 수 있는 경우
                if (arr[nr][nc] == 0) {
                    // 이전에 벽을 부수고 오지 않은 경우
                    // 방문하지 않은 경우
                    if(!check && !visited[nr][nc][0]){
                        visited[nr][nc][0]=true;
                        q.offer(new Node(nr,nc, false));
                        map[nr][nc]=map[r][c]+1;
                    }
                    // 이전에 벽을 부수고 온 경우
                    if(check && !visited[nr][nc][1]){
                        visited[nr][nc][1]=true;
                        q.offer(new Node(nr, nc, true));
                        map[nr][nc]=map[r][c]+1;
                    }

                }
                // 벽인 경우
                else {
                    // 벽을 부수지 않은 경우만 확인
                    // 벽을 부숴야 하기 때문에 1에 저장
                    if(!check && !visited[nr][nc][1]){
                        visited[nr][nc][1]=true;
                        q.offer(new Node(nr,nc,true));
                        map[nr][nc]=map[r][c]+1;
                    }
                }

            }

        }
        return -1;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = INF;
            }
        }
        visited = new boolean[N][M][2];
        q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }
        visited[0][0][0]=true;
        q.offer(new Node(0, 0, false));
        map[0][0] = 1;
    }

    private static class Node {
        int r;
        int c;
        boolean check;

        public Node(int r, int c, boolean check) {
            this.r = r;
            this.c = c;
            this.check = check;
        }
    }
}
