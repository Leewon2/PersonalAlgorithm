import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] arr;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static ArrayList<Node> compare;
    static int[] direction;
    static int cnt;
    static Queue<Node> q;
    static int[][] compareArr;
    static int res;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        q = new LinkedList<>();
        compare = new ArrayList<>();
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
                if (arr[r][c] >= 1 && arr[r][c] <= 4) {
                    cnt++;
                    compare.add(new Node(r, c, arr[r][c]));
                } else if (arr[r][c] == 5) q.offer(new Node(r, c, 0));
            }
        }
        res=Integer.MAX_VALUE;
        direction = new int[cnt];

        // 5는 그냥 바로 없애버리기
        while (!q.isEmpty()) {
            Node poll = q.poll();
            int r = poll.r;
            int c = poll.c;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                while (nr >= 0 && nc >= 0 && nr < N && nc < M && arr[nr][nc] != 6) {
                    if (arr[nr][nc] == 0)
                        arr[nr][nc] = 10;
                    nr += dr[i];
                    nc += dc[i];
                }
            }
        }
        perm(0);
        System.out.println(res);

    }

    private static void CCTV(Node node, int d) {
        int num = node.num;
        if (num == 1) {
            if(d==0) Watch(node, 0);
            else if(d==1) Watch(node, 1);
            else if(d==2) Watch(node, 2);
            else if(d==3) Watch(node, 3);
        }else if(num ==2){
            if(d==0 || d==1){
                Watch(node,0);
                Watch(node,1);
            }else{
                Watch(node,2);
                Watch(node,3);
            }
        } else if (num == 3) {
            if(d==0){
                Watch(node,0);
                Watch(node,2);
            }else if(d==1){
                Watch(node,0);
                Watch(node,3);
            }
            else if(d==2){
                Watch(node,1);
                Watch(node,3);
            }
            else if(d==3){
                Watch(node,1);
                Watch(node,2);
            }
        }else{
            if(d==0){
                Watch(node,0);
                Watch(node, 1);
                Watch(node,2);
            }else if(d==1){
                Watch(node,0);
                Watch(node, 1);
                Watch(node,3);
            }
            else if(d==2){
                Watch(node,0);
                Watch(node, 3);
                Watch(node,2);
            }
            else if(d==3){
                Watch(node,3);
                Watch(node, 1);
                Watch(node,2);
            }
        }
    }

    private static void calcualte(){
        int count=0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(compareArr[i][j]==0) count++;
            }
        }
        res = Math.min(res, count);

    }

    private static void Watch(Node node, int d) {
        q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        q.offer(node);
        visited[node.r][node.c] = true;
        while (!q.isEmpty()) {
            Node poll = q.poll();
            int r = poll.r;
            int c = poll.c;
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr <0 || nr>=N || nc<0 || nc>=M || compareArr[nr][nc]==6) continue;
            if(compareArr[nr][nc]==0){
                compareArr[nr][nc] = 10;
                q.offer(new Node(nr, nc, node.num));
            }else{
                q.offer(new Node(nr, nc, node.num));
            }
        }
    }

    private static void perm(int idx) {
        if (idx == cnt) {
            compareArr = new int[N][M];
            for (int i = 0; i < N; i++) {
                compareArr[i] = arr[i].clone();
            }
            for (int i = 0; i < compare.size(); i++) {
                CCTV(compare.get(i), direction[i]);
            }
            calcualte();

            return;
        }

        for (int i = 0; i < 4; i++) {
            direction[idx] = i;
            perm(idx + 1);
        }

    }

    private static class Node {
        int r;
        int c;
        int num;

        public Node(int r, int c, int num) {
            this.r = r;
            this.c = c;
            this.num = num;
        }
    }
}
