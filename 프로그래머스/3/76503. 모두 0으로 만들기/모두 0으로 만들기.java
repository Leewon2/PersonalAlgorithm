import java.util.*;
class Solution {
    List<List<Integer>> list;
    
    public long solution(int[] a, int[][] edges) {
        long answer = 0;
        long[] count = new long[a.length];
        for(int i=0; i<a.length; i++){
            count[i] = a[i];
        }
        // root 찾기
        long sum=0;
        list = new ArrayList<>();
        for(int i=0; i<a.length; i++){
            sum+=a[i];
            list.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++){
            list.get(edges[i][0]).add(edges[i][1]);
            list.get(edges[i][1]).add(edges[i][0]);
        }
        if(sum!=0) return -1;
        boolean[] use = new boolean[a.length];
        
        // 자식이 가장 많은 애를 root로 설정
        use[0]=true;
        
        // 내 인덱스에 부모의 인덱스를 담기
        int[] parent = new int[a.length];
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0,0));
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->{
            return o2.depth-o1.depth;
        });
        while(!q.isEmpty()){
            Node poll = q.poll();
            for(int i=0; i<list.get(poll.idx).size(); i++){
                int idx = list.get(poll.idx).get(i);
                if(!use[idx]){
                    use[idx]=true;
                    q.offer(new Node(idx,poll.depth+1));
                    pq.offer(new Node(idx,poll.depth+1));
                    parent[idx]=poll.idx;
                }
            }
        }
        
        // 자식이 없는 leaf 찾기
        while(!pq.isEmpty()){
            // leaf 노드중 하나가 나옴.
            Node poll = pq.poll();
            // answer에 더하기
            answer+= (Math.abs(count[poll.idx]));
            // 부모에게 넘기기
            count[parent[poll.idx]] += (count[poll.idx]);
            
        }
        return answer;
    }
    
    private static class Node{
        int idx;
        int depth;
        public Node(int idx, int depth){
            this.idx=idx;
            this.depth=depth;
        }
    }
}
