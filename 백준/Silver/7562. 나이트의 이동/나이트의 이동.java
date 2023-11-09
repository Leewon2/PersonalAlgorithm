

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final int[] dr = {-2,-2,-1,1,2,2,1,-1};
    static final int[] dc = {-1,1,2,2,1,-1,-2,-2};
    static boolean[][] visited;
    static int endR;
    static int endC;
    static Queue<Node> q;
    static Queue<Node> q2;
    static int cnt;
    static int[][] arr;
    static boolean check;


    static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < tc; t++) {
            q = new LinkedList<>();
            q2 = new LinkedList<>();
            size = Integer.parseInt(br.readLine());
            int[][] arr = new int[size][size];
            visited = new boolean[size][size];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            visited[x][y] = true;
            q2.offer(new Node(x,y));
            st = new StringTokenizer(br.readLine());
            endR = Integer.parseInt(st.nextToken());
            endC = Integer.parseInt(st.nextToken());
            cnt=0;
            check=false;
            if(x!=endR || y!=endC)
            bfs();
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
    private static int bfs(){
        while(!check){
            if(q2.isEmpty()){
                cnt=0;
                break;
            }

            while(!q2.isEmpty()) {
                q.offer(q2.poll());
            }
            while (!check && !q.isEmpty()) {
                check = bfs2();
            }
            cnt++;

        }
        return cnt;
    }

    private static boolean bfs2() {
        Node poll = q.poll();
        int row = poll.r;
        int col = poll.c;

        for (int i = 0; i < 8; i++) {
            int nr = row+dr[i];
            int nc = col+dc[i];
            if(nr==endR && nc ==endC) return true;
            if (nr < 0 || nc < 0 || nr >= size || nc >= size) {
                continue;
            }

            if(!visited[nr][nc]){
                q2.offer(new Node(nr, nc));
                visited[nr][nc]=true;
            }
        }
        return false;

    }

    public static class Node{
        int r;
        int c;
        public Node(int r, int c){
            this.r=r;
            this.c=c;
        }
    }
}
