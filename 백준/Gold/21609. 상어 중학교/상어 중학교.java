import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static final int[] dr = {1, 0, -1, 0};
    static final int[] dc = {0, 1, 0, -1};
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int rainbow = M + 1;
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int k = Integer.parseInt(st.nextToken());
                if (k == 0) k = rainbow;
                arr[i][j] = k;
            }
        }
        int sum = 0;
        while (true) {
            int k = findBigBlock();
            if (k == 0) break;
            sum += k;
            gravity();
            spinArr();
            gravity();
        }
        System.out.println(sum);
    }

    // 중력 작용
    private static void gravity() {
        // 하나의 열에 대해서
        for (int i = 0; i < N; i++) {
            // N-1번째 행부터 비교한다.
            int idx = N - 1;
            for (int j = N - 1; j >= 0; j--) {
                if (arr[j][i] != 0 && arr[j][i] != -1) {
                    if (idx != j) {
                        arr[idx][i] = arr[j][i];
                        arr[j][i] = 0;
                    }
                    idx--;
                } else if (arr[j][i] == -1) {
                    idx = j - 1;
                }
            }
        }
    }

    private static void spinArr(){
        // 맨 오른쪽 열 한줄은, 맨 첫번째 행이 된다
        int[][] subArr = new int[N][N];
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                subArr[N-1-i][j] = arr[j][i];
            }
        }
        for (int i = 0; i < N; i++) {
            arr[i] = Arrays.copyOf(subArr[i], subArr[0].length);
        }
    }

    // 찾을 수 있는 크기가 가장 큰 블록을 찾아보자.
    private static int findBigBlock() {
        PriorityQueue<Block> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.size != o2.size) {
                return o2.size - o1.size;
            } else if (o1.rainbowCnt != o2.rainbowCnt) {
                return o2.rainbowCnt - o1.rainbowCnt;
            } else if (o1.r != o2.r) {
                return o2.r - o1.r;
            }
            return o2.c - o1.c;
        });
        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] || arr[i][j] == 0 || arr[i][j] == -1 || arr[i][j]==M+1) continue;
                int num = arr[i][j];
                visited[i][j] = true;
                Block block = BFS(i, j, num, visited);
                if (block != null) {
                    pq.offer(block);
                }
            }
        }
        if (pq.isEmpty()) return 0;
        Block poll = pq.poll();
        removeBlock(poll.r, poll.c);
        return poll.size * poll.size;
    }

    // 블록 제거
    private static void removeBlock(int r, int c) {
        int num = arr[r][c];
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited2 = new boolean[N][N];
        visited2[r][c] = true;
        q.offer(new Node(r, c));
        while (!q.isEmpty()) {
            Node poll = q.poll();
            arr[poll.r][poll.c] = 0;
            for (int i = 0; i < 4; i++) {
                int nr = poll.r + dr[i];
                int nc = poll.c + dc[i];
                if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited2[nr][nc])
                    continue;
                if(arr[nr][nc] == M+1 || arr[nr][nc]==num){
                    visited2[nr][nc] = true;
                    q.offer(new Node(nr, nc));
                }
            }
        }
    }

    private static Block BFS(int r, int c, int num, boolean[][] visited) {
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited2 = new boolean[N][N];
        visited2[r][c] = true;
        q.offer(new Node(r, c));
        int rainbowCnt = 0;
        int size = 0;
        while (!q.isEmpty()) {
            Node poll = q.poll();
            size++;
            for (int i = 0; i < 4; i++) {
                int nr = poll.r + dr[i];
                int nc = poll.c + dc[i];
                if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited2[nr][nc])
                    continue;
                if(arr[nr][nc] == M+1 || arr[nr][nc]==num){
                    visited2[nr][nc] = true;
                    visited[nr][nc] = true;
                    if (arr[nr][nc] == M + 1) rainbowCnt++;
                    q.offer(new Node(nr, nc));
                }
            }

        }
        if (size >= 2) {
            return new Block(size, rainbowCnt, r, c);
        }
        return null;
    }

    private static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static class Block {
        int size;
        int rainbowCnt;
        int r;
        int c;

        public Block(int size, int rainbowCnt, int r, int c) {
            this.size = size;
            this.rainbowCnt = rainbowCnt;
            this.r = r;
            this.c = c;
        }
    }
}
