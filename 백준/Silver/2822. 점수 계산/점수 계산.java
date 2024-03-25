import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Number> pq = new PriorityQueue<>((o1, o2) -> {
           return o2.num-o1.num;
        });
        for (int i = 1; i <= 8; i++) {
            pq.offer(new Number(Integer.parseInt(br.readLine()),i));
        }
        int[] res = new int[5];
        int sum=0;
        for (int i = 0; i < 5; i++) {
            Number number = pq.poll();
            res[i] = number.idx;
            sum+= number.num;
        }
        Arrays.sort(res);
        System.out.println(sum);
        for (int i = 0; i < 5; i++) {
            System.out.print(res[i]+" ");
        }
    }
    private static class Number{
        int num;
        int idx;

        public Number(int num, int idx) {
            this.idx=idx;
            this.num = num;
        }
    }
}
