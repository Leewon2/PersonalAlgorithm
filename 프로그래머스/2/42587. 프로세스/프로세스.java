import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Node> q = new LinkedList<>();
        for(int i=0; i<priorities.length; i++){
            q.offer(new Node(priorities[i],i));
        }
        Arrays.sort(priorities);
        int len = priorities.length-1;
        while(!q.isEmpty()){
            Node poll = q.poll();
            if(poll.num<priorities[len]) q.offer(poll);
            else{
                len--;
                if(poll.idx==location) return priorities.length-q.size();
            }
        }
        
        return answer;
    }
    
    private class Node{
        int num;
        int idx;
        public Node(int num, int idx){
            this.num=num;
            this.idx=idx;
        }
    }
}