

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Node> q = new ArrayDeque<>();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        q.offer(new Node(N, 0));
        // 방법의 수
        int[] arr=new int[200001];
        Arrays.fill(arr,Integer.MAX_VALUE);
        int max = 0;
        // 가장 빠른 시간
        int min = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Node poll = q.poll();
            int location = poll.location;
//            System.out.println(location);
            int time = poll.time;
            if(time > min) continue;
            if(location==K){
                if(min>time){
                    min = time;
                    max=1;
                }else if(min==time){
                    max++;
                }
                continue;
            }
            // 동생한테 도달했을 때, 최댓값과 같다면 +1
            // 최댓값이 갱신된다면 최댓값 = 1로 개싱
            if(location-1>=0 && min>=time+1 && arr[location-1]>=time+1){
                arr[location-1] = time+1;
                q.offer(new Node(location - 1, time + 1));
            }
            if(location+1<=200000 && min>=time+1 && arr[location+1]>=time+1){
                arr[location+1] = time+1;
                q.offer(new Node(location + 1, time + 1));
            }
            if(location*2<=200000 && min>=time+1 && arr[location*2]>=time+1){
                arr[location*2] = time+1;
                q.offer(new Node(location * 2, time + 1));
            }
        }
        System.out.println(min);
        System.out.println(max);
    }
    private static class Node{
        int location;
        int time;

        public Node(int location, int time) {
            this.location=location;
            this.time = time;
        }
    }
}
