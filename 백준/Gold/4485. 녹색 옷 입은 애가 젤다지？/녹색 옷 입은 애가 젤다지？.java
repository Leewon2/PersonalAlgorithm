
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static int[][] compare;
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    static Queue<Node> q;
    public static void main(String[] args) throws IOException {
        System.out.println(input());
    }

    private static void bfs(){
        while (!q.isEmpty()) {
            Node poll = q.poll();
            int r = poll.r;
            int c = poll.c;
            for (int i = 0; i < 4; i++) {
                int nr = r+dr[i];
                int nc = c+dc[i];
                if(nr<0||nc<0||nr>=N||nc>=N) continue;
                if(compare[nr][nc]>compare[r][c]+arr[nr][nc]){
                    compare[nr][nc] = compare[r][c]+arr[nr][nc];
                    q.offer(new Node(nr,nc));
                }
            }
        }
    }

    private static StringBuilder input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int idx=0;
        while(true) {
            idx++;
            N = Integer.parseInt(br.readLine());
            if(N==0) break;
            q = new ArrayDeque<>();
            arr = new int[N][N];
            compare = new int[N][N];
            for (int r = 0; r < N; r++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int c = 0; c < N; c++) {
                    arr[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < N; i++) {
                Arrays.fill(compare[i],Integer.MAX_VALUE);
            }
            q.offer(new Node(0, 0));
            compare[0][0]=arr[0][0];
            bfs();
            sb.append("Problem ").append(idx).append(": ").append(compare[N - 1][N - 1]).append("\n");

        }
        return sb;
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
