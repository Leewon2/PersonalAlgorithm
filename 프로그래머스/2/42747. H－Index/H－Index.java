import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int len = citations[citations.length-1];
        for(int i=0; i<=len; i++){
            int idx = Arrays.binarySearch(citations,i);
            if(idx<0){
                idx = Math.abs(idx)-1;
                if(idx>=citations.length) break;
            }
            // System.out.println(idx);
            if(citations.length-idx>=i && idx<i){
                answer = i;
            } 
            
        }
        return answer;
    }
}