

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
    static final int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int N;
    static int M;
    static int K;

    // 겨울 양분
    static int[][] winterMap;

    // 나무
    static PriorityQueue<Integer>[][] tree;

    // 양분 저장
    static int[][] map;

    public static void main(String[] args) throws IOException {
        input();
        while (K-- > 0) {
            springAndSummer();
            fall();
            winter();
        }
        int res=0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                res+=tree[r][c].size();
            }
        }
        System.out.println(res);

    }

    // 봄 & 여름
    private static void springAndSummer() {
        // 나무가 자신의 나이만큼 양분을 먹고 나이가 1 증가.
        // 양분이 부족하면 죽음
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                // 임시 q 하나 생성
                Queue<Integer> q = new LinkedList<>();
                // 여름에 양분될 녀석 저장
                int sum = 0;
                while (!tree[r][c].isEmpty()) {

                    int k = tree[r][c].poll();
                    // 현재 map 의 양분보다 나이가 적으면 1 증가
                    if (map[r][c] >= k) {
                        // 양분 빼먹기
                        map[r][c] -= k;
                        q.offer(k + 1);
                    } else {
                        sum += k / 2;
                    }
                }
                // 끝나면 q에 있던거 옮기기
                while (!q.isEmpty()) {
                    tree[r][c].offer(q.poll());
                }
                // 양분 옮기기
                map[r][c] += sum;
            }
        }
    }


    // 가을
    private static void fall() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                // 5의 배수가 여러개면 여러개 추가하는 것 먼저 구현
                Queue<Integer> q = new LinkedList<>();
                while (!tree[r][c].isEmpty()) {
                    int k = tree[r][c].poll();
                    q.offer(k);
                    if (k % 5 == 0) {
                        for (int i = 0; i < 8; i++) {
                            int nr = r + dr[i];
                            int nc = c + dc[i];
                            if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                            tree[nr][nc].offer(1);
                        }
                    }
                }
                while (!q.isEmpty()) {
                    tree[r][c].offer(q.poll());
                }
            }
        }

    }


    // 겨울
    private static void winter() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                map[r][c] += winterMap[r][c];
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        winterMap = new int[N][N];
        tree = new PriorityQueue[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                tree[r][c] = new PriorityQueue<>();
            }
        }
        map = new int[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                map[r][c] = 5;
            }
        }

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                winterMap[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());
            tree[x][y].offer(z);
        }

    }
}
