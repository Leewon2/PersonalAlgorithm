class Solution {
    public int[] solution(int target) {
        int[] answer = new int[2];
        int[][] dp = new int[target+1][2];
        for(int i=1; i<=target; i++){
            dp[i][0] = Integer.MAX_VALUE;
        }
        for(int i=1; i<=target; i++){
            for(int j=1; j<=20; j++){
                if(i-50>=0){
                    if(dp[i][0]>dp[i-50][0]+1){
                        dp[i][0] = dp[i-50][0]+1;
                        dp[i][1] = dp[i-50][1]+1;
                    }else if(dp[i][0]==dp[i-50][0]+1){
                        dp[i][1] = Math.max(dp[i][1], dp[i-50][1]+1);
                    }
                }
                for(int k=1; k<=3; k++){
                    if(i-j*k>=0){
                        if(dp[i][0] > dp[i-j*k][0]+1){
                            dp[i][0] = dp[i-j*k][0]+1;
                            dp[i][1] = dp[i-j*k][1];
                            if(k==1) dp[i][1] = dp[i-j*k][1]+1;
                            
                        }else if(k==1 && dp[i][0]==dp[i-j*k][0]+1){
                            dp[i][1] = Math.max(dp[i][1], dp[i-j*k][1]+1);
                        }
                        
                    }
                }
            }
            
        }
        answer[0] = dp[target][0];
        answer[1] = dp[target][1];
        return answer;
    }
}