import java.util.*;
class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int maxA=0;
        int maxC=0;
        for(int i=0; i<problems.length; i++){
            maxA = Math.max(maxA, problems[i][0]);
            maxC = Math.max(maxC, problems[i][1]);
        }
        int[][] dp = new int[maxA+1][maxC+1];
        alp = Math.min(alp, maxA);
        cop = Math.min(cop, maxC);
        for(int i=0; i<=maxA; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[alp][cop]=0;
        for(int i=alp; i<=maxA; i++){
            for(int j=cop; j<=maxC; j++){
                if(i<maxA){
                    dp[i+1][j] = Math.min(dp[i+1][j],dp[i][j]+1);
                }
                if(j<maxC){
                    dp[i][j+1] = Math.min(dp[i][j+1],dp[i][j]+1);
                }
                for(int k=0; k<problems.length; k++){
                    if(problems[k][0]<=i && problems[k][1]<=j){
                        int newA = Math.min(maxA, i+problems[k][2]);
                        int newC = Math.min(maxC, j+problems[k][3]);
                        dp[newA][newC] = Math.min(dp[newA][newC],dp[i][j]+problems[k][4]);
                    }
                }
            }
        }
        
        return dp[maxA][maxC];
    }
}