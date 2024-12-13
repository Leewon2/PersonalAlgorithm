import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long q1 = 0;
        long q2 = 0;
        Queue<Integer> qu1 = new LinkedList<>();
        Queue<Integer> qu2 = new LinkedList<>();
        for(int i=0; i<queue1.length; i++){
            q1 += (long) queue1[i];
            q2 += (long) queue2[i];
            qu1.offer(queue1[i]);
            qu2.offer(queue2[i]);
        }
        while(q1!=q2){
            if(answer>queue1.length*3) return -1;
            if(q1>q2){
                int k = qu1.poll();
                q1-=(long) k;
                q2+=(long) k;
                qu2.offer(k);
            }else{
                int k = qu2.poll();
                q2-=(long) k;
                q1+=(long) k;
                qu1.offer(k);
            }
            answer++;
        }
        return answer;
    }
}