class Solution {
    final int[] dr = {1,1,1,-1,-1,-1,0,0};
    final int[] dc = {1,0,-1,1,0,-1,1,-1};
    public int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        boolean[][] visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]==1){
                    visited[i][j]=true;
                    for(int d=0 ;d<8; d++){
                        int nr = i+dr[d];
                        int nc = j+dc[d];
                        if(nr<0 || nc<0 || nr>=n || nc>=n) continue;
                        visited[nr][nc]=true;
                    }
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]) answer++;
            }
        }
        return answer;
    }
}