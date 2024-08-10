import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        List<List<Node>> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(new ArrayList<>());
        }
        
        boolean[] visited =new boolean[n];
        
        for(int i=0; i<costs.length; i++){
            int x = costs[i][0];
            int y = costs[i][1];
            int cost = costs[i][2];
            list.get(x).add(new Node(y,cost));
            list.get(y).add(new Node(x,cost));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->{
            return o1.cost-o2.cost;
        });
        pq.offer(new Node(0,0));
        while(!pq.isEmpty()){
            Node poll = pq.poll();
            if(visited[poll.x]) continue;
            visited[poll.x]=true;
            boolean check = true;
            for(int i=0; i<n; i++){
                if(!visited[i]){
                    check = false;
                    break;
                } 
            }
            answer+=poll.cost;            
            if(check) return answer;

            for(int i=0; i<list.get(poll.x).size(); i++){
                int edge = list.get(poll.x).get(i).x;
                int cost = list.get(poll.x).get(i).cost;
                if(!visited[edge]){
                    pq.offer(new Node(edge,cost));
                }
            }
        }
        return answer;
    }
    
    private static class Node{
        int x;
        int cost;
        public Node(int x, int cost){
            this.x=x;
            this.cost=cost;
        }
    }
}