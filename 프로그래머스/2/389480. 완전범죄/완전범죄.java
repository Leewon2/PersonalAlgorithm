import java.util.*;
class Solution {
    public int solution(int[][] info, int n, int m) {
        int len = info.length;
        int INF = 10000000;
        int [][] dp = new int [len+1][m];
        for(int i = 0; i <= len; i++){
            Arrays.fill(dp[i], INF);
        }
        dp[0][0] = 0;
        for(int i = 1; i <= len; i++){
            for(int j = 0; j < m; j++){
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + info[i-1][0]);
                if(j + info[i-1][1] < m){
                    dp[i][j + info[i-1][1]] = Math.min(dp[i][j + info[i-1][1]], dp[i-1][j]);
                }
            }    
        }
        int min = INF;
        for(int j = 0; j < m; j++){
            min = Math.min(dp[len][j], min);
        }
        return min >= n ? -1 : min;
    }
}