import java.util.*;
class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        int[] res = new int[n+1];
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }
        for(int i=0; i<roads.length; i++){
            int x = roads[i][0];
            int y = roads[i][1];
            list.get(x).add(y);
            list.get(y).add(x);
        }
        Arrays.fill(res,Integer.MAX_VALUE);
        res[destination]=0;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->{
            return o1.dist-o2.dist;
        });
        boolean[] use = new boolean[n+1];
        pq.offer(new Node(destination,0));
        while(!pq.isEmpty()){
            Node poll = pq.poll();
            if(use[poll.x]) continue;
            use[poll.x]=true;
            res[poll.x]=poll.dist;
            for(int i=0; i<list.get(poll.x).size(); i++){
                pq.offer(new Node(list.get(poll.x).get(i),poll.dist+1));
            }
        }
        int idx=0;
        for(int i=0; i<sources.length; i++){
            if(res[sources[i]]==Integer.MAX_VALUE) answer[idx++] = -1;
            else answer[idx++] = res[sources[i]];
        }
        return answer;
    }
    private static class Node{
        int x;
        int dist;
        public Node(int x, int dist){
            this.x=x;
            this.dist=dist;
        }
    }
}