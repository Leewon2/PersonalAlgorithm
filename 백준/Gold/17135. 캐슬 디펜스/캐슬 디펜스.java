
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

    static int D;
    static boolean[] check;
    static int[][] copyArr;
    static Queue<Node> q;
    static boolean[][] visited;
    static boolean[][] isChange;
    static Queue<Node> copyQ;
    static int res;
    static boolean stop;
    static int sum;

    // 왼, 위, 오 순으로 진행
    static final int[] dr = {0, -1, 0};
    static final int[] dc = {-1, 0, 1};
    static int[] three;

    public static void main(String[] args) throws IOException {
        input();
        startPoint(0,0);
        System.out.println(res);
    }

    // 배열 복사
    private static void copy() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                copyArr[r][c] = arr[r][c];
            }
        }

    }

    private static void monsterDown() {
        // 마지막줄에 1 남아있는지 확인

//        for (int[] list : copyArr) {
//            System.out.println(Arrays.toString(list));
//        }
//        System.out.println(M+"*****");
        if (!stop) {
            for (int i = N - 1; i >= 1; i--) {
                for (int j = 0; j < M; j++) {
                    copyArr[i][j] = copyArr[i - 1][j];
                }
            }
            for (int i = 0; i < M; i++) {
                copyArr[0][i] = 0;
            }
        }

//        for (int[] list : copyArr) {
//            System.out.println(Arrays.toString(list));
//        }
//        System.out.println(M+"#####");

        // 아직 1이 남아 있는지 확인
        boolean isZero = false;
        outer:
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (copyArr[r][c] == 1) {
                    isZero = true;
                    break outer;
                }

            }
        }

        if (!isZero)
            stop = true;

    }

    private static void calculate() {

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (isChange[r][c]) {
                    sum++;
                    copyArr[r][c] = 0;
                }
            }
        }
    }

    private static void killMonster() {
        // 최대 D번 반복 가능
        isChange = new boolean[N][M];

        while (!copyQ.isEmpty()) {
            // System.out.println(1);
            Queue<Node> compareQ = new LinkedList<>();
            Node poll = copyQ.poll();
            compareQ.offer(poll);
            visited = new boolean[N][M];
            while (!compareQ.isEmpty()) {
                // System.out.println(compareQ.size());
                Node p = compareQ.poll();
                int r = p.r;
                int c = p.c;
                if (Math.abs(poll.r - r) + Math.abs(poll.c - c) > D)
                    break;
                if (r >= 0 && r < N && c >= 0 && c < M && copyArr[r][c] == 1) {
                    // 바뀌어야 하는 값 표시
                    isChange[r][c] = true;
                    compareQ.clear();
                    break;
                }
                for (int i = 0; i < 3; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc])
                        continue;
                    compareQ.offer(new Node(nr, nc));
                    visited[nr][nc] = true;

                }
            }
        }
        calculate();
    }

    private static void copyStartPoint() {
        copyQ = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            Node poll = q.poll();
            copyQ.offer(poll);
            q.offer(poll);
        }
    }

    // start point  정하기
    private static void startPoint(int idx, int start) {
        sum = 0;
        // 조합으로 결정
        // q 3개를 만들것인가.
        if (idx == 3) {

            stop = false;
            q = new LinkedList<>();
            for (int i = 0; i < idx; i++) {

//                System.out.print(three[i] + " ");
                // start point
                q.offer(new Node(N, three[i]));

            }
//            System.out.println();
            // 여기에 메서드 들어가야함
            copy();
            while (!stop) {
                copyStartPoint();
                killMonster();
                monsterDown();
            }
            res = Math.max(sum, res);
            return;
        }

        for (int i = start; i < M; i++) {
            three[idx] = i;
            startPoint(idx + 1, i + 1);

        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        check = new boolean[M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[N][M];
        isChange = new boolean[N][M];
        res = 0;
        stop = false;
        copyArr = new int[N][M];
        three = new int[3];

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