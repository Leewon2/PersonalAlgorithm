

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static PriorityQueue<Node> pq;
    static Star[] arr;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        input();
        double res =0;

        while (!pq.isEmpty()) {
            Node poll = pq.poll();
            int s = poll.s;
            int e = poll.e;
            double dist = poll.dist;
            if (union(s, e)) {
                res+=dist;
            }
        }
        System.out.printf("%.2f", res);
    }

    private static int find(int x){
        if(parent[x]==x) return x;
        return find(parent[x]);
    }

    private static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x==y) return false;
        if(x<=y) parent[y]=x;
        else parent[x]=y;
        return true;
    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>((o1, o2) -> {
            return Double.compare(o1.dist, o2.dist);
        });

        arr = new Star[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            arr[i] = new Star(x,y);
        }
        parent = new int[N + 1];
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                pq.offer(new Node(i,j,calculateDistance(arr[i].x, arr[i].y, arr[j].x, arr[j].y)));
            }
        }
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
    }

    private static double calculateDistance(double r1, double c1, double r2, double c2) {
        return Math.sqrt(Math.pow(r1 - r2, 2) + Math.pow(c1 - c2, 2));
    }

    private static class Star{
        double x;
        double y;

        public Star( double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class Node {
        int s;
        int e;
        double dist;

        public Node(int s, int e, double dist) {
            this.s = s;
            this.e = e;
            this.dist = dist;
        }
    }

}
