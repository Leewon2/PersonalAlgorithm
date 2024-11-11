import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        for(int i=0; i<scoville.length; i++) pq.offer((long) scoville[i]);
        
        while(pq.size()>1){
            long food1 = pq.peek();
            if(food1<K){
                food1 = pq.poll();
                long food2 = pq.poll();
                answer++;
                pq.offer(food1+food2*2);
            }else break;
        }
        answer = (pq.peek()>=K ? answer : -1 );
        return answer;
    }
}