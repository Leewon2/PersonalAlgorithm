import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dr ={1,0,-1,0};
    static int[] dc ={0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max=0;
        int cnt=0;
        Queue<Node> q = new LinkedList<>();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if(arr[r][c]==1 && !visited[r][c]){
                    q.offer(new Node(r,c));
                    visited[r][c]=true;
                    int count=0;
                    while (!q.isEmpty()) {
                        Node poll = q.poll();
                        count++;
                        for (int i = 0; i < 4; i++) {
                            int nr = poll.r+dr[i];
                            int nc = poll.c+dc[i];
                            if(nr<0 || nc<0 || nr>=n || nc>=m) continue;
                            if(!visited[nr][nc] && arr[nr][nc]==1){
                                q.offer(new Node(nr, nc));
                                visited[nr][nc]=true;
                            }
                        }

                    }
                    cnt++;
                    max = Math.max(max, count);
                }
            }
        }
        System.out.println(cnt);
        System.out.println(max);
    }
    private static class Node{
        int r;
        int c;
        public Node(int r, int c){
            this.r=r;
            this.c=c;
        }
    }
}
