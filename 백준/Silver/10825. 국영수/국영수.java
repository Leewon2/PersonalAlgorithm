

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node[] arr = new Node[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[i] = new Node(str, a, b, c);
        }
        Arrays.sort(arr, ((o1, o2) -> {
            if (o1.g != o2.g) {
                return o2.g - o1.g;
            } else if (o1.e != o2.e) {
                return o1.e - o2.e;
            } else if (o1.m != o2.m) {
                return o2.m - o1.m;
            } else {
               
                return o1.name.compareTo(o2.name);


            }
        }));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i].name).append("\n");
        }
        System.out.println(sb);
    }

    private static class Node {
        String name;
        int g;
        int e;
        int m;

        public Node(String name, int g, int e, int m) {
            this.name = name;
            this.g = g;
            this.e = e;
            this.m = m;
        }
    }
}
