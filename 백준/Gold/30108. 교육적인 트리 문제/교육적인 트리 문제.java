

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Long, ArrayList<Long>> map = new HashMap<>();

        for (long i = 2; i < N + 1; i++) {
            Long x = Long.parseLong(st.nextToken());

            if (!map.containsKey(x)) {
                map.put(x, new ArrayList<>());
            }
            map.get(x).add(i);
        }

        // 내림차순 pq 정렬
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> {
            if (n2.c > n1.c) return 1;
            if (n2.c < n1.c) return -1;
            return 0;
        });

        StringBuilder sb = new StringBuilder();
        Node[] arr = new Node[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            Long k = Long.parseLong(st.nextToken());
            // i번째 수는 k의 값을 가짐
            arr[i] = new Node(i, k);
        }

        // 1번 정점은 무조건 선택
        long sum = arr[1].c;
        sb.append(arr[1].c).append("\n");
        if (map.get(1L) != null) {
            for (int i = 0; i < map.get(1L).size(); i++) {
                pq.offer(arr[map.get(1L).get(i).intValue()]);
            }
        }

        // 2번 정점부터 이제 확인해야하는데,,, 큰 수부터 꺼내자.
        for (int i = 2; i <= N; i++) {
            Node poll = pq.poll();
            sum += poll.c;
            sb.append(sum).append("\n");
            if (map.get(poll.r) != null) {
                for (int j = 0; j < map.get(poll.r).size(); j++) {
                    pq.offer(arr[map.get(poll.r).get(j).intValue()]);
                }
            }
        }

        System.out.println(sb);
    }

    private static class Node {
        long r;
        long c;

        public Node(long r, long c) {
            this.r = r;
            this.c = c;
        }
    }
}
