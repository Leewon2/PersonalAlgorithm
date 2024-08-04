import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int min = 0;
        int max = distance;
        Arrays.sort(rocks);
        while(min<=max){
            int mid = (min+max)/2;
            int pre = 0;
            int cnt = 0;
            for(int rock : rocks){
                if(rock-pre < mid) cnt++;
                else pre = rock;
            }
            if(distance - pre < mid) cnt++;
            
            if(cnt>n) max = mid-1;
            
            else {
                answer = mid;
                min = mid+1;
            }
        }
        
        return answer;
        
    }
}