

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[][] visited = new boolean[N][M];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cnt = 0;
        Queue<Node> q = new ArrayDeque<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int r = x1; r < x2; r++) {
                for (int c = y1; c < y2; c++) {
                    visited[r][c] = true;
                }
            }

        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if(!visited[r][c]){
                    int count =0;
                    q.offer(new Node(r, c));
                    while (!q.isEmpty()) {
                        count++;
                        Node poll = q.poll();
                        int row = poll.r;
                        int col = poll.c;
                        visited[row][col] = true;
                        for (int i = 0; i < 4; i++) {
                            int nr = row + dr[i];
                            int nc = col + dc[i];
                            if(nr<0 || nc<0 || nr>=N || nc>=M || visited[nr][nc]) continue;
                            visited[nr][nc]=true;
                            q.offer(new Node(nr, nc));
                        }
                    }

                    pq.offer(count);
                    cnt++;
                }
            }

        }

        System.out.println(cnt);
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append(" ");
        }
        System.out.println(sb);
    }


    private static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
