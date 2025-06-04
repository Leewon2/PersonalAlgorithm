class Solution {
    int[] dr = {0,1,0,-1};
    int[] dc = {1,0,-1,0};
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        int r=0;
        int c=0;
        int d = 0;
        int idx=1;
        while(idx<=n*n){
            answer[r][c]=idx;
            visited[r][c]=true;
            int nr = r+dr[d%4];
            int nc = c+dc[d%4];
            if(nr<0 || nc<0 || nr>=n || nc>=n || visited[nr][nc]){
                d++;
                nr = r+dr[d%4];
                nc = c+dc[d%4];
            }
            r = nr;
            c = nc;
            idx++;
        }
        return answer;
    }
}