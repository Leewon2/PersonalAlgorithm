

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;

    static Node[] arr;
    static boolean[] check;
    static int dogMove;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(dog());
    }

    private static int dog() {
        int res = 0;
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (!check[i] && arr[i].dis == -1) {
                check[i] = true;
                q.offer(arr[i]);
                while (!q.isEmpty()) {
                    res++;
                    Node poll = q.poll();
                    int rr = poll.r;
                    int cc = poll.c;
                    for (int j = 0; j < N; j++) {
                        if (!check[j]) {
                            int r = arr[j].r;
                            int c = arr[j].c;
                            int distX = rr - r;
                            int distY = cc - c;
                            if (distX * distX + distY * distY <= dogMove * dogMove) {
                                arr[j].dis = -1;
                                check[j] = true;
                                q.offer(arr[j]);
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new Node[N];
        check = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new Node(x, y, -1);
        }

        st = new StringTokenizer(br.readLine());
        int[] tmp = new int[M];
        for (int i = 0; i < M; i++) {
            int x = Integer.parseInt(st.nextToken()) - 1;
            tmp[i] = x;
        }

        st = new StringTokenizer(br.readLine());
        dogMove = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            int x = Integer.parseInt(st.nextToken());
            arr[tmp[i]].dis = x;
            for (int j = 0; j < N; j++) {
                int r = arr[j].r;
                int c = arr[j].c;
                int distX = arr[tmp[i]].r - r;
                int distY = arr[tmp[i]].c - c;
                if (distX * distX + distY * distY <= x * x) {
                    arr[j].dis = x;
                }
            }
        }

    }

    private static class Node {
        int r;
        int c;
        int dis;

        public Node(int r, int c, int dis) {
            this.r = r;
            this.c = c;
            this.dis = dis;
        }
    }
}
