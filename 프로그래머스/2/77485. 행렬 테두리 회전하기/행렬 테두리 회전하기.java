import java.util.*;
class Solution {
    int[] dr={0,1,0,-1};
    int[] dc={1,0,-1,0};
    public int[] solution(int rows, int columns, int[][] queries) {
        List<Integer> answer = new ArrayList<>();
        int[][] map = new int[rows+1][columns+1];
        for(int i=1; i<=rows; i++){
            for(int j=1; j<=columns; j++){
                map[i][j]=(columns*(i-1))+j;
            }
        }

        for(int[] q : queries){
            int r = q[0];
            int c = q[1];
            int min = map[r][c];
            
            int pre = map[r][c];
            int idx=0;
            while(idx<4){
                int nr = r+dr[idx];
                int nc = c+dc[idx];
                if(nr<q[0] || nc<q[1] || nr>q[2] || nc>q[3]){
                    idx++;
                }else{
                    int now = map[nr][nc];
                    min=Math.min(min,now);
                    map[nr][nc] = pre;
                    pre = now;
                    r=nr;
                    c=nc;
                    
                }
            }
            answer.add(min);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}