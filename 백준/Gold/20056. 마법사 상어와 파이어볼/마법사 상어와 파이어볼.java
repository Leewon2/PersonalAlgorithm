import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, K;
    static List<Integer>[][] arr;
    static Map<Integer, Node> map;
    static final int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static final int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    static int idx;
    static boolean[] use;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = new ArrayList<>();
            }
        }
        map = new HashMap<>();
        idx = 0;
        use = new boolean[50000000];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            map.put(idx++, new Node(r, c, m, s, d));
        }
        int res=0;
        for (int i = 0; i < K; i++) {
            move();
            sum();
        }
        for (int i = 0; i < idx; i++) {
            if(use[i]) continue;
            res += map.get(i).m;
        }
        System.out.println(res);
    }

    // 이동
    private static void move() {
        for (int i = 0; i < idx; i++) {
            if (use[i]) continue;
            Node node = map.get(i);
//            arr[node.r][node.c].remove(Integer.valueOf(i));
            int nr = (node.r + dr[node.d]*((node.s)%N) + N) % N;
            int nc = (node.c + dc[node.d]*((node.s)%N) + N) % N;
            map.put(i, new Node(nr, nc, node.m, node.s, node.d));
            arr[nr][nc].add(i);
        }
    }
    private static void sum(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(arr[i][j].size()<2){
                    arr[i][j] = new ArrayList<>();
                    continue;
                }
                // 질량
                int weight=0;
                int speed=0;
                int dir = map.get(arr[i][j].get(0)).d%2;
                boolean check = true;
                for (int k = 0; k < arr[i][j].size(); k++) {
                    weight += map.get(arr[i][j].get(k)).m;
                    speed += map.get(arr[i][j].get(k)).s;
                    if(dir != map.get(arr[i][j].get(k)).d %2) check = false;
                    // 합쳐진것은 소멸
                    use[arr[i][j].get(k)] = true;
                }
                weight /=5;
                speed /= arr[i][j].size();
                if (weight != 0) {
                    // true이면 0246
                    int start = 0 ;
                    if(!check) {
                        start=1;
                    }
                    for (int l = start; l < 8; l += 2) {

                        map.put(idx++, new Node(i, j, weight, speed, l));
                    }
                }
                // 0이 되거나 합쳐졌을 때 use를 사용으로 바꿔준다.
                arr[i][j] = new ArrayList<>();
            }
        }
    }

    private static class Arr {
        List<Integer> list;

        public Arr(List<Integer> list) {
            this.list = list;
        }
    }

    private static class Node {
        int r;
        int c;
        int m;
        int s;
        int d;

        public Node(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
}
