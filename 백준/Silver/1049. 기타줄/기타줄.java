

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            pq1.offer(Integer.parseInt(st.nextToken()));
            pq2.offer(Integer.parseInt(st.nextToken()));
        }
        int x = pq1.poll();
        int y = pq2.poll();
        int k = N/6;
        int z = N%6;
        int res = Math.min((k+1) *x, k * x + y * z);
        res = Math.min(res, N*y);
        if (x == 0 || y == 0) {
            res=0;
        }
//        System.out.println(x);
//        System.out.println(y);
//        System.out.println(k);
//        System.out.println(z);

        System.out.println(res);

    }
}
