import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        Arrays.sort(times);
        long min = 0;
        long max = (long) times[times.length-1]*n;
        
        while(min<=max){
            long mid = (min+max)/2;
            long sum = 0;
            for(int t : times){
                sum+=(mid/t);
            }
            if(sum>=n) {
                answer=Math.min(answer,mid);
                max = mid-1;
            }
            else min = mid+1; 
        }
        
        return answer;
    }
}