import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->{
            return o1.dist-o2.dist;
        });
        List<List<Node>> list = new ArrayList<>();
        for(int i=0; i<=N; i++){
            list.add(new ArrayList<>());
        }
        for(int i=0; i<road.length; i++){
            list.get(road[i][0]).add(new Node(road[i][1],road[i][2]));
            list.get(road[i][1]).add(new Node(road[i][0],road[i][2]));
            if(road[i][0]==1) pq.offer(new Node(road[i][1],road[i][2]));
            if(road[i][1]==1) pq.offer(new Node(road[i][0],road[i][2]));
        }
        int[] dp = new int[N+1];
        boolean[] use = new boolean[N+1];
        use[1]=true;
        while(!pq.isEmpty()){
            Node poll = pq.poll();
            if(use[poll.num]) continue;
            dp[poll.num] = poll.dist;
            use[poll.num] = true;
            for(int i=0; i<list.get(poll.num).size(); i++){
                Node node = list.get(poll.num).get(i);
                if(use[node.num]) continue;
                pq.offer(new Node(node.num,node.dist+poll.dist));
            }
        }
        for(int i=1; i<=N; i++){
            if(dp[i]<=K) answer++;
        }
        return answer;
    }
    private class Node{
        int num;
        int dist;
        public Node(int num, int dist){
            this.num=num;
            this.dist=dist;
        }
    }
}