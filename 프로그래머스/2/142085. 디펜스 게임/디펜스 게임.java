import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;
        
        for(int i=0; i<enemy.length; i++){
            pq.offer(enemy[i]);
            if(pq.size()>k){
                n-=pq.poll();
                if(n>=0) answer++;
                else break;
            }
        }
        answer+=pq.size();
        return answer;
    }
}