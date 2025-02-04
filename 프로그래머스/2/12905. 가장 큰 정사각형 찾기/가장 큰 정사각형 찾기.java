import java.util.*;
class Solution
{
    public int solution(int [][]board)
    {
        int r = board.length;
        int c = board[0].length;
        if(r==1){
            for(int i=0; i<c; i++){
                if(board[0][i]==1) return 1;
            }
            return 0;
        }
        if(c==1){
            for(int i=0; i<r; i++){
                if(board[i][0]==1) return 1;
            }
            return 0;
        }
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
            for(int j=c-1; j>=1; j--){
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
//         for(int i=c-1; i>=1; i--){
//             for(int j=0; j<r; j++){
//                 if(answer>=suffix[j][i]) continue;
//                 boolean check = true;
//                 int max = suffix[j][i];
//                 for(int k=0; k<max; k++){
//                     if(j+k>=r) {
//                         check = false;
//                         break;
//                     }
//                     if(suffix[j+k][i]>=max) {
//                         answer = Math.max(answer,k+1);
//                     }
//                     else {
//                         max = suffix[j+k][i];
//                         answer = Math.max(Math.min(k+1,max),answer);
//                     }
//                     if(max<=answer){
//                         break;
//                     }
                    
//                 }
//             }
//         }
        // for(int i=r-1; i>=0; i--){
        //     for(int j=c-1; j>=1; j--){
        //         if(answer>=suffix[i][j]) continue;
        //         boolean check = true;
        //         int max = suffix[i][j];
        //         for(int k=0; k<max; k++){
        //             if(i-k<0) {
        //                 break;
        //             }
        //             if(suffix[i-k][j]>=max) {
        //                 answer = Math.max(answer,k+1);
        //             }
        //             else {
        //                 max = suffix[i-k][j];
        //                 answer = Math.max(Math.min(k+1,max),answer);
        //             }
        //             if(max<=answer){
        //                 break;
        //             }
        //         }
        //     }
        // }
        return answer*answer;
    }
}