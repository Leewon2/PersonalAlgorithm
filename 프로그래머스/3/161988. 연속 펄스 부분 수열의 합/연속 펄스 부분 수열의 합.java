import java.util.*;
class Solution {
    public long solution(int[] sequence) {
        long answer = Long.MIN_VALUE;
        long[] dp = new long[sequence.length];
        
        // 시작이 -1인 경우
        dp[sequence.length-1] = sequence[sequence.length-1]*-1;
        answer = Math.max(dp[sequence.length-1],answer);
        
        for(int i=sequence.length-2; i>=0; i--){
            // 홀수인 경우
            // 1을 곱해야 하는 경우
            if(i%2==(sequence.length)%2){
                dp[i] = Math.max(sequence[i], dp[i+1]+sequence[i]*1);    
            }else{
                dp[i] = Math.max(sequence[i]*-1, dp[i+1]+sequence[i]*-1);
            }
            answer = Math.max(answer,dp[i]);
        }
        
        // 시작이 1인 경우
        
        dp[sequence.length-1] = sequence[sequence.length-1];
        answer = Math.max(dp[sequence.length-1],answer);
        
        for(int i=sequence.length-2; i>=0; i--){
            // 홀수인 경우
            // 1을 곱해야 하는 경우
            if(i%2!=(sequence.length)%2){
                dp[i] = Math.max(sequence[i], dp[i+1]+sequence[i]*1);    
            }else{
                dp[i] = Math.max(sequence[i]*-1, dp[i+1]+sequence[i]*-1);
            }
            answer = Math.max(answer,dp[i]);
        }
        return answer;
    }
}