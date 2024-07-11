import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        boolean[] visited = new boolean[n+1];
        int[] arr = new int[n+1];
        int answer = 0;
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }
        for(int i=0; i<edge.length; i++){
            int x = edge[i][0];
            int y = edge[i][1];
            list.get(x).add(y);
            list.get(y).add(x);
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->{
            return o1.dist-o2.dist;
        });
        pq.offer(new Node(1,0));
        visited[1]=true;
        while(!pq.isEmpty()){
            Node poll = pq.poll();
            for(int i=0; i<list.get(poll.point).size(); i++){
                if(visited[list.get(poll.point).get(i)]) continue;
                pq.offer(new Node(list.get(poll.point).get(i),poll.dist+1));
                arr[list.get(poll.point).get(i)] = poll.dist+1;
                visited[list.get(poll.point).get(i)] = true;
            }
        }
        int max = 0;
        for(int i=1; i<=n; i++){
            max = Math.max(max,arr[i]);
        }
        for(int i=1; i<=n; i++){
            if(arr[i]==max) answer++;
        }
        
        return answer;
        
    }
    private static class Node{
        int point;
        int dist;
        public Node(int point, int dist){
            this.point=point;
            this.dist=dist;
        }
    }
}