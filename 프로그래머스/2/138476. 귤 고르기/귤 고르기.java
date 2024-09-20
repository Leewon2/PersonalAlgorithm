import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<tangerine.length; i++){
            if(map.get(tangerine[i])==null){
                map.put(tangerine[i],1);
            }else{
                map.put(tangerine[i],map.get(tangerine[i])+1);
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int key : map.keySet()){
            pq.offer(map.get(key));
        }
        while(!pq.isEmpty()){
            answer++;
            k-=pq.poll();
            if(k<=0) break;
        }
        return answer;
    }
}