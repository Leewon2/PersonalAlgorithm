import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        boolean[][] visited = new boolean[n+2][m+2];
        int[][] arr = new int[n+2][m+2];
        for(int i=0; i<puddles.length; i++){
            int y = puddles[i][0];
            int x = puddles[i][1];
            visited[x][y] = true;
        }
        arr[n][m] = 1;
        for(int r=n; r>=1; r--){
            for(int c=m; c>=1; c--){
                if(visited[r][c]) continue;
                int right = arr[r][c+1];
                int down = arr[r+1][c];
                if(visited[r][c+1]){
                    arr[r][c] = Math.max(arr[r][c],arr[r+1][c]) % 1000000007;
                }else if(visited[r+1][c]){
                    arr[r][c] = Math.max(arr[r][c], arr[r][c+1]) % 1000000007;
                }else{
                    arr[r][c] = Math.max(arr[r][c],right+down) % 1000000007;
                }
            }
        }
        int answer = arr[1][1];
        return answer;
    }
}