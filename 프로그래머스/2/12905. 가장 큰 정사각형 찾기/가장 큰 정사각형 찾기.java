import java.util.*;
class Solution
{
    public int solution(int [][]board)
    {
        int r = board.length;
        int c = board[0].length;
        int answer = 0;
        int[][] suffix = new int[r][c];
        for(int i=0; i<r; i++){
            suffix[i][0]=board[i][0];
            for(int j=1;j<c;j++){
                if(board[i][j]==0) continue;
                suffix[i][j] = suffix[i][j-1]+board[i][j];
            }
        }
        // 1인거 찾기
        for(int i=0; i<r; i++){
            if(r-i<=answer) break;
            for(int j=c-1; j>=0; j--){
                if(j+1<=answer) break;
                if(answer>=suffix[i][j]) continue;
                boolean check = true;
                int max = suffix[i][j];
                for(int k=0; k<max; k++){
                    if(i+k>=r) {
                        check = false;
                        break;
                    }
                    if(suffix[i+k][j]>=max) {
                        answer = Math.max(answer,k+1);
                    }
                    else {
                        max = suffix[i+k][j];
                        answer = Math.max(Math.min(k+1,max),answer);
                    }
                    if(max<=answer){
                        break;
                    }
                }
            }
        }
        return answer*answer;
    }
}