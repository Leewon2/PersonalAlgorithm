import java.util.*;
class Solution {
    public long solution(int[] weights) {
        long answer=0;
        Map<Integer,Long> map = new HashMap<>();
        for(int i : weights){
            map.put(i,map.getOrDefault(i,0L)+1L);
        }
        Arrays.sort(weights);
        
        for(int i : weights){
            // 2배차이, 2/3곱한 값 차이, 4/3곱한 값 차이
            answer+=(map.get(i)-1);
            answer+=(map.getOrDefault(i*2,0L));
            if(i%3==0){
                answer+=(map.getOrDefault(i/3*4,0L));
            }
            if(i%2==0){
                answer+=(map.getOrDefault(i/2*3,0L));
                
            }
            
            map.put(i,map.get(i)-1);
        }
        return answer;
    }

}