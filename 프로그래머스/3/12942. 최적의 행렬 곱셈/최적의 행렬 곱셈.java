import java.util.*;
class Solution {
    public int solution(int[][] matrix_sizes) {
        int[][] dp = new int[201][201];
        
        for(int i=0; i<matrix_sizes.length; i++){
            for(int j=0; j<matrix_sizes.length-i; j++){
                int range=j+i;
                if(j==range) {
                    dp[j][j]=0;
                    continue;
                }
                dp[j][range]=1800000000;
                for(int k=j; k<range; k++){
                    dp[j][range] = Math.min(dp[j][range],dp[j][k]+dp[k+1][range]+(
                    matrix_sizes[j][0]*matrix_sizes[k][1]*matrix_sizes[range][1]));
                }
                
            }
        }
        
        return dp[0][matrix_sizes.length-1];
    }
}