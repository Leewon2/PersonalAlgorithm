import java.util.*;
class Solution {
    int[] arr;
    List<Integer> infect;
    Queue<Integer> q;
    List<List<Node>> list;
    int answer;
    int nn;
    public int solution(int n, int infection, int[][] edges, int k) {
        answer = 0;
        nn = n;
        list = new ArrayList<>();
        for(int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }
        
        for(int[] i : edges){
            list.get(i[0]).add(new Node(i[1],i[2]));
            list.get(i[1]).add(new Node(i[0],i[2]));
        }
        arr = new int[k];
        perm(0,0,k,infection);
        return answer;
    }
    
    // 순열인데 이전거랑 같을 필요는 없을듯
    private void perm(int idx, int pre, int k, int infection){
        if(idx==k){
            infect = new ArrayList<>();
            infect.add(infection);
            
            q = new LinkedList<>();
            q.offer(infection);
            answer = Math.max(answer, calculate());
            return;
        }
        
        for(int i=1; i<=3; i++){
            if(i==pre) continue;
            arr[idx] = i;
            perm(idx+1, i, k, infection);
        }
    }
    
    private int calculate(){
        for(int i=0; i<arr.length; i++){
            int type = arr[i];
            boolean[] visited = new boolean[nn+1];
            for(int infe : infect){
                q.offer(infe);
                visited[infe] = true;
            }
            while(!q.isEmpty()){
                int kk = q.poll();
                for(int j=0; j<list.get(kk).size(); j++){
                    Node node = list.get(kk).get(j);
                    if(!visited[node.x] && node.type==type){
                        infect.add(node.x);
                        q.offer(node.x);
                        visited[node.x] = true;
                    }
                }
            }
        }
        return infect.size();
    }
    
    private class Node{
        int x;
        int type;
        public Node(int x, int type){
            this.x=x;
            this.type=type;
        }
    }
}