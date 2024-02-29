import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int R;
    static int C;
    static char[][] arr;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static Queue<Node> jihoon;
    static Queue<Node> fire;
    static int[][] map;
    static boolean[][] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        map = new int[R][C];
        jihoon = new LinkedList<>();
        fire = new LinkedList<>();
        for (int r = 0; r < R; r++) {
            Arrays.fill(map[r],Integer.MAX_VALUE);
        }
        for (int r = 0; r < R; r++) {
            String str = br.readLine();
            for (int c = 0; c < C; c++) {
                arr[r][c] = str.charAt(c);
                if (arr[r][c] == 'J') {
                    jihoon.offer(new Node(r, c, 0));
                } else if (arr[r][c] == '#') {
                    map[r][c] = -1;
                }
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (arr[r][c] == 'F') {
                    fire.offer(new Node(r, c, 0));
                    map[r][c]=0;
                }
            }
        }
        fireBFS();
        int res = jihoonBFS();
        System.out.println(res==-1 ? "IMPOSSIBLE" : res+1);

    }

    private static int jihoonBFS() {
        visited = new boolean[R][C];
        while (!jihoon.isEmpty()) {
            Node poll = jihoon.poll();
            int r = poll.r;
            int c = poll.c;
            int cnt = poll.cnt;
            visited[r][c]=true;
            if(r==0 || c==0 || r==R-1 || c==C-1) return cnt;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr < 0 || nc < 0 || nr >= R || nc >= C || visited[nr][nc] || map[nr][nc]==-1) continue;
                if(map[nr][nc]>cnt+1){
                    jihoon.offer(new Node(nr, nc, cnt + 1));
                    visited[nr][nc]=true;
                }
            }
        }
        return -1;
    }

    private static void fireBFS() {
        visited = new boolean[R][C];
        while (!fire.isEmpty()) {
            Node poll = fire.poll();
            int r = poll.r;
            int c = poll.c;
            int cnt = poll.cnt;
            visited[r][c]=true;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr < 0 || nc < 0 || nr >= R || nc >= C || visited[nr][nc]) continue;
                if (arr[nr][nc] == '.' || arr[nr][nc]=='J') {
                    fire.offer(new Node(nr, nc, cnt + 1));
                    map[nr][nc] = Math.min(map[nr][nc],cnt + 1);
                    visited[nr][nc]=true;
                }
            }
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
