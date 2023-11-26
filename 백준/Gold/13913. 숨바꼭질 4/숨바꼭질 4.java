
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> q = new ArrayDeque<>();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        q.offer(N);
        int[] arr=new int[100001];
        int[] parent = new int[100001];
        StringBuilder sb = new StringBuilder();

        int min = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int poll = q.poll();
            arr[N]=1;
            if(poll == K) break;

            for (int i = 0; i < 3; i++) {
                int num =0;
                if(i==0) num = poll+1;
                else if(i==1) num = poll-1;
                else if(i==2) num = poll*2;
                if(num<0 || num > 100000) continue;
                if(arr[num]==0){
                    q.offer(num);
                    arr[num]=arr[poll]+1;
                    parent[num] = poll;
                }
            }
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(K);
        int index = K;

        while (index != N) {
            stack.push(parent[index]);
            index = parent[index];
        }

        // 최종 출력
        sb.append(arr[K] - 1 + "\n");
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }

        System.out.println(sb.toString());
    }
    private static class Node{
        int location;
        int time;
        String list;

        public Node(int location, int time, String list) {
            this.location=location;
            this.time = time;
            this.list = list;
        }
    }
}
