
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[] arr;
    static int[] point;
    static List<List<Integer>> list;
    static Queue<Integer> q;
    static int[] res;

    public static void main(String[] args) throws IOException {
        input();
        order();
        for (int i = 0; i < N; i++) {
            System.out.print(res[i]+" ");
        }
        

    }

    private static void order() {
        int idx = 0;
        while (!q.isEmpty()) {
            int poll = q.poll();
            res[idx++] = poll;
            for (int i = 0; i < list.get(poll).size(); i++) {
                int k = list.get(poll).get(i);
                point[k]--;
                if (point[k] == 0) {
                    q.offer(k);
                }
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        point = new int[N + 1];
        list = new ArrayList<>();
        q = new ArrayDeque<>();
        res = new int[N];
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.get(x).add(y);
            point[y]++;
        }
        for (int i = 1; i <= N; i++) {
            if (point[i] == 0) q.offer(i);
        }

    }
}
