import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Number> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            deque.offerLast(new Number(Integer.parseInt(st.nextToken()),i+1));
        }
        StringBuilder sb = new StringBuilder();
        int start = deque.pollFirst().num;
        sb.append(1).append(" ");
        while (!deque.isEmpty()) {
            Number k;
            if (start < 0) {
                while(start<-1){
                    deque.offerFirst(deque.pollLast());
                    start++;
                }
                k = deque.pollLast();
                start = k.num;
            }else{
                while(start>1){
                    deque.offerLast(deque.pollFirst());
                    start--;
                }
                k = deque.pollFirst();
                start = k.num;
            }
            
            sb.append(k.idx).append(" ");
        }
        System.out.println(sb);

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
