import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        // 시작 시간 기준 오름차순
        Arrays.sort(jobs, (o1,o2)->o1[0]-o2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[1]-o2[1]);
        
        int idx=0;
        int cnt=0;
        int time=0;
        while(cnt<jobs.length){
            while(idx<jobs.length && jobs[idx][0]<=time){
                pq.offer(jobs[idx++]);
            }
            if(pq.isEmpty()){
                time = jobs[idx][0];
            }else{
                int[] j = pq.poll();
                time+=j[1];
                answer+=time-j[0];
                cnt++;
            }
            
        }
        
        return answer/jobs.length;
    }
}