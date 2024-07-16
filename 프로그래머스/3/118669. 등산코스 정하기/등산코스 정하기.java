import java.util.*;
class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        boolean[] sumit = new boolean[n+1];
        boolean[] gate = new boolean[n+1];
        for(int i=0; i<summits.length; i++){
            sumit[summits[i]] = true;
        }
        for(int i=0; i<gates.length; i++){
            gate[gates[i]] = true;
        }
        List<List<Node>> list = new ArrayList<>();
        for(int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }
        for(int i=0; i<paths.length; i++){
            int x = paths[i][0];
            int y = paths[i][1];
            int d = paths[i][2];
            list.get(x).add(new Node(y,d));
            list.get(y).add(new Node(x,d));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->{
            // return o1.dist-o2.dist;
            if(o1.dist!=o2.dist){
                return o1.dist-o2.dist;
            }
            return o1.point-o2.point;
        });
        int number=0;
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<gates.length; i++){
            pq.clear();
            pq.offer(new Node(gates[i],0));
            int m=0;
            boolean[] visited = new boolean[n+1];
            visited[gates[i]] = true;
            while(!pq.isEmpty()){
                Node poll = pq.poll();
                visited[poll.point] = true;
                m = Math.max(m,poll.dist);
                if(sumit[poll.point]){
                    if(min==m){
                        if(poll.point<number){
                            number = poll.point;
                        }
                    }else if(min>m){
                        number = poll.point;
                        min = m;
                    }
                    
                    break;
                }
                for(int j=0; j<list.get(poll.point).size(); j++){
                    if(!visited[list.get(poll.point).get(j).point] && !gate[list.get(poll.point).get(j).point]){
                        pq.offer(list.get(poll.point).get(j));
                        // visited[list.get(poll.point).get(j).point] = true;
                    }
                    
                }
            }
        }

        int[] answer = {number,min};
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