import java.util.*;
class Solution {
    public int solution(int[] money) {
        int[] dp = new int[money.length];
        dp[0]=money[0];
        dp[1]=money[1];
        dp[2]=money[0]+money[2];
        for(int i=3; i<money.length-1; i++){
            dp[i] = Math.max(dp[i-2]+money[i],dp[i-3]+money[i]);
        }
        int answer = Math.max(dp[money.length-2],dp[money.length-3]);
        dp[1]=money[1];
        dp[2] = money[2];
        dp[3] = money[1]+money[3];
        for(int i=4; i<money.length; i++){
            dp[i] = Math.max(dp[i-2]+money[i],dp[i-3]+money[i]);
        }
        answer = Math.max(answer,dp[money.length-1]);
        answer = Math.max(answer,dp[money.length-2]);
        
        return answer;
    }
}