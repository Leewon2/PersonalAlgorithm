import java.util.*;
class Solution
{
    public int solution(int [][]board)
    {
        int r = board.length;
        int c = board[0].length;
        int answer = 1;
        int[][] suffix = new int[r][c];
        for(int i=0; i<r; i++){
            suffix[i][0]=board[i][0];
            for(int j=1;j<c;j++){
                if(board[i][j]==0) {
                    suffix[i][j]=0;
                    continue;
                }
                suffix[i][j] = suffix[i][j-1]+board[i][j];
            }
        }
        // 1인거 찾기
        for(int i=0; i<r; i++){
            for(int j=c-1; j>=0; j--){
                if(answer>=suffix[i][j]) continue;
                boolean check = true;
                for(int k=0; k<suffix[i][j]; k++){
                    if(i+k>=r || k>=c || suffix[i+k][j]<suffix[i][j]) {
                        check = false;
                        break;
                    }
                }
                if(check) answer = suffix[i][j];
            }
        }
        // 0인거 찾기
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                board[i][j] = Math.abs(board[i][j]-1);
            }
        }
        suffix = new int[r][c];
        for(int i=0; i<r; i++){
            suffix[i][0]=board[i][0];
            for(int j=1;j<c;j++){
                if(board[i][j]==0) {
                    suffix[i][j]=0;
                    continue;
                }
                suffix[i][j] = suffix[i][j-1]+board[i][j];
            }
        }
        for(int i=0; i<r; i++){
            for(int j=c-1; j>=1; j--){
                if(answer>=suffix[i][j]) continue;
                boolean check = true;
                for(int k=0; k<suffix[i][j]; k++){
                    if(i+k>=r || k>=c || suffix[i+k][j]<suffix[i][j]) {
                        check = false;
                        break;
                    }
                }
                if(check) answer = Math.max(answer,suffix[i][j]);
            }
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.

        return answer*answer;
    }
}