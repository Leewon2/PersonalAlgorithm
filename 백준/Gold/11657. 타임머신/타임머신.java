
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.add(new Node(s, e, cost));
        }
        long[] dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;
        for (int i = 1; i <= N; i++) {
            for (Node l : list) {
                if (dist[l.s] != Long.MAX_VALUE) {
                    if (dist[l.e] > dist[l.s] + l.cost) {
                        dist[l.e] = dist[l.s] + l.cost;
                        if (i == N) {
                            System.out.println(-1);
                            System.exit(0);
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            if (dist[i] == Long.MAX_VALUE) sb.append(-1).append("\n");
            else sb.append(dist[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean checkCycle(long[] dist, int N, List<Node> list) {
        for (int i = 2; i <= N; i++) {
            if (dist[i] != Long.MAX_VALUE && dist[list.get(i - 2).e] > dist[list.get(i - 2).s] + list.get(i - 2).cost)
                return false;
        }
        return true;
    }

    private static class Node {
        int s;
        int e;
        int cost;

        public Node(int s, int e, int cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }
    }
}
