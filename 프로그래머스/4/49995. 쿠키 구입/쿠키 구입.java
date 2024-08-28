import java.util.*;
class Solution {
    public int solution(int[] cookie) {
        int answer = 0;
        if(cookie.length==1) return 0;
        for(int i=0; i<cookie.length-1; i++){
            int leftIdx=i;
            int rightIdx=i+1;
            int left=cookie[leftIdx];
            int right=cookie[rightIdx];
            while(true){
                if(left==right){
                    answer = Math.max(left, answer);
                    if(leftIdx==0 || rightIdx==cookie.length-1) break;
                    left += cookie[--leftIdx];
                    right += cookie[++rightIdx];
                    
                }else if(left<right){
                    if(leftIdx==0) break;
                    
                    left += cookie[--leftIdx];
                    
                }else{
                    if(rightIdx==cookie.length-1) break;
                    right += cookie[++rightIdx];
                }
                
                
            }
        }
        
        return answer;
    }
}