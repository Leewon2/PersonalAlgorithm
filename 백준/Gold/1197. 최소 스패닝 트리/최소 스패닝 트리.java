

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int V, E;
    static PriorityQueue<Node> q;

    static long[] parent;

    public static void main(String[] args) throws IOException {
        input();
        long result = 0;
        while (!q.isEmpty()) {
            Node poll = q.poll();
            int x = poll.x;
            int y = poll.y;
            long dist = poll.dist;
            if (union(x, y)) result += dist;
        }
//        System.out.println(Arrays.toString(parent));
        System.out.println(result);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        q = new PriorityQueue<>(((o1, o2) -> {
            return Long.compare(o1.dist, o2.dist);
        }));
        parent = new long[V + 1];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            long dist = Long.parseLong(st.nextToken());
            q.offer(new Node(x, y, dist));
        }
        for (int i = 0; i <= V; i++) {
            parent[i] = i;
        }
    }

    private static long find(long x) {
        if (parent[(int) x] == x) return x;
        return find(parent[(int) x]);
    }

    private static boolean union(long x, long y) {
        x = find(x);
        y = find(y);
        if (x == y) return false;

        if (x <= y) parent[(int) y] = x;
        else parent[(int) x] = y;
        return true;
    }

    private static class Node {
        int x;
        int y;
        long dist;

        public Node(int x, int y, long dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

}
