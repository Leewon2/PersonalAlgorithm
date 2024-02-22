
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        List<List<Node>> list = new ArrayList<>();
        boolean[] visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.get(x).add(new Node(x, y, cost));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.cost - o2.cost;
        });
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        visited[start] = true;
        for (int i = 0; i < list.get(start).size(); i++) {
            pq.offer(list.get(start).get(i));
        }
        while (!pq.isEmpty()) {
            Node poll = pq.poll();
            int s = poll.s;
            int e = poll.e;
            int cost = poll.cost;
//            System.out.println("s : " + s + " e : " + e + " cost : " + cost);
            if (e == end) {
                System.out.println(cost);
                break;
            }
            visited[s] = true;
            if (!visited[e]) {
                for (int i = 0; i < list.get(e).size(); i++) {
                    pq.offer(new Node(e,list.get(e).get(i).e,cost+list.get(e).get(i).cost));
                }
            }
        }


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
