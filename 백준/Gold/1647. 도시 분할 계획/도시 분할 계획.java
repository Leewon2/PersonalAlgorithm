

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    /* MST를 이용해 최소 거리를 찾는다.
    최소 거리 중 가장 긴 유지비는 삭제한다.
    * */
    static int N, M;
    static int[] parent;
    static PriorityQueue<Node> q;

    public static void main(String[] args) throws IOException {
        input();
        int max=0;
        int result=0;
        while (!q.isEmpty()) {
            Node poll = q.poll();
            int x = poll.x;
            int y = poll.y;
            int dist = poll.dist;
            if(union(x,y)) {
                result+=dist;
                max = Math.max(max, dist);
            }
        }
        System.out.println(result-max);
    }

    private static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return false;

        if (x <= y) parent[y] = x;
        else parent[x] = y;
        return true;
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return find(parent[x]);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        q = new PriorityQueue<>((o1, o2) -> {
            return Long.compare(o1.dist, o2.dist);
        });
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            q.offer(new Node(x, y, dist));
        }

        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }
    }

    private static class Node {
        int x;
        int y;
        int dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
