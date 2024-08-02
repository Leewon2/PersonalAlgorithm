import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }
        st.nextToken();
        for (int i = 1; i < N; i++) {
            list.get(Integer.parseInt(st.nextToken())).add(i);
        }
        System.out.println(DFS(0,list));
    }
    private static int DFS(int p, List<List<Integer>> list){
        int cnt = 0;
        int max = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2-o1);
        for (int next : list.get(p)) {
            int count = DFS(next, list);
            pq.offer(count);
        }
        while (!pq.isEmpty()) {
            cnt++;
            max = Math.max(max, pq.poll() + cnt);
        }
        return max;
    }
}
