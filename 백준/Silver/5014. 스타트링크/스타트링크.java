import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 건물의 전체 층
        int F = Integer.parseInt(st.nextToken());
        // 현재 강호의 위치
        int S = Integer.parseInt(st.nextToken());
        // 스타트링크의 위치
        int G = Integer.parseInt(st.nextToken());
        // 한번에 위로 이동하는 수
        int U = Integer.parseInt(st.nextToken());
        // 아래로 이동하는 수
        int D = Integer.parseInt(st.nextToken());
        if(S==G){
            System.out.println(0);
            System.exit(0);
        }
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[F + 1];
        q.offer(new Node(S, 0));
        visited[S] = true;
        int res=0;
        while (!q.isEmpty()) {
            Node poll = q.poll();
            if(poll.now==G){
                res = poll.cnt;
                break;
            }
            int newUp = poll.now + U;
            int newDown = poll.now - D;
            if(newUp<=F && !visited[newUp]){
                visited[newUp] = true;
                q.offer(new Node(newUp, poll.cnt + 1));
            }

            if(newDown>=1 && !visited[newDown]){
                visited[newDown] = true;
                q.offer(new Node(newDown, poll.cnt + 1));
            }
        }
        if(res==0){
            System.out.println("use the stairs");
        }else{
        System.out.println(res);

        }
    }

    private static class Node{
        int now;
        int cnt;

        public Node(int now, int cnt) {
            this.now = now;
            this.cnt = cnt;
        }
    }

}
