import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        PriorityQueue<Tired> pq = new PriorityQueue<>((o1,o2)->{
            return o2.sum-o1.sum;
        });
        int pickCnt = picks[0]+picks[1]+picks[2];
        for(int i=0; i<pickCnt; i++){
            int[] p = new int[5];
            int sum=0;
            int idx=0;
            for(int j=i*5; j<Math.min(i*5+5,minerals.length); j++){
                if(minerals[j].equals("diamond")){
                    p[idx++]=25;
                    sum+=25;
                }else if(minerals[j].equals("iron")){
                    p[idx++]=5;
                    sum+=5;
                }else{
                    p[idx++]=1;
                    sum+=1;
                }
            }
            if(p[0]!=0) pq.add(new Tired(p,sum));
        }
        for(int i=0; i<picks.length; i++){
            if(picks[i]==0) continue;
            if(pq.size()==0) break;
            
            picks[i]--;
            Tired poll = pq.poll();
            if(i==0){
                for(int j : poll.pick) {
                    if(j!=0) answer++;
                }
            }
            else if(i==1){
                for(int j=0; j<poll.pick.length; j++){
                    if(poll.pick[j]==0) break;
                    if(poll.pick[j]==25) answer+=5;
                    else answer+=1;
                }
            }else{
                for(int j=0; j<poll.pick.length; j++){
                    if(poll.pick[j]==0) break;
                    answer+=poll.pick[j];
                }
            }
            i--;
            
        }
        return answer;
    }
    private class Tired{
        int[] pick;
        int sum;
        public Tired(int[] pick, int sum){
            this.pick=pick;
            this.sum=sum;
        }
    }
}