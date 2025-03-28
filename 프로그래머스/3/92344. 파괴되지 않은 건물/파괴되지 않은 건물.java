import java.util.*;
class Solution {
    int[][] map;
    public int solution(int[][] board, int[][] skill) {
        int r = board.length;
        int c = board[0].length;
        map = new int[r+1][c+1];
        for(int[] s : skill){
            int power = s[5];
            int type = s[0]==1 ? -1 : 1;
            int r1 = s[1], c1=s[2], r2=s[3], c2=s[4];
            map[r1][c1] += power*type;
            map[r1][c2+1] += power*type*-1;
            map[r2+1][c1] += power*type*-1;
            map[r2+1][c2+1] += power*type;
        }
        //상하를 먼저 계산
        for(int i=0; i<c+1 ; i++){
            for(int j=0; j<r; j++){
                map[j+1][i]+=map[j][i];
            }
        }
        for(int i=0; i<r+1 ; i++){
            for(int j=0; j<c; j++){
                map[i][j+1]+=map[i][j];
            }
        }
        int answer = 0;
        
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(map[i][j]+board[i][j]>0) answer++;
            }
        }
        return answer;
    }
}