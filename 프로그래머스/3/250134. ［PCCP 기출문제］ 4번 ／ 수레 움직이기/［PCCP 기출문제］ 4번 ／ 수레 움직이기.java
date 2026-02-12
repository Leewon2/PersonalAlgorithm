class Solution {
    int max;
    int[] dr = {1,0,-1,0};
    int[] dc = {0,1,0,-1};
    int r;
    int c;
    boolean[][] redVisited;
    boolean[][] blueVisited;
    int[][] arr;
    public int solution(int[][] maze) {
        max = Integer.MAX_VALUE;
        r = maze.length;
        c = maze[0].length;
        redVisited = new boolean[r][c];
        blueVisited = new boolean[r][c];
        arr = new int[r][c];
        int redStartR=0, redStartC=0, blueStartR=0, blueStartC=0;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(maze[i][j]==1){
                    redStartR=i;
                    redStartC=j;
                }else if(maze[i][j]==2){
                    blueStartR=i;
                    blueStartC=j;
                }else{
                    arr[i][j] = maze[i][j];
                }
            }
        }
        redVisited[redStartR][redStartC] = true;
        blueVisited[blueStartR][blueStartC] = true;
        dfs(redStartR,redStartC,blueStartR,blueStartC,0);
        return max==Integer.MAX_VALUE ? 0 : max;
    }
    
    private void move(int moveR, int moveC, int fixR, int fixC, int cnt, boolean[][] visited, boolean color){
        for(int d=0; d<4; d++){
            int nr = moveR+dr[d];
            int nc = moveC+dc[d];
            if(nr<0 || nr>=r || nc<0 || nc>=c || arr[nr][nc]==5 || visited[nr][nc]) continue;
            if(nr==fixR && nc==fixC) continue;
            visited[nr][nc]=true;
            if(color) dfs(fixR,fixC,nr, nc, cnt+1);
            else dfs(nr, nc, fixR, fixC, cnt+1);
            visited[nr][nc]=false;
        }
    }
    
    private void movement(int fMoveR, int fMoveC, int sMoveR, int sMoveC, int cnt, boolean[][] fV, boolean[][] sV, boolean color){
        for(int d=0; d<4; d++){
            int nr = fMoveR+dr[d];
            int nc = fMoveC+dc[d];
            if(nr<0 || nr>=r || nc<0 || nc>=c || arr[nr][nc]==5 || fV[nr][nc]) continue;
            if(nr==sMoveR && nc==sMoveC) continue;
            for(int dd=0 ;dd<4; dd++){
                int bnr = sMoveR+dr[dd];
                int bnc = sMoveC+dc[dd];
                if(bnr<0 || bnr>=r || bnc<0 || bnc>=c || arr[bnr][bnc]==5 || sV[bnr][bnc]) continue;
                if(nr==bnr && nc==bnc) continue;
                fV[nr][nc]=true;
                sV[bnr][bnc]=true;
                if(color) dfs(nr,nc,bnr, bnc,cnt+1);
                else dfs(bnr,bnc,nr, nc,cnt+1);
                fV[nr][nc]=false;
                sV[bnr][bnc]=false;
            }
        }
    }
    
    // 빨 - 파, 파 - 빨 둘 다 확인
    private void dfs(int redR, int redC, int blueR, int blueC, int cnt){
        if(arr[redR][redC]==3 && arr[blueR][blueC]==4){
            max = Math.min(max, cnt);
            return;
        }
        if(arr[redR][redC]==3){
            move(blueR, blueC, redR, redC, cnt, blueVisited,true);
        }else if(arr[blueR][blueC]==4){
            move(redR, redC, blueR, blueC, cnt, redVisited,false);
        }
        else{
            movement(redR, redC, blueR, blueC, cnt, redVisited, blueVisited, true);
            movement(blueR, blueC, redR, redC, cnt, blueVisited, redVisited, false);
        }
    }
}