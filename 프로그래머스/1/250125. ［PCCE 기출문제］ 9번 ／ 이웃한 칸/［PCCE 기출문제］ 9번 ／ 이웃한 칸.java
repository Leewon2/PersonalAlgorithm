class Solution {
    int[] dr = {1,0,-1,0};
    int[] dc = {0,1,0,-1};
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int r = board.length;
        int c = board[0].length;
        String str = board[h][w];
        for(int i=0; i<4; i++){
            int nr = h+dr[i];
            int nc = w+dc[i];
            if(nr<0 || nc<0 || nr>=r || nc>=r) continue;
            if(board[nr][nc].equals(str)) answer++;
        }
        return answer;
    }
}