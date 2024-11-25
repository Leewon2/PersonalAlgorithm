import java.util.*;
class Solution {
    int answer;
    Node node;
    List<List<Integer>> list;
    public int solution(int n, int[][] edges) {
        answer = 0;
        list = new ArrayList<>();
        for(int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++){
            list.get(edges[i][0]).add(edges[i][1]);
            list.get(edges[i][1]).add(edges[i][0]);
        }
        // 임의의 점에서 가장 먼 노드 찾기
        findNode(edges[0][0],n,true);
        int firstNode = node.idx;
        if(!findNode(firstNode,n,false)){
            if(!findNode(node.idx,n,false)){
                answer = node.dist-1;
            }
        }
        return answer;
        
    }
    private boolean findNode(int idx, int n, boolean first) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(idx,0));
        boolean[] use = new boolean[n+1];
        use[idx] = true;
        PriorityQueue<Node> pq  = new PriorityQueue<>((o1,o2)->{
            if(o1.dist!=o2.dist) return o2.dist-o1.dist;
            return o1.idx-o2.idx;
        });
        while(!q.isEmpty()){
            Node poll = q.poll();
            for(int i=0; i<list.get(poll.idx).size(); i++){
                int k = list.get(poll.idx).get(i);
                if(use[k]) continue;
                pq.offer(new Node(k,poll.dist+1));
                q.offer(new Node(k,poll.dist+1));
                use[k]=true;
            }
        }
        if(first){
            node = pq.poll();
            return true;
        }
        Node d1 = pq.poll();
        Node d2 = pq.poll();
        if(d1.dist==d2.dist) {
            answer = d1.dist;
            return true;
        }
        node = d1;
        return false;
        
    }
    private class Node{
        int idx;
        int dist;
        public Node(int idx, int dist){
            this.idx=idx;
            this.dist=dist;
        }
    }
}