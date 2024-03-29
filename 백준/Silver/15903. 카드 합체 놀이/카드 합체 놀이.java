import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char[][] A;
    static char[][] B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.offer(Long.parseLong(st.nextToken()));
        }
        for (int i = 0; i < m; i++) {
            long x = pq.poll();
            long y = pq.poll();
            long k = x+y;
            pq.offer(k);
            pq.offer(k);
        }
        long sum=0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }
        System.out.println(sum);

    }

}

