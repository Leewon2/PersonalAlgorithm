import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        int max=0;
        for(int i=0; i<progresses.length; i++){
            int k = ((100-progresses[i])%speeds[i]==0) ? (100-progresses[i])/speeds[i] : (100-progresses[i])/speeds[i]+1;
            if(k>max){
                int cnt=0;
                while(!q.isEmpty()){
                    q.poll();
                    cnt++;
                }
                if(cnt!=0) list.add(cnt);
                q.offer(k);
                max=k;
            }else{
                q.offer(k);
            }
        }
        int cnt=0;
        while(!q.isEmpty()){
            q.poll();
            cnt++;
        }
        if(cnt!=0) list.add(cnt);
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}