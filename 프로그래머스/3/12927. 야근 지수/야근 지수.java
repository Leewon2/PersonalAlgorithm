import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        int cnt=0;
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<works.length; i++){
            pq.offer((long) works[i]);
        }
        while(cnt<n){
            long tmp = pq.poll()-1;
            if(tmp<=0) tmp=0;
            pq.offer(tmp);
            cnt++;
        }
        while(!pq.isEmpty()){
            long tmp = pq.poll();
            answer+=(tmp*tmp);
        }
        return answer;
    }
}