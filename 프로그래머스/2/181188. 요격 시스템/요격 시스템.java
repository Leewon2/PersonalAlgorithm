import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        // pq로 s 기준으로 뽑고, 그 e가 어디에 해당하는지 확인
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->{
            if(o1[0]==o2[0]) return o1[1]-o2[1];
            return o1[0]-o2[0];
        });
        for(int i=0; i<targets.length; i++){
            pq.offer(new int[]{targets[i][0],targets[i][1]});
        }
        while(!pq.isEmpty()){
            int[] poll = pq.poll();
            int s = poll[0];
            int e = poll[1];
            answer++;
            while(!pq.isEmpty()){
                if(pq.peek()[0]<e){
                    e = Math.min(e, pq.poll()[1]);
                }else break;
            }
        }
        return answer;
    }
}