import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->{
            String compareA = Integer.toString(o1)+Integer.toString(o2);
            String compareB = Integer.toString(o2)+Integer.toString(o1);
            return compareB.compareTo(compareA);
        });
        
        boolean allZero = true;
        for(int i=0; i<numbers.length; i++){
            if(numbers[i]>0) allZero=false;
            pq.offer(numbers[i]);
        }
        if(allZero) return "0";
        while(!pq.isEmpty()){
            sb.append(pq.poll());
        }
        
        return sb.toString();
    }
}