

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static List<Node>[] list;
    static int length;
    static boolean[] check;
    static int number;


    public static void main(String[] args) throws IOException {
        input();

        findFar(1, 0, true);


        check = new boolean[N + 1];
        findFar(number, 0, true);

        System.out.println(length);
    }

    private static void findFar(int idx, int size, boolean c) {
        check[idx] = true;
//        System.out.println("idx : "+idx+" size : "+size);
        if (!c) {
            if (length < size) {
                length = size;
                number = idx;
            }
            return;
        }

        for (int i = 0; i < list[idx].size(); i++) {
            Node node = list[idx].get(i);
//            System.out.println(node.child);
            if (!check[node.child]) {
//                check[node.child] = true;
                findFar(node.child, size + node.len, true);
//                check[node.child] = false;
            } else {
                findFar(idx, size, false);
            }

        }
    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new List[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            list[parent].add(new Node(child, len));
            list[child].add(new Node(parent, len));
        }
        check = new boolean[N + 1];
        length = 0;
    }

    private static class Node {
        int child;
        int len;

        public Node(int child, int len) {
            this.child = child;
            this.len = len;
        }
    }
}
