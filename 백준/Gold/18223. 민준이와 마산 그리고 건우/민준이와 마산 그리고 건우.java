import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int V, E, P;
    static List<List<Node>> list;
    static int[] dist;
    static PriorityQueue<Node> pq;
    static int GeonWoo;
    static int endPoint;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new ArrayList<>();
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= V; i++) {
            list.add(new ArrayList<>());
        }
        GeonWoo = Integer.MAX_VALUE;
        endPoint = Integer.MAX_VALUE;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            list.get(x).add(new Node(y, d));
            list.get(y).add(new Node(x, d));
        }
        findLoad(1,V);
        endPoint = dist[V];
        if(dist[P]==Integer.MAX_VALUE){
            System.out.println("GOOD BYE");
        }else{
            GeonWoo = dist[P];
            findLoad(P, V);
            if (dist[V] != Integer.MAX_VALUE) {
                GeonWoo += dist[V];
                if (GeonWoo == endPoint) {
                    System.out.println("SAVE HIM");
                } else {
                    System.out.println("GOOD BYE");
                }
            } else {
                System.out.println("GOOD BYE");
            }
        }
    }

    private static void findLoad(int start, int end) {
        dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq = new PriorityQueue<>((o1, o2) -> {
            return o1.d - o2.d;
        });
        for (int i = 0; i < list.get(start).size(); i++) {
            pq.offer(new Node(list.get(start).get(i).x, list.get(start).get(i).d));
            dist[list.get(start).get(i).x] = list.get(start).get(i).d;
        }

        boolean[] visited = new boolean[V + 1];
        dist[start] = 0;
        visited[start] = true;
        while (!pq.isEmpty()) {
            Node poll = pq.poll();
            if (visited[poll.x]) continue;
            visited[poll.x] = true;
            int x = poll.x;
            for (int i = 0; i < list.get(x).size(); i++) {
                if (dist[list.get(x).get(i).x] == Integer.MAX_VALUE || dist[list.get(x).get(i).x] > dist[x] + list.get(x).get(i).d) {
                    pq.offer(new Node(list.get(x).get(i).x, list.get(x).get(i).d));
                    dist[list.get(x).get(i).x] = dist[x] + list.get(x).get(i).d;
                }
            }
        }
    }


    private static class Node {
        int x;
        int d;

        public Node(int x, int d) {
            this.x = x;
            this.d = d;
        }
    }
}
