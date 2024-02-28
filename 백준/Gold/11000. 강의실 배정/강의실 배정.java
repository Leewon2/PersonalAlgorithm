import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.s == o2.s) {
                return o1.e - o2.e;
            }
            return o1.s - o2.s;
        });
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            pq.offer(new Node(s, e));
        }

        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        pq2.offer(pq.poll().e);
        while (!pq.isEmpty()) {
            if (pq.peek().s >= pq2.peek()) {
                pq2.poll();
            }
            pq2.offer(pq.poll().e);
        }
        System.out.println(pq2.size());

    }

    private static class Node {
        int s;
        int e;

        public Node(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
}
