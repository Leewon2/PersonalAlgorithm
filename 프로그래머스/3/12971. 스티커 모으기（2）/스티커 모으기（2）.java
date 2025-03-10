class Solution {
    public int solution(int sticker[]) {
        if(sticker.length==1) return sticker[0];
        int[] dp = new int[sticker.length];
        int answer = 0;
        dp[0] = sticker[0];
        dp[1] = sticker[0];
        for(int i=2; i<sticker.length; i++){
            dp[i] = Math.max(dp[i-2]+sticker[i],dp[i-1]);
        }
        answer = dp[sticker.length-2];
        dp = new int[sticker.length];
        dp[0] = 0;
        dp[1] = sticker[1];
        for(int i=2; i<sticker.length; i++){
            dp[i] = Math.max(dp[i-2]+sticker[i],dp[i-1]);
        }
        return Math.max(answer,dp[sticker.length-1]);
    }

}