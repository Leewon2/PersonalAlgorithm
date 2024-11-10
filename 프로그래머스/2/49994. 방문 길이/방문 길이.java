import java.util.*;
class Solution {
    int[] dr = {-1,1,0,0};
    int[] dc = {0,0,1,-1};
    public int solution(String dirs) {
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('U',0);map.put('D',1);map.put('R',2);map.put('L',3);
        int[][] arr = new int[21][21];
        int r=10, c=10;
        arr[r][c]=1;
        for(int i=0; i<dirs.length(); i++){
            int dir = map.get(dirs.charAt(i));
            for(int j=0; j<2; j++){
                int nr = r+dr[dir];
                int nc = c+dc[dir];
                if(nr<0 || nc<0 || nr>=21 || nc>=21) continue;
                r = nr; c = nc;
                arr[nr][nc]=1;
            }
        }
        for(int i=0; i<21; i++){
            for(int j=0; j<21; j++){
                if(arr[i][j]==1  && (i%2==1 || j%2==1)){
                    answer++;
                }
            }
        }
        return answer;
    }
}