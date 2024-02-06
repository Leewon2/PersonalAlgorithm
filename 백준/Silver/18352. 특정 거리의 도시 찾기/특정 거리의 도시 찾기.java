

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.get(x).add(y);
//            list.get(y).add(x);
        }
        boolean[] visited = new boolean[N + 1];
        visited[X] = true;
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(X, 0));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (!q.isEmpty()) {
            Node poll = q.poll();
            if (poll.cnt == K) pq.offer(poll.number);
            for (int i = 0; i < list.get(poll.number).size(); i++) {
                if (!visited[list.get(poll.number).get(i)]) {
                    visited[list.get(poll.number).get(i)] = true;
                    if (poll.cnt + 1 <= K) {
                        q.offer(new Node(list.get(poll.number).get(i), poll.cnt + 1));
                    }
                }
            }

        }
        if (pq.isEmpty()) System.out.println(-1);
        else {
            while (!pq.isEmpty()) {
                sb.append(pq.poll()).append("\n");
            }
            System.out.println(sb);
        }

    }

    private static class Node {
        int number;
        int cnt;

        public Node(int number, int cnt) {
            this.number = number;
            this.cnt = cnt;
        }
    }


}
