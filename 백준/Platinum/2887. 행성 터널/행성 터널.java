import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[] parent;
    static PriorityQueue<Node> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Planet[] planet = new Planet[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            planet[i] = new Planet(i, x, y, z);
        }
        pq = new PriorityQueue<>((o1, o2) -> {
            return o1.dist - o2.dist;
        });

        Arrays.sort(planet,(o1,o2)->{
            return o1.x-o2.x;
        });
        for (int i = 0; i < N - 1; i++) {
            pq.offer(new Node(planet[i].idx,planet[i+1].idx, Math.abs(
                    planet[i].x-planet[i+1].x)));
        }
        Arrays.sort(planet,(o1,o2)->{
            return o1.y-o2.y;
        });
        for (int i = 0; i < N - 1; i++) {
            pq.offer(new Node(planet[i].idx,planet[i+1].idx, Math.abs(
                    planet[i].y-planet[i+1].y)));
        }
        Arrays.sort(planet,(o1,o2)->{
            return o1.z-o2.z;
        });
        for (int i = 0; i < N - 1; i++) {
            pq.offer(new Node(planet[i].idx,planet[i+1].idx, Math.abs(
                    planet[i].z-planet[i+1].z)));
        }

        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        int res=0;
        while (!pq.isEmpty()) {
            Node poll = pq.poll();
            if(union(poll.x,poll.y)){
                res+=poll.dist;
            }
        }
        System.out.println(res);

    }

    private static int find(int x){
        if(parent[x]==x) return x;
        return find(parent[x]);
    }

    private static boolean union(int x, int y){
        x = find(x);
        y = find(y);
        if (x == y) return false;

        if (x <= y) parent[y] = x;
        else parent[x] = y;
        return true;
    }

    private static class Planet{
        int idx;
        int x;
        int y;
        int z;
        public Planet(int idx, int x, int y, int z){
            this.idx=idx;
            this.x=x;
            this.y=y;
            this.z=z;

        }
    }


    private static class Node {
        int x;
        int y;
        int dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
