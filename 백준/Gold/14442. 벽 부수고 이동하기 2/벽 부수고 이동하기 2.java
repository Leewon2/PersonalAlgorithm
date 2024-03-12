import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M,K;
    static int[][] arr;
    static Queue<Node> q;
    static int[] dr={1,0,-1,0};
    static int[] dc={0,1,0,-1};
    static boolean[][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[K+1][N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        q = new LinkedList<>();
        q.offer(new Node(0, 0, 1,0));
        visited[0][0][0] = true;
        int result = bfs();
        System.out.println(result==Integer.MAX_VALUE ? -1 : result);


    }
    private static int bfs(){
        int res=Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Node poll = q.poll();
            int r = poll.r;
            int c = poll.c;
            int cnt = poll.cnt;
            int wall = poll.wall;
            if(r==N-1 && c==M-1){
                return cnt;
//                res = Math.min(res,cnt);
//                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nr = r+dr[i];
                int nc = c+dc[i];
                if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
                // 그냥 갈 수 있는 경우
                if(arr[nr][nc]==0 && !visited[wall][nr][nc]){
                    q.offer(new Node(nr, nc, cnt + 1, wall));
                    visited[wall][nr][nc] = true;
                }
                // 벽인 경우
                else{
                    // 갯수 다 안채웠으면 벽 깨고 이동
                    if(wall<K && !visited[wall+1][nr][nc]){
                        q.offer(new Node(nr, nc, cnt + 1, wall + 1));
                        visited[wall+1][nr][nc] = true;
                    }
                }
            }
        }
        return res;
    }


    private static class Node {
        int r;
        int c;
        int cnt;
        int wall;

        public Node(int r, int c, int cnt, int wall) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.wall = wall;
        }
    }
}
