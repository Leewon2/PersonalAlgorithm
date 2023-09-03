
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int dasom = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->o2-o1);
        for (int i = 0; i < N - 1; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }
        int res=0;

        while (!pq.isEmpty()) {
            int poll = pq.poll();
            if (poll < dasom) {
                break;
            }else{
                dasom++;
                pq.offer(poll - 1);
                res++;
            }
        }
        System.out.println(res);

    }
}
