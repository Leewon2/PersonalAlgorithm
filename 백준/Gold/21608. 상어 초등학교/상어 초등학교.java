import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static int[][] num;
    static final int[] dr = {1, -1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};
    static Map<Integer, List<Integer>> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        num = new int[N * N][5];
        map = new HashMap<>();
        for (int i = 0; i < N * N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            num[i][0] = Integer.parseInt(st.nextToken());
            List<Integer> list = new ArrayList<>();
            for (int j = 1; j < 5; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
                list.add(num[i][j]);
            }
            map.put(num[i][0], list);
        }
        for (int i = 0; i < N * N; i++) {
            firstCondition(i);
        }
        System.out.println(calculate());
    }

    private static int calculate(){
        int res=0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                List<Integer> list = map.get(arr[i][j]);
                int cnt=0;
                for (int d = 0; d < 4; d++) {
                    int nr = i+dr[d];
                    int nc = j+dc[d];
                    if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
                    if(list.contains(arr[nr][nc])) cnt++;
                }
                if(cnt==0) res+=0;
                else if(cnt==1) res+=1;
                else if(cnt==2) res+=10;
                else if(cnt==3) res+=100;
                else res+=1000;
            }
        }

        return res;
    }

    private static void firstCondition(int idx) {
        int[][] compare = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(compare[i], -1);
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] != 0) continue;
                compare[i][j] = 0;
                for (int d = 0; d < 4; d++) {
                    int nr = i + dr[d];
                    int nc = j + dc[d];
                    if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                    for (int k = 1; k <= 4; k++) {
                        if (arr[nr][nc] == num[idx][k]) {
                            compare[i][j]++;
                        }
                    }
                }
                max = Math.max(max,compare[i][j]);
            }
        }
        Queue<Node> q = new LinkedList<>();

        // 인접한 칸에 가장 많은 애들 큐에 담기
        offerQueue(q, compare, max);

        // 위 조건을 만족하면, 비어있는 칸이 많은 쪽으로
        if (checkQueueSize(q, idx)) {
            secondCondition(q,idx);
        }

    }

    // 비어있는 칸 갯수 확인
    private static void secondCondition(Queue<Node> q, int idx) {
        int max = 0;
        int[][] compare = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(compare[i], -1);
        }

        while (!q.isEmpty()) {
            Node poll = q.poll();
            compare[poll.r][poll.c] = 0;
            for (int d = 0; d < 4; d++) {
                int nr = poll.r + dr[d];
                int nc = poll.c + dc[d];
                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if (arr[nr][nc] == 0) compare[poll.r][poll.c]++;
            }
            max = Math.max(max, compare[poll.r][poll.c]);
        }
        offerQueue(q, compare, max);
        if(checkQueueSize(q, idx)){
            Node poll = q.poll();
            arr[poll.r][poll.c] = num[idx][0];
        }

    }

    private static void offerQueue(Queue<Node> q, int[][] compare, int max) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (compare[i][j] == max) {
                    q.offer(new Node(i, j));
                }
            }
        }
    }

    private static boolean checkQueueSize(Queue<Node> q, int idx) {
        if (q.size() > 1) {
            return true;
        } else {
            Node poll = q.poll();
            arr[poll.r][poll.c] = num[idx][0];
        }
        return false;
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
